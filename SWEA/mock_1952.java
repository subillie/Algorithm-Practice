// 1952 수영장
import java.io.*;
import java.util.*;

public class mock_1952 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
            // Input
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int months = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            int[] plan = new int[13];
            for (int i = 1; i <= 12; i++) {
                plan[i] = Integer.parseInt(st.nextToken());
            }

            // Logic
            int[] cost = new int[13];
            for (int i = 1; i <= 12; i++) {
                cost[i] = Integer.MAX_VALUE;
            }
            cost[0] = 0;

            for (int i = 1; i <= 12; i++) {  // DP
                cost[i] = cost[i - 1] + Math.min(day * plan[i], month);
                if (i >= 3) {
                    cost[i] = Math.min(cost[i], cost[i - 3] + months);
                }
            }
			
            // Output
			sb.append("#").append(t).append(" ").append(Math.min(cost[12], year)).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
