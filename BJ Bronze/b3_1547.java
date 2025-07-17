// 1547 공
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class b3_1547 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int ball = 1;
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cup_left = Integer.parseInt(st.nextToken());
            int cup_right = Integer.parseInt(st.nextToken());
            if (cup_left == ball) {
                ball = cup_right;
            } else if (cup_right == ball) {
                ball = cup_left;
            }
        }
        if (!(1 <= ball && ball <= 3)) {
            ball = -1;
        }
        System.out.println(ball);
    }
}
