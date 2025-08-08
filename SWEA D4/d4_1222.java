// 계산기1
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class d4_1222 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			char[] infix = br.readLine().toCharArray();
			
			// 1. 후위 표기식으로 변환
			Stack<Character> notationStack = new Stack<>();
			StringBuilder postfix = new StringBuilder();
			for (int i = 0; i < infix.length; i++) {
				char op = infix[i];
				if (op != '+') {  // 피연산자
					postfix.append(op);
				} else {  // 연산자
					if (!notationStack.isEmpty()) {
						postfix.append(notationStack.pop());
					}
					notationStack.push(op);
				}
			}
			while (!notationStack.isEmpty()) {
				postfix.append(notationStack.pop());
			}
			
			// 2. 후위 표기식 계산
			Stack<Integer> operationStack = new Stack<>();
			for (int i = 0; i < postfix.length(); i++) {
				char op = postfix.charAt(i);
				if (op != '+') {
					operationStack.push((op - '0'));
				} else {
					int x = operationStack.pop();
					int y = operationStack.pop();
					operationStack.push(x + y);
				}
			}
			int result = operationStack.pop();
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}
}
