// 9663 N-Queen
import java.io.*;

public class g4_9663 {
	static int N, count = 0;
	static int[] f;  // y = f[x] 방식으로 좌표 저장
	
	static void nQueen(int X) {
		// Base case
		if (X == N) {
			count++;
			return;
		}
		
		// Recursive case
		for (int y = 0; y < N; y++) {
			boolean canAttack = false;
			for (int x = 0; x < X; x++) {
				// y 좌표가 같거나 대각선에 위치해있으면 서로 공격 가능
				if (y == f[x] || Math.abs(X - x) == Math.abs(y - f[x])) {
					canAttack = true;
					break;
				}
			}
			if (!canAttack) {  // 서로 공격할 수 없으면
				f[X] = y;  // 좌표 저장
				nQueen(X + 1); // 다음 열로 이동
				// 모든 경우의 수를 확인해야 하므로 break하지 않음
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		f = new int[N];
		nQueen(0);
		System.out.println(count);
	}
}
