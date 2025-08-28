// 5215 햄버거 다이어트
import java.io.*;
import java.util.*;

public class d3_5215 {
	static int N, L, max;
	static int[] scores, cals;

    static void getSubset(int count, int cal, int score) {
    	// Base case
        if (cal > L) {  // 제한 칼로리 초과
        	return;
        }
        if (count == N) {  // 마지막 재료
        	if (cal <= L) {
        		max = Math.max(max, score);  // max 갱신
        	}
            return; 
		}
        
        // Recursive case
        getSubset(count + 1, cal + cals[count], score + scores[count]);  // 현재 재료 선택한 경우
        getSubset(count + 1, cal, score);  // 현재 재료 선택하지 않은 경우
    }
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken()); // 재료 수
            L = Integer.parseInt(st.nextToken()); // 제한 칼로리
            scores = new int[N]; // 맛 점수
            cals = new int[N]; // 칼로리
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                scores[i] = Integer.parseInt(st.nextToken());
                cals[i] = Integer.parseInt(st.nextToken());
            }

            max = 0;
            getSubset(0, 0, 0);
            sb.append("#").append(t).append(" ").append(max).append("\n");
        }
        System.out.print(sb);
    }
}