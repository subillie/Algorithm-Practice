// 10726 이진수 표현
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d3_10726 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// Input
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			// Logic
			int x = (1 << N) - 1;  // 마지막 N개 비트
			// Output
			sb.append("#").append(t).append(" ").append((M & x) == x ? "ON" : "OFF").append("\n");
		}
		System.out.println(sb.toString());
	}
}
