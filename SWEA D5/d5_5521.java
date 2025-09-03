// 5521 상원이의 생일파티
import java.io.*;
import java.util.*;

public class d5_5521 {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());
    for (int t = 1; t <= T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      // 이차원 연결리스트로 그래프 구현
      List<Integer>[] graph = new ArrayList[N + 1];
      for (int i = 1; i <= N; i++) {
        graph[i] = new ArrayList<>();
      }
      // 친구 관계도 저장
      for (int i = 0; i < M; i++) {
        st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        graph[a].add(b);
        graph[b].add(a);
      }

      Queue<int[]> queue = new ArrayDeque<>();
      boolean[] invited = new boolean[N + 1];
      int count = 0;

      queue.add(new int[]{1, 0});  // 1번은 자기 자신
      invited[1] = true;
      
      while (!queue.isEmpty()) {
        int[] me = queue.poll();
        int node = me[0];
        int depth = me[1];

        if (depth == 2) {  // 친구의 친구까지만 초대
          continue;
        }

        for (int friend: graph[node]) {
          if (!invited[friend]) {
            invited[friend] = true;
            count++;
            queue.add(new int[]{friend, depth + 1});
          }
        }
      }

      sb.append("#").append(t).append(" ").append(count).append("\n");
    }

    System.out.println(sb.toString());
  }
}
