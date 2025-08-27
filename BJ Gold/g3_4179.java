// 4179 불!
import java.io.*;
import java.util.*;

public class g3_4179 {
	static int R, C;
	static int[][] maze;
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};

	static class Pos {
		int y, x, time;
		public Pos(int y, int x, int time) {
			this.y = y;
			this.x = x;
			this.time = time;
		}
	}
	
	static void spreadFire(List<Pos> fire) {
		Queue<Pos> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[R][C];
		for (Pos f: fire) {
			queue.add(f);
			visited[f.y][f.x] = true;
		}
		
		while (!queue.isEmpty()) {
			Pos pos = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int ny = pos.y + dy[i];
				int nx = pos.x + dx[i];
				if (0 <= ny && ny < R && 0 <= nx && nx < C && !visited[ny][nx] && maze[ny][nx] == -1) {
					maze[ny][nx] = pos.time + 1;
					visited[ny][nx] = true;
					queue.add(new Pos(ny, nx, pos.time + 1));
				}
			}
		}
	}
	
	static int escapeMaze(int y, int x) {
		Queue<Pos> queue = new ArrayDeque<>();
		queue.add(new Pos(y, x, 0));		
		boolean[][] visited = new boolean[R][C];
		visited[y][x] = true;

		
		while (!queue.isEmpty()) {
			Pos pos = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int ny = pos.y + dy[i];
				int nx = pos.x + dx[i];
				// 탈출 조건
				if (!(0 <= ny && ny < R && 0 <= nx && nx < C)) {
					return pos.time + 1;
				}
				// 불이 번지기 전에만 이동 가능
				if (!visited[ny][nx] && (maze[ny][nx] == -1 || pos.time + 1 < maze[ny][nx])) {
					visited[ny][nx] = true;  // 방문 처리
					queue.add(new Pos(ny, nx, pos.time + 1));  // 이동
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// Input
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		maze = new int[R][C];
		int personY = 0, personX = 0;  // 사람 좌표 저장
		List<Pos> fire = new ArrayList<>();  // 불 좌표 저장
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				char c = line.charAt(j);
				switch (c) {
				case '.':  // 길
					maze[i][j] = -1;
					break;
				case '#':  // 벽
					maze[i][j] = -2;
					break;
				case 'J':  // 사람
					maze[i][j] = -1;
					personY = i;
					personX = j;
					break;
				case 'F':  // 불
					maze[i][j] = 0;
					fire.add(new Pos(i, j, 0));
					break;
				}
			}
		}
		
		// Logic
		if (!fire.isEmpty()) spreadFire(fire);  // 각 좌표에 불이 번지는 시간 표시
		int result = escapeMaze(personY, personX);  // 사람 이동 BFS
		
		// Output
		if (result == -1) {
			System.out.println("IMPOSSIBLE");
		} else {
			System.out.println(result);
		}
	}
}
