// 1959 두 개의 숫자열
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d2_1959 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// Input
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[] A = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			int[] B = new int[M];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}

			if (N < M) {  // A가 항상 B보다 크거나 같도록 함
				int[] tmp = A;
				A = B;
				B = tmp;
			}

			// Logic
			int maxSum = 0;
			for (int i = 0; i <= A.length - B.length; i++) {
				int sum = 0;
				for (int j = 0; j < B.length; j++) {
					sum += A[i + j] * B[j];
				}
				maxSum = Math.max(maxSum, sum);
			}

			// Output
			sb.append("#").append(t).append(" ").append(maxSum).append("\n");
		}
		System.out.println(sb.toString());
	}
}
