// 1210 Ladder1
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d4_1210 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        for (int t = 1; t <= 10; t++) {
            // 입력
            int T = Integer.valueOf(br.readLine());
            int row = 99, col = 99;
            int[][] miniMap = new int[100][100];
            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    miniMap[i][j] = Integer.valueOf(st.nextToken());
                    if (i == 99 && miniMap[i][j] == 2) {
                        col = j;
                    }
                }
            }

            // Logic
            while (row > 0) { 
                while (col - 1 >= 0 && miniMap[row][col - 1] == 1) {
                    miniMap[row][--col] = 0;
                }
                while (col + 1 < 100 && miniMap[row][col + 1] == 1) {
                    miniMap[row][++col] = 0;
                }
                row--;
            }

            // 출력
            sb.append("#").append(T).append(" ").append(col).append("\n");
        }
        System.out.println(sb.toString());
    }
}