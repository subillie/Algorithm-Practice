# 1861 정사각형 방
from collections import deque

def bfs(i: int, j: int) -> int:
    queue = deque()
    visited = [[False] * N for _ in range(N)]
    count = 0
    prev = mat[i][j]

    queue.append((i, j))  # 시작하는 방
    visited[i][j] = True
    while queue:
        y, x = queue.popleft()
        count += 1
        for move in range(4):
            ny = y + dy[move]
            nx = x + dx[move]
            if 0 <= nx < N and 0 <= ny < N and not visited[ny][nx] and mat[ny][nx] == prev + 1:
                queue.append((ny, nx))
                visited[ny][nx] = True
                prev += 1
                break
    return count

def dfs(y: int, x: int) -> int:
    if dp[y][x]:  # 이미 방문한 수열을 다른 시작점에서 또 탐색하려 할 때, 즉시 리턴
        return dp[y][x]
        
    dp[y][x] = 1  # 최소한 자기 자신 포함
    for dir in range(4):
        ny = y + dy[dir]
        nx = x + dx[dir]
        if 0 <= ny < N and 0 <= nx < N and mat[ny][nx] == mat[y][x] + 1:
            dp[y][x] = max(dp[y][x], dfs(ny, nx) + 1)
    return dp[y][x]

T = int(input())
for t in range(1, T + 1):
    N = int(input())
    mat = [list(map(int, input().split())) for _ in range(N)]
    
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]

    max_count = 0
    room_num = N * N + 1

    for i in range(N):
        for j in range(N):
            # count = bfs(i, j)
            dp = [[0] * N for _ in range(N)]  # (i, j)에서 시작했을 때 최대 이동 수
            count = dfs(i, j)
            if count > max_count:  # 최대 이동 가능 수 구하기
                max_count = count
                room_num = mat[i][j]
            elif count == max_count:  # 최대 이동 가능 수가 같다면, 더 작은 방 번호로 갱신
                room_num = min(room_num, mat[i][j])

    print(f"#{t} {room_num} {max_count}")