//d3_3499 퍼펙트 셔플
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class d3_3499 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// Input
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			LinkedList<String> firstDeque = new LinkedList<>();
			LinkedList<String> secondDeque = new LinkedList<>();
			for (int i = 0; i < (N + 1) / 2; i++) {
				firstDeque.add(st.nextToken());
            }
            while (st.hasMoreTokens()) {
            	secondDeque.add(st.nextToken());
            }

			// Logic
			StringBuilder result = new StringBuilder();
			while (!firstDeque.isEmpty() || !secondDeque.isEmpty()) {
				if (!firstDeque.isEmpty()) {
					result.append(firstDeque.poll()).append(" ");
				}
				if (!secondDeque.isEmpty()) {
					result.append(secondDeque.poll()).append(" ");
				}
			}
			
			// Output
			sb.append("#").append(t).append(" ").append(result.toString()).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}