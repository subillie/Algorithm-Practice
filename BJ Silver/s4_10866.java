// 10866 덱
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class s4_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new LinkedList<>();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            switch (command) {
                case "push_front":
                    int item = Integer.parseInt(st.nextToken());
                    deque.offerFirst(item);
                    break;

                case "push_back":
                    item = Integer.parseInt(st.nextToken());
                    deque.offerLast(item);
                    break;

                case "pop_front":
                    if (!deque.isEmpty())
                        sb.append(deque.pollFirst()).append("\n");
                    else
                        sb.append(-1).append("\n");
                    break;

                case "pop_back":
                    if (!deque.isEmpty())
                        sb.append(deque.pollLast()).append("\n");
                    else
                        sb.append(-1).append("\n");
                    break;

                case "size":
                    sb.append(deque.size()).append("\n");
                    break;

                case "empty":
                    if (deque.isEmpty())
                        sb.append(1).append("\n");
                    else
                        sb.append(0).append("\n");
                    break;

                case "front":
                    if (!deque.isEmpty())
                        sb.append(deque.peekFirst()).append("\n");
                    else
                        sb.append(-1).append("\n");
                    break;

                case "back":
                    if (!deque.isEmpty())
                        sb.append(deque.peekLast()).append("\n");
                    else
                        sb.append(-1).append("\n");
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}