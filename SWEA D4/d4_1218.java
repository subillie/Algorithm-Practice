// 1218 괄호 짝짓기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class d4_1218 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= 10; t++) {
			// 입력
			int N = Integer.parseInt(br.readLine());
			char[] arr = br.readLine().toCharArray();
			Stack<Character> stack = new Stack<>();

			// Logic
			int isValid = 1;
			String openChar = "([{<";
			for (int i = 0; i < arr.length; i++) {
				if (openChar.indexOf(arr[i]) != -1) {
					stack.push(arr[i]);
					continue;
				} else {
					if (stack.isEmpty()) {
						isValid = 0;
						break;
					}
					char ch = stack.pop();
					if (!(ch == '(' && arr[i] == ')' ||
						ch == '[' && arr[i] == ']' ||
						ch == '{' && arr[i] == '}' ||
						ch == '<' && arr[i] == '>')) {
						isValid = 0;
						break;
					}		
				}
			}
			if (!stack.isEmpty()) {
				isValid = 0;
			}
			
			// 출력
			sb.append("#").append(t).append(" ").append(isValid).append("\n");
		}
		System.out.println(sb.toString());
	}
}
