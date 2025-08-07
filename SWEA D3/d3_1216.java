// 1216 회문2
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class d3_1216 {

    static boolean isPalindrome(String line, int beginIndex, int wordLen) {
    	for (int i = 0; i < wordLen / 2; i++) {
    		if (line.charAt(beginIndex + i) != line.charAt(beginIndex + wordLen - i - 1)) {
    			return false;
    		}
    	}
    	return true;
    }

    static int getMaxPalindrome(String line, int maxLen) {
        for (int wordLen = 100; wordLen > maxLen; wordLen--) {
            for (int beginIndex = 0; beginIndex <= 100 - wordLen; beginIndex++) {
                if (isPalindrome(line, beginIndex, wordLen)) {
                    return wordLen;
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        for (int t = 1; t <= 10; t++) {
            int T = Integer.valueOf(br.readLine());
            int maxLen = 0;

            char[][] mat = new char[100][];
            for (int i = 0; i < 100; i++) {
                String line = br.readLine();  // 입력
                mat[i] = line.toCharArray();
                maxLen = getMaxPalindrome(line, maxLen);  // 가로 단어
            }

            for (int i = 0; i < 100; i++) {
                StringBuilder line = new StringBuilder();
                for (int j = 0; j < 100; j++) {
                    line.append(mat[j][i]);
                }
                maxLen = getMaxPalindrome(line.toString(), maxLen);  // 세로 단어
            }

            sb.append("#").append(T).append(" ").append(maxLen).append("\n");  // 출력
        }
        System.out.print(sb.toString());
    }
}