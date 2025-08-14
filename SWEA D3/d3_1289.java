// 1289 원재의 메모리 복구하기
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class d3_1289 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// Input
			char[] arr = br.readLine().toCharArray();

			// Logic
			int count = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == '1') {
					count++;
					for (int j = i; j < arr.length; j++) {
						arr[j] = (char)('1' - arr[j] + '0');
					}
				}
			}

			// Output
			sb.append("#").append(t).append(" ").append(count).append("\n");
		}
		System.out.println(sb.toString());
	}
}