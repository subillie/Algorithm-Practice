//1984 중간 평균값 구하기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d2_1984 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			float sum = 0;
			float maxNum = Float.MIN_VALUE;
			float minNum = Float.MAX_VALUE;
			for (int i = 0; i < 10; i++) {
				float num = Float.valueOf(st.nextToken());
				sum += num;
				maxNum = Math.max(maxNum, num);
				minNum = Math.min(minNum, num);
			}
			sum -= maxNum + minNum;
			System.out.printf("#%d %d\n", t, Math.round(sum / 8));
		}
	}
}
