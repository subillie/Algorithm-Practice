// 1021 회전하는 큐
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class s3_1021 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        LinkedList<Integer> deque = new LinkedList<>();
        for (int n = 1; n <= N; n++) deque.offer(n);

        int count = 0;
        for (int i  = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            while (true) {
                if (deque.peekFirst() == target) {
                    deque.removeFirst();
                    break;
                }
                if (deque.indexOf(target) <= deque.size() / 2) {
                    deque.offerLast(deque.pollFirst());
                    count++;
                } else {
                    deque.offerFirst(deque.pollLast());
                    count++;
                }
            }
        }

        sb.append(count);
        System.out.println(sb.toString());
    }
}