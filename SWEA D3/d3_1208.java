// 1208 Flatten
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class d3_1208 {
	static int getIndex(int[] arr, int target) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				return i;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= 10; t++) {
			// 입력
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[100];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			// Logic
			int max, min;
			for (int i = 0; i < N; i++) {
				max = Arrays.stream(arr).max().getAsInt();
				min = Arrays.stream(arr).min().getAsInt();
				if (max - min <= 1) {
					break;
				}
				
				arr[getIndex(arr, max)]--;
				arr[getIndex(arr, min)]++;
			}
			max = Arrays.stream(arr).max().getAsInt();
			min = Arrays.stream(arr).min().getAsInt();
			
			// 출력
			sb.append("#").append(t).append(" ").append(max - min).append("\n");
		}
		System.out.println(sb.toString());
	}
}
