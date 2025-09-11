// 9372 상근이의 여행
import java.io.*;
import java.util.*;

public class s4_9372 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken()); // 국가 수 (정점 개수)
            int M = Integer.parseInt(st.nextToken()); // 비행기 종류
            for (int i = 0; i < M; i++) {
                br.readLine();
            }

            // MST의 간선 개수는 항상 (정점 개수 - 1)
            sb.append(N - 1).append("\n");
        }
        System.out.println(sb.toString());
    }
}