// 2012 요리사
import java.io.*;
import java.util.*;

class mock_4012 {
  static int n, answer;
  static int[][] synergy;
  static boolean[] included;

  static int getDiff() {
    int x = 0, y = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i != j) {
          if (included[i] && included[j]) {
            x += synergy[i][j];
          } else if (!included[i] && !included[j]){
            y += synergy[i][j];
          }
        }
      }
    }
    return Math.abs(x - y);
  }
  
  static void combination(int index, int count) {
    if (count == n / 2) {
      answer = Math.min(answer, getDiff());
      return;
    }
    
    for (int i = index; i < n; i++) {
      included[i] = true;
      combination(i + 1, count + 1);
      included[i] = false;
    }
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
  
    int T = Integer.parseInt(br.readLine());
    for (int t = 1; t <= T; t++) {
      // Input
      n = Integer.parseInt(br.readLine());
      synergy = new int[n][n];
      included = new boolean[n];
      answer = Integer.MAX_VALUE;
      
      for (int i = 0; i < n; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 0; j < n; j++) {
          synergy[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      // Logic
      combination(0,0);

      // Output
      sb.append("#").append(t).append(" ").append(answer).append("\n");
    }
    System.out.println(sb.toString());
  }
}
