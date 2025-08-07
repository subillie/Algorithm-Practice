// 1206 View
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d3_1206 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= 10; t++) {
			// 입력
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N + 4];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			// Logic
			int leftMax, rightMax, max, sum = 0;
			for (int i = 2; i < N - 2; i++) {
				leftMax = Math.max(arr[i - 1], arr[i - 2]);
				rightMax = Math.max(arr[i + 1], arr[i + 2]);
				max = Math.max(leftMax, rightMax);
				if (arr[i] > max) {					
					sum += arr[i] - max;
				}
			}

			// 출력
			sb.append("#").append(t).append(" ").append(sum).append("\n");
		}
		System.out.println(sb.toString());
	}
}