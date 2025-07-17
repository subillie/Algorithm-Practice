// 1264 모음의 개수
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// import java.util.regex.*;

public class b4_1264 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Pattern pattern = Pattern.compile("[aeiouAEIOU]");

        while (true) {
            String str = br.readLine();
            if (str.equals("#")) {
                break;
            }
            // Integer count = 0;
            // Matcher matcher = pattern.matcher(str);
            // while (matcher.find()) {
            //     count++;
            // }
            int count = 0;
            for (char c : str.toCharArray()) {
                if ("aeiouAEIOU".indexOf(c) >= 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
