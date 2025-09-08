// 15652 N과 M (4)
import java.io.*;
import java.util.*;

public class s3_15652 {
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();
	
	private static void backtrack(int N, int M, int depth, int index) {
        // Base case
		if (depth == M) {
            for (int num: arr) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
			return;
		}

        // Recursive case
		for (int i = index; i <= N; i++) {
            arr[depth] = i;
            backtrack(N, M, depth + 1, i);
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
		backtrack(N, M, 0, 1);
		
        // Output
		System.out.println(sb.toString());
	}
}