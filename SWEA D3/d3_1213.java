// 1213 String
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class d3_1213 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			int T = Integer.valueOf(br.readLine());
			String target = br.readLine();
			String str = br.readLine();
			
			int count = 0;
            // 방법1 : 이중 for문 돌기
			// for (int i = 0; i < str.length(); i++) {
			// 	if (str.charAt(i) == target.charAt(0)) {
			// 		for (int j = 1; j < target.length(); j++) {
			// 			if (i + j >= str.length() || str.charAt(i + j) != target.charAt(j)) {
			// 				break;
			// 			}
			// 			if (j == target.length() - 1) {
			// 				count++;
			// 				i += j;
			// 			}
			// 		}
			// 	}
			// }
            // 방법2 : String 메서드 indexOf 사용하기
			int fromIndex = 0;
			while (true) {
				fromIndex = str.indexOf(target, fromIndex);
				if (fromIndex == -1) break;
				count++;
				fromIndex += target.length();
			}
			System.out.printf("#%d %d\n", T, count);
		}
	}
}
