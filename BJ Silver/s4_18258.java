// 18258 큐 2
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class s4_18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            switch (command) {
                case "push":
                    int item = Integer.parseInt(st.nextToken());
                    queue.add(item);
                    break;

                case "pop":
                    if (!queue.isEmpty())
                        sb.append(queue.poll()).append("\n");
                    else
                        sb.append(-1).append("\n");
                    break;

                case "size":
                    sb.append(queue.size()).append("\n");
                    break;

                case "empty":
                    if (queue.isEmpty())
                        sb.append(1).append("\n");
                    else
                        sb.append(0).append("\n");
                    break;

                case "front":
                    if (!queue.isEmpty())
                        sb.append(queue.element()).append("\n");
                    else
                        sb.append(-1).append("\n");
                    break;

                case "back":
                    if (!queue.isEmpty())
                        sb.append(((LinkedList<Integer>) queue).peekLast()).append("\n");
                    else
                        sb.append(-1).append("\n");
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}