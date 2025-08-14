// 1231 중위순회
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d4_1231 {
	static int N;
	static char[] tree;
	static StringBuilder sb;

	static void traverseInOrder(int index) {
		if (index > N) return;
		traverseInOrder(index * 2);
		sb.append(tree[index]);
		traverseInOrder(index * 2 + 1);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;

		for (int t = 1; t <= 10; t++) {
			sb.append("#").append(t).append(" ");

			// Input
			N = Integer.parseInt(br.readLine());
			tree = new char[N + 1];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				st.nextToken();
				tree[i] = st.nextToken().charAt(0);
			}

			// Logic
			traverseInOrder(1);

			sb.append("\n");
		}

		System.out.println(sb.toString());
	}
}
