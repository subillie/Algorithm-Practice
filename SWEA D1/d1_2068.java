// 2068 최대수 구하기
import java.util.Scanner;

public class d1_2068 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int max = 0;
            for (int i = 0; i < 10; i++) {
                max = Math.max(max, sc.nextInt());
            }
            System.out.printf("#%d %d\n", t, max);
        }
        sc.close();
    }
}