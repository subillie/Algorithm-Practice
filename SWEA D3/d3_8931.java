// 8931 제로
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class d3_8931 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    Stack<Integer> stack = new Stack<>();

    int T = Integer.parseInt(br.readLine());
    for (int t = 1; t <= T; t++) {
      int K = Integer.parseInt(br.readLine());
      for (int i = 0; i < K; i++) {
        int num = Integer.parseInt(br.readLine());
        if (num != 0) {
          stack.push(num);
        } else {
          stack.pop();
        }
      }
      
      int sum = 0;
      while (!stack.isEmpty()) {
        sum += stack.pop();
      }
      sb.append("#").append(t).append(" ").append(sum).append("\n");
    }
    System.out.println(sb.toString());
  }
}
