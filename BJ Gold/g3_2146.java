// 2146 다리 만들기
import java.io.*;
import java.util.*;

public class g3_2146 {
    private static int N;
    private static int[][] map;
    private static final int[] dy = {1, -1, 0, 0};
    private static final int[] dx = {0, 0, 1, -1};

    private static class Pos {
        int y, x;
        Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static void numberIsland(int startY, int startX, int islandNum) {
        Queue<Pos> queue = new ArrayDeque<>();
        queue.offer(new Pos(startY, startX));
        map[startY][startX] = islandNum;

        while (!queue.isEmpty()) {
            Pos pos = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int ny = pos.y + dy[i];
                int nx = pos.x + dx[i];
                if (0 <= ny && ny < N && 0 <= nx && nx < N && map[ny][nx] == 1) {
                    map[ny][nx] = islandNum; // numbering
                    queue.offer(new Pos(ny, nx));
                }
            }
        }
    }

    private static int findShortestBridge() {
        Queue<Pos> queue = new ArrayDeque<>();
        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0) { // Init queue: 모든 육지
                    queue.offer(new Pos(i, j));
                }
            }
        }
        int bridgeLen = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Pos pos = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = pos.y + dy[i];
                int nx = pos.x + dx[i];

                // 다른 섬의 영역을 만났을 경우
                if (0 <= ny && ny < N && 0 <= nx && nx < N) {
                    // 바다가 아니고 현재 내 섬의 ID와 다르다면
                    if (map[ny][nx] != 0 && map[ny][nx] != map[pos.y][pos.x]) {
                        // 양쪽 섬에서의 거리를 더함 -> 다리 길이
                        bridgeLen = Math.min(bridgeLen, dist[pos.y][pos.x] + dist[ny][nx]);
                    }

                    // 아직 방문하지 않은 바다일 경우
                    if (map[ny][nx] == 0) {
                        map[ny][nx] = map[pos.y][pos.x]; // 방문 처리 (내 섬으로 편입)
                        dist[ny][nx] = dist[pos.y][pos.x] + 1; // 거리 1 증가
                        queue.offer(new Pos(ny, nx));
                    }
                }
            }
        }
        return bridgeLen;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 지도 입력 받기
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 육지 번호 붙이기
        int islandNum = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    numberIsland(i, j, islandNum++);
                }
            }
        }

        System.out.println(findShortestBridge());
    }
}