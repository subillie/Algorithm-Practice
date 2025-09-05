// 8275 햄스터
import java.io.*;
import java.util.*;

public class d4_8275 {
    private static int N, X, M, maxSum;
    private static int[] arr, answer;
    private static int[][] memo;

    private static void product(int index) {
        // Base case: arr을 끝까지 다 채운 경우
        if (index > N) {
            // 정상적 케이스: 메모와 일치할 경우
            if (checkMemo(arr)) {
                // 정답이 여러 개면, 햄스터 수가 가장 많은 것으로 함
                int sum = 0;
                for (int i = 1; i <= N; i++) {
                    sum += arr[i];
                }
                if (sum > maxSum) {
                    maxSum = sum;
                    answer = Arrays.copyOf(arr, N + 1);  // 결과 저장
                }
            }
            return;
        }

        // Recursive case: 중복순열 생성
        for (int i = 0; i <= X; i++) {
            arr[index] = i;
            product(index + 1);
        }
    }

    private static boolean checkMemo(int[] arr) {
        for (int i = 0; i < M; i++) {
            int sum = 0;
            for (int j = memo[i][0]; j <= memo[i][1]; j++) {
                sum += arr[j];
            }
            if (sum != memo[i][2]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            // Input
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());  // 우리 개수: 1 ~ N
            X = Integer.parseInt(st.nextToken());  // 우리 하나 당 햄스터 수: 0 ~ X
            M = Integer.parseInt(st.nextToken());  // 메모 개수

            maxSum = -1;
            arr = new int[N + 1];
            memo = new int[M][3];
            answer = new int[N];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                memo[i][0] = Integer.parseInt(st.nextToken());
                memo[i][1] = Integer.parseInt(st.nextToken());
                memo[i][2] = Integer.parseInt(st.nextToken());
            }

            // Logic
            product(1);

            // Output
            sb.append("#").append(t).append(" ");
            if (maxSum == -1) {
                sb.append(-1).append("\n");
            } else {
                for (int i = 1; i <= N; i++) {
                    sb.append(answer[i]).append(" ");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
