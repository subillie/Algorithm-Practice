// 2805 농작물 수확하기
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d3_2805 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// Input
			int N = Integer.parseInt(br.readLine());
			int[][] farm = new int[N][N];
			for (int i = 0; i < N; i++) {
				char[] tmp = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					farm[i][j] = tmp[j] - '0';
				}
			}

			// Logic
			int sum = 0;
			int half = (int)(N / 2);
			int startIndex = 0;
			int endIndex = N;
			for (int i = 0; i < half + 1; i++) {
				for (int j = startIndex; j < endIndex; j++) {
					sum += farm[half - i][j];
					if (i != 0) {
						sum += farm[half + i][j];
					}
				}
				startIndex++;
				endIndex--;
			}

			// Output
			sb.append("#").append(t).append(" ").append(sum).append("\n");
		}
		System.out.println(sb.toString());
	}
}