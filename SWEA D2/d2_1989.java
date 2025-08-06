// 1989 초심자의 회문 검사
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class d2_1989 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringBuffer word = new StringBuffer(br.readLine());
			String originalWord = word.toString();
			String reversedWord = word.reverse().toString();
			int answer = originalWord.equals(reversedWord) ? 1 : 0;
			System.out.printf("#%d %d\n", t, answer);
		}
	}
}
