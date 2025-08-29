// 4613 러시아 국기 같은 깃발
import java.io.*;
import java.util.*;

public class d4_4613 {
	static private class Count {
		private int white, blue, red;
		
		public Count(int white, int blue, int red) {
			this.white = white;
			this.blue = blue;
			this.red = red;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// Input
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			Count[] count = new Count[N];
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				count[i] = new Count(0, 0, 0);
				for (int j = 0; j < M; j++) {
					switch (line.charAt(j)) {
					case 'W':
						count[i].white++;
						break;
					case 'B':
						count[i].blue++;
						break;
					case 'R':
						count[i].red++;
						break;
					}
				}
			}
			
			// Logic
			int minCost = Integer.MAX_VALUE;
			
			int whiteCost = 0;
			for (int w = 0; w < N - 2; w++) {
				whiteCost += M - count[w].white;
				
				int blueCost = 0;
			    for (int b = w + 1; b < N - 1; b++) {
			    	blueCost += M - count[b].blue;

			    	int redCost = 0;
			        for (int r = b + 1; r < N; r++) {
			        	redCost += M - count[r].red;
			        }
			        
			        minCost = Math.min(minCost, whiteCost + blueCost + redCost);
			    }
			}
			
			// Output
			sb.append("#").append(t).append(" ").append(minCost).append("\n");
		}
		System.out.println(sb.toString());
	}
}
