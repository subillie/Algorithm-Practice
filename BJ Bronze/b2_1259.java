// 1259 팬린드롬수
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2_1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();
            if (str.equals("0")) {
                break;
            }
            Boolean flag = true;
            Integer str_len = str.length();
            for (Integer i = 0; i < str_len / 2; i++) {
                if (str.charAt(i) != str.charAt(str_len - i - 1)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}