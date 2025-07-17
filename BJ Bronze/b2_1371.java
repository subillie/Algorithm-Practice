// 1371 가장 많은 글자
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class b2_1371 {
    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] counts = new int[26];  // 자동으로 0으로 초기화됨
        String line;
        while ((line = br.readLine()) != null) {
            for (char c: line.toCharArray()) {
                if ('a' <= c && c <= 'z') {
                    counts[c - 'a']++;
                }
            }
        }

        int max = 0;
        for (int count: counts) {
            if (count > max) {
                max = count;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (counts[i] == max) {
                System.out.print((char)('a' + i));
            }
        }
    }
}
