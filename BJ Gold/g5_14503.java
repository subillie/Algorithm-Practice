// 14503 로봇 청소기
import java.io.*;
import java.util.*;

public class g5_14503 {
	static int N, M;
	static int[][] mat;
	
	// 북-동-남-서
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	static class Pos {
		int y, x, d;
		
		Pos(int y, int x, int d) {
			this.y = y;
			this.x = x;
			this.d = d;
		}
	}
	
	static int bfs였던것(int y, int x, int d) {
		int count = mat[y][x] == 0 ? 0 : 1;
		Pos pos = new Pos(y, x, d);

		while (true) {
			// 1번 로직
			if (mat[pos.y][pos.x] == 0) {
				mat[pos.y][pos.x] = 2;
				count++;
			}
			
			boolean moved = false;
			int ny, nx;

			// 3번 로직
			for (int i = 0; i < 4; i++) {
				pos.d = (pos.d + 3) % 4;  // 반시계 방향 회전
				ny = pos.y + dy[pos.d];
				nx = pos.x + dx[pos.d];
				if (0 <= ny && ny < N && 0 <= nx && nx < M && mat[ny][nx] == 0) {
					pos.y = ny;
					pos.x = nx;
					moved = true;
					break;
				}
			}
			
			// 2번 로직
			if (!moved) {
				int backward = (pos.d + 2) % 4;
				ny = pos.y + dy[backward];
				nx = pos.x + dx[backward];
				if (0 <= ny && ny < N && 0 <= nx && nx < M && mat[ny][nx] != 1) {
					pos.y = ny;
					pos.x = nx;
				} else {
					break;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// Input
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		mat = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// Logic & Output
		System.out.println(bfs였던것(r, c, d));
	}
}
