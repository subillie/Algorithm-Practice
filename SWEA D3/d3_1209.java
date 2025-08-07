// 1209 Sum
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d3_1209 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= 10; t++) {
			// 입력
			br.readLine();
			int[][] mat = new int[100][100];
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 100; j++) {
					mat[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// Logic
			int maxSum = Integer.MIN_VALUE;
			int posDiagonalSum = 0;
			int negDiagonalSum = 0;
			for (int i = 0; i < 100; i++) {
				// 가로합, 세로합
				int horizontalSum = 0;
				int verticalSum = 0;
				for (int j = 0; j < 100; j++) {
					horizontalSum += mat[i][j];
					verticalSum += mat[j][i];
				}
				maxSum = Math.max(maxSum, horizontalSum);
				maxSum = Math.max(maxSum, verticalSum);
				// 대각선합
				posDiagonalSum += mat[i][i];
				negDiagonalSum += mat[i][99 - i];
			}
			maxSum = Math.max(maxSum, posDiagonalSum);
			maxSum = Math.max(maxSum, negDiagonalSum);
			
			// 출력
			sb.append("#").append(t).append(" ").append(maxSum).append("\n");
		}
		System.out.println(sb.toString());
	}
}
