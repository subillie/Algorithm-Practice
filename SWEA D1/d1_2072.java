// 2072 홀수만 더하기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d1_2072 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int sum = 0;
			for (int i = 0; i < 10; i++) {
				int num = Integer.parseInt(st.nextToken());
				if (num % 2 == 1) {
					sum += num;
				}
			}
			System.out.println("#" + t + " " + sum);
		}
	}
}