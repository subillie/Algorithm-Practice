// 2930 힙
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class d3_2930 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				if (Integer.parseInt(st.nextToken()) == 1) {
					heap.offer(Integer.parseInt(st.nextToken()));
				} else {
					sb.append(heap.isEmpty() ? "-1" : String.valueOf(heap.poll())).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
