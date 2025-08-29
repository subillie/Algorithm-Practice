// 17144 미세먼지 안녕!
import java.io.*;
import java.util.*;

public class g4_17144 {
	private static int R, C, T, purifier;
	private static int[][] mat;
	
	private static final int[] dy = {-1, 0, 1, 0};
	private static final int[] dx = {0, 1, 0, -1};

	private static void spreadPM() {
		// 임시 배열에 변화량 계산
		int[][] change = new int[R][C];
		for (int y = 0; y < R; y++) {
			for (int x = 0; x < C; x++) {
				if (mat[y][x] == -1) {
					continue;
				}
				int amount = mat[y][x] / 5;  // 확산량
				for (int i = 0; i < 4; i++) {
					int ny = y + dy[i];
					int nx = x + dx[i];
					// 주변 네 칸 중, 배열을 넘어가지 않고 공기청정기가 없는 곳이면 확산
					if (0 <= ny && ny < R && 0 <= nx && nx < C && mat[ny][nx] != -1) {
						change[ny][nx] += amount;
						change[y][x] -= amount;
					}
				}
			}
		}
		
		// 계산된 변화량을 mat 배열에 적용
	    for (int i = 0; i < R; i++) {
	        for (int j = 0; j < C; j++) {
        		mat[i][j] += change[i][j];
	        }
	    }	
	}
	
	private static void purify() {
	    int top = purifier;
	    int bottom = purifier + 1;

	    // 위쪽 (반시계)
	    for (int i = top - 1; i > 0; i--) mat[i][0] = mat[i - 1][0];
	    for (int i = 0; i < C - 1; i++) mat[0][i] = mat[0][i + 1];
	    for (int i = 0; i < top; i++) mat[i][C - 1] = mat[i + 1][C - 1];
	    for (int i = C - 1; i > 1; i--) mat[top][i] = mat[top][i - 1];
	    mat[top][1] = 0;

	    // 아래쪽 (시계)
	    for (int i = bottom + 1; i < R - 1; i++) mat[i][0] = mat[i + 1][0];
	    for (int i = 0; i < C - 1; i++) mat[R - 1][i] = mat[R - 1][i + 1];
	    for (int i = R - 1; i > bottom; i--) mat[i][C - 1] = mat[i - 1][C - 1];
	    for (int i = C - 1; i > 1; i--) mat[bottom][i] = mat[bottom][i - 1];
	    mat[bottom][1] = 0;

	    // 공기 정화
	    mat[top][0] = -1;
	    mat[bottom][0] = -1;
	}
	
	public static void main(String[] args) throws Exception {
		// Input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		mat = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == -1 && purifier == 0) {
					purifier = i;
				}
				mat[i][j] = num;
			}
		}
		
		// Logic
		for (int time = 0; time < T; time++) {
			spreadPM();
			purify();
		}
		
		// Output
		int sum = 2;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sum += mat[i][j];
			}
		}
		System.out.println(sum);
	}
}
