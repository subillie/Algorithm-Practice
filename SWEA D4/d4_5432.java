// 5432 쇠막대기 자르기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class d4_5432 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// 입력
			char[] arr = br.readLine().toCharArray();
			Stack<Boolean> sticks = new Stack<>();

			// Logic
			boolean is_laser = false;
			int count = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == '(') {
					sticks.push(true);
					is_laser = true;
					count++;
				} else {
					sticks.pop();
					if (is_laser) {
						count += sticks.size() - 1;
						is_laser = false;
					}
				}
			}
			
			// 출력
			sb.append("#").append(t).append(" ").append(count).append("\n");
		}
		System.out.println(sb.toString());
	}
}
