// 1152 단어의 개수
import java.util.Scanner;
import java.util.StringTokenizer;

public class b2_1152 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();

        StringTokenizer st = new StringTokenizer(str, " ");
        System.out.println(st.countTokens());
    }
}