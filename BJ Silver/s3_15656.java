// 15656 N과 M (7)
import java.io.*;
import java.util.*;

public class s3_15656 {
  private static int[] inputs, result;
  private static StringBuilder sb;

  private static void backtrack(int N, int M, int depth) {
    if (depth == M) {
      for (int i = 0; i < M; i++) {
        sb.append(inputs[result[i]]).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = 0; i < N; i++) {
      result[depth] = i;
      backtrack(N, M, depth + 1);
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine(), " ");
    inputs = new int[N];
    for (int i = 0; i < N; i++) {
      inputs[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(inputs);

    result = new int[M];
    backtrack(N, M, 0);

    System.out.println(sb.toString());
  }
}