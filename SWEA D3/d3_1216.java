// 1216 회문2
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class d3_1216 {

    static boolean isPalindrome(String word) {
        int len = word.length();
        for (int i = 0; i < len / 2; i++) {
            if (word.charAt(i) != word.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    static int getLongestLen(String line) {
        for (int wordLen = 100; wordLen > 0; wordLen--) {
            for (int beginIndex = 0; beginIndex <= 100 - wordLen; beginIndex++) {
                String word = line.substring(beginIndex, beginIndex + wordLen);
                if (isPalindrome(word)) {
                    return wordLen;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        for (int t = 1; t <= 10; t++) {
            int T = Integer.valueOf(br.readLine());
            int maxLen = 0;

            char[][] mat = new char[100][100];
            for (int i = 0; i < 100; i++) {
                String line = br.readLine();  // 입력
                mat[i] = line.toCharArray();
                maxLen = Math.max(maxLen, getLongestLen(line));  // 가로 단어 체크
            }

            StringBuilder line = new StringBuilder();
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    line.append(mat[j][i]);
                }
                maxLen = Math.max(maxLen, getLongestLen(line.toString()));  // 세로 단어 체크
                line.setLength(0);
            }

            sb.append("#").append(T).append(" ").append(maxLen).append("\n");  // 출력
        }
        System.out.print(sb.toString());
    }
}