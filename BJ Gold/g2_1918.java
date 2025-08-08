// 1918 후위 표기식
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class g2_1918 {
    static int precedence(char operator) {
        if (operator == '*' || operator == '/') return 2;
        if (operator == '+' || operator == '-') return 1;
        return 0;  // op == '('
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String infix = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (Character.isLetterOrDigit(c)) {  // 알파벳이나 숫자는 바로 출력
                sb.append(c);

            } else if (c == '(') {  // ')'은 무조건 push
                stack.push(c);

            } else if (c == ')') {  // ')'은 stack에 안 들어감
                // '('가 나올 때까지 모두 pop, 출력
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();  // '(' 제거

            } else {  // '+, '-', '*', '/' 중 하나일 때
                // 본인보다 낮은 우선순위 연산자 모두 pop, 출력
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    sb.append(stack.pop());
                }
                stack.push(c);  // 본인 push
            }
        }

        // stack에 남아있는 연산자들 모두 pop, 출력
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb.toString());
    }
}
