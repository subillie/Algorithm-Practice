// 1213 String
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class d3_1213 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			int T = Integer.valueOf(br.readLine());
			String target = br.readLine().trim();
			String str = br.readLine().trim();
			
			int count = 0;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == target.charAt(0)) {
					for (int j = 1; j < target.length(); j++) {
						if (i + j >= str.length() || str.charAt(i + j) != target.charAt(j)) {
							break;
						}
						if (j == target.length() - 1) {
							count++;
							i += j;
						}
					}
				}
			}
			System.out.printf("#%d %d\n", T, count);
		}
	}
}
