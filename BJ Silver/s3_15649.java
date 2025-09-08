// 15649 N과 M (1)
import java.io.*;
import java.util.*;

public class s3_15649 {
    private static int[] arr;
	private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();
	
	private static void backtrack(int N, int M, int depth) {
        // Base case
		if (depth == M) {
            for (int num: arr) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
			return;
		}

        // Recursive case
		for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                backtrack(N, M, depth + 1);
                visited[i] = false;
            }
        }
    }
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
        // Logic
        arr = new int[M];
		visited = new boolean[N + 1];
		backtrack(N, M, 0);
		
        // Output
		System.out.println(sb.toString());
	}
}
