// 1914 하노이 탑
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.BigInteger;

public class g5_1914 {
  static StringBuilder sb;

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    sb = new StringBuilder();

    // 하노이 탑 이동 횟수: 2^n - 1
    BigInteger count = new BigInteger("0").TWO.pow(n).subtract(BigInteger.ONE);
    System.out.println(count);
    if (n <= 20) {
      hanoi(n, 1, 2, 3);
    }
    System.out.println(sb.toString());
  }

  public static void hanoi(int n, int from, int tmp, int to) {
    if (n == 0) {
      return;
    }
    hanoi(n - 1, from, to, tmp);
    sb.append(from).append(" ").append(to).append("\n");
    hanoi(n - 1, tmp, from, to);
  }
}
