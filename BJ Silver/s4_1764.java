// 1764 듣보잡
import java.io.*;
import java.util.*;

public class s4_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 듣도 못한 사람 input
        Map<String, Boolean> notHeard = new HashMap<>();
        for (int n = 0; n < N; n++) {
            notHeard.put(br.readLine(), true);
        }

        // 보도 못한 사람 input + logic
        List<String> notSeenAndHeard = new ArrayList<>();
        for (int m = 0; m < M; m++) {
            String notSeen = br.readLine();
            // notHeard(Map)에서 notSeen(String) 검색
            // 있는 key면 value 반환, 없으면 default(false) 반환
            if (notHeard.getOrDefault(notSeen, false)) {
                notSeenAndHeard.add(notSeen);  // 듣보잡 명단
            }
            // 시간 초과 코드 (notHeard를 ArrayList로 만든 경우)
            // int index = notHeard.indexOf(notSeen);
            // if (index >= 0) {
            //     notSeenAndHeard.add(notSeen);
            // }
        }
        Collections.sort(notSeenAndHeard);

        // Output
        sb.append(notSeenAndHeard.size()).append("\n");
        for (String str: notSeenAndHeard) {
            sb.append(str).append("\n");
        }
        System.out.print(sb.toString());
    }
}