// 1230 암호문3
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class d3_1230 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for (int t = 1; t <= 10; t++) {
			// Input
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			LinkedList<Integer> arr = new LinkedList<>();
			for (int n = 0; n < N; n++) {
				arr.add(Integer.parseInt(st.nextToken()));
			}
			
			// Logic
			int x, y;
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			for (int m = 0; m < M; m++) {
				String command = st.nextToken();
				switch (command) {
				case "I":  // x번째 암호문 바로 다음에 y개의 암호문 삽입
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					for (int i = 0; i < y; i++) {
						arr.add(x + i, Integer.parseInt(st.nextToken()));
					}
					break;
					
				case "D":  // x번째 암호문 바로 다음부터 y개의 암호문 삭제
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					for (int i = 0; i < y; i++) {
						arr.remove(x);
					}
					break;
					
				case "A":  // 맨 뒤에 y개의 암호문 덧붙임
					y = Integer.parseInt(st.nextToken());
					for (int i = 0; i < y; i++) {
						arr.addLast(Integer.parseInt(st.nextToken()));
					}					
					break;
				}
			}
			
			// Output
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < 10; i++) {
				result.append(arr.pollFirst()).append(" ");
			}
			sb.append("#").append(t).append(" ").append(result.toString()).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
