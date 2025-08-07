// 1986 지그재그
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class d2_1986 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int sum = 0;
			for (int n = 1; n <= N; n++) {
				if (n % 2 == 1) {
					sum += n;
				} else {
					sum -= n;
				}
			}
			System.out.println("#" + t + " " + sum);
		}
	}
}