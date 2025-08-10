// 9386 연속한 1의 개수
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class d1_9386 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());
    for (int t = 1; t <= T; t++) {
      int N = Integer.parseInt(br.readLine());
      String nums = br.readLine();

      boolean is_continuous = true;
      int count = 0;
      int max_count = 0;
      for (int i = 0; i < nums.length(); i++) {
        if (nums.charAt(i) == '1') {
          count++;
          if (!is_continuous) {
            is_continuous = true;
          }
        } else {
          is_continuous = false;
          max_count = Math.max(max_count, count);
          count = 0;
        }
      }
      max_count = Math.max(max_count, count);

      sb.append("#").append(t).append(" ").append(max_count).append("\n");
    }
    System.out.println(sb.toString());
  }
}
