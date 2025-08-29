// 4613 러시아 국기 같은 깃발
import java.io.*;
import java.util.*;

public class d4_4613 {
	private static int N, M, answer;
	private static Count[] count;
	private static final int INF = 1_000_000_000;
	
	private static class Count {
		int white, blue, red;
		public Count(int white, int blue, int red) {
			this.white = white;
			this.blue = blue;
			this.red = red;
		}
	}
	
	// DFS
	private static void dfs(int row, int color, int cost) {
		/*
		 * Args:
		 * - row: 현재 행
		 * - color: 0=W, 1=B, 2=R
		 * - cost: 지금까지 든 비용
		 */

        // Base Case
        if (row == N) {
            if (color == 2) {  // 마지막 행은 빨간색
                answer = Math.min(answer, cost);
            }
            return;
        }

        // Recursive Case
        int curCost;  // 현재 행을 색칠할 때 드는 비용
        if (color == 0) curCost = M - count[row].white;  // 흰색
        else if (color == 1) curCost = M - count[row].blue;  // 파란색
        else curCost = M - count[row].red;  // 빨간색

        // 같은 색 계속 칠하기
        dfs(row + 1, color, cost + curCost);

        // 다음 색으로 넘어가기 (W→B, B→R)
        if (color == 0) dfs(row + 1, 1, cost + (M - count[row].blue));
        else if (color == 1) dfs(row + 1, 2, cost + (M - count[row].red));
    }
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// Input
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			count = new Count[N];
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				count[i] = new Count(0, 0, 0);
				for (int j = 0; j < M; j++) {
					switch (line.charAt(j)) {
					case 'W': count[i].white++; break;
					case 'B': count[i].blue++; break;
					case 'R': count[i].red++; break;
					}
				}
			}
			
			/* Brute Force */
//			int minCost = Integer.MAX_VALUE;
//			
//			int whiteCost = 0;
//			for (int w = 0; w < N - 2; w++) {
//				whiteCost += M - count[w].white;
//				
//				int blueCost = 0;
//			    for (int b = w + 1; b < N - 1; b++) {
//			    	blueCost += M - count[b].blue;
//
//			    	int redCost = 0;
//			        for (int r = b + 1; r < N; r++) {
//			        	redCost += M - count[r].red;
//			        }
//			        
//			        minCost = Math.min(minCost, whiteCost + blueCost + redCost);
//			    }
//			}
//			sb.append("#").append(t).append(" ").append(minCost).append("\n");
			
			/* DP */
           // 각 행별 색칠 비용
           int[][] cost = new int[N][3];
           for (int i = 0; i < N; i++) {
               cost[i][0] = M - count[i].white;
               cost[i][1] = M - count[i].blue;
               cost[i][2] = M - count[i].red;
           }
           
           // 초기화: 첫 줄은 흰색
           int[][] dp = new int[N][3];
           for (int i = 0; i < N; i++) Arrays.fill(dp[i], INF);
           dp[0][0] = cost[0][0];

           // DP 진행
           for (int i = 1; i < N; i++) {
               dp[i][0] = dp[i-1][0] + cost[i][0]; // 흰색 유지
               dp[i][1] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][1]; // 파란색
               dp[i][2] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][2]; // 빨간색
           }

           // 마지막 줄은 빨간색이어야 함
           sb.append("#").append(t).append(" ").append(dp[N-1][2]).append("\n");
            
            /* DFS */
            // answer = Integer.MAX_VALUE;
            // dfs(1, 0, M - count[0].white);
            // sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
}
