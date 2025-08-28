// 1937 욕심쟁이 판다
import java.io.*;
import java.util.*;

public class g3_1937 {
	static int n;
	static int[][] mat, dp;
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	
	static int dfs(int y, int x) {
		// Base case
		if (dp[y][x] != 0) {
			return dp[y][x];
		}
		
		// Recursive case
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (0 <= ny && ny < n && 0 <= nx && nx < n && mat[y][x] < mat[ny][nx]) {
				dp[y][x] = Math.max(dp[y][x], dfs(ny, nx) + 1);
			}
		}
		return dp[y][x];
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		mat = new int[n][n];
		dp = new int[n][n];		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int maxCount = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				maxCount = Math.max(maxCount, dfs(i, j));
			}
		}
		System.out.println(maxCount + 1);
	}
}
