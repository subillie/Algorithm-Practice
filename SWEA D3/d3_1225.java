// 1225 암호생성기
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class d3_1225 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for (int t = 1; t <= 10; t++) {
			// Input
			int T = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			LinkedList<Integer> deque = new LinkedList<>();
			for (int i = 0; i < 8; i++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}
			
			// Logic
			int num = 1;
			int adjust = 1;
			while (num > 0) {
				// 규칙대로 값 삽입
				num = deque.pollFirst() - adjust;
				if (num < 0) {
					num = 0;
				}
				deque.addLast(num);
				// 조정값 업데이트
				if (adjust++ == 5) {
					adjust = 1;
				}
			}
			
			// Output
			sb.append("#").append(T).append(" ");
			for (int i = 0; i < 8; i++) {
				sb.append(deque.pollFirst()).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
