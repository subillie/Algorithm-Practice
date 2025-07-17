// 1568 새
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class b2_1568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = 1;
        int count = 0;
        while (N > 0) {
            if (N < K) {
                K = 1;
            }
            N -= K++;
            count++;
        }
        System.out.println(count);
    }
}
