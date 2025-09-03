// 6808 규영이와 인영이의 카드게임
import java.io.*;
import java.util.*;

public class d3_6808 {
	private static int win, lose;
	private static int[] myCards, yourCards, permutation;
	private static boolean[] visit = new boolean[9];
	
	private static void permutate(int depth) {
		if (depth == 9) {
			int myScore = 0;
            int yourScore = 0;
			for (int i = 0; i < 9; i++) {
				int sum = myCards[i] + permutation[i];
				if (myCards[i] > permutation[i]) {
					myScore += sum;
				} else {
					yourScore += sum;
				}
			}
			if (myScore > yourScore) {
				win++;
			} else {
				lose++;
			}
		}
		
		for (int i = 0; i < 9; i++) {
			if (!visit[i]) {  // 중복 허용하지 않는 순열
				visit[i] = true;
				permutation[depth] = yourCards[i];
				permutate(depth + 1);
				visit[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// Input
			StringTokenizer st = new StringTokenizer(br.readLine());
			myCards = new int[9];  // 규영이 카드
			yourCards = new int[9];  // 인영이 카드
			boolean[] cards = new boolean[19];
			for (int i = 0; i < 9; i++) {
				int num = Integer.parseInt(st.nextToken());
				myCards[i] = num;
				cards[num] = true;
			}
			int index = 0;
			for (int num = 1; num <= 18; num++) {
				if (!cards[num]) {
					yourCards[index++] = num;
				}
			}
			// Logic
            win = 0;
            lose = 0;
			permutation = new int[9];
			permutate(0);
			// Output
			sb.append("#").append(t).append(" ").append(win).append(" ").append(lose).append("\n");
		}
		System.out.println(sb.toString());
	}
}
