# 4485 녹색 옷 입은 애가 젤다지?
import sys, heapq
INPUT = sys.stdin.readline

dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]
testcase = 0

while True:
    N = int(INPUT())
    if N == 0:
        break

    testcase += 1
    cave = [list(map(int, INPUT().split())) for _ in range(N)]
    dp = [[float("inf")] * N for _ in range(N)]
    dp[0][0] = cave[0][0]

    pq = [(cave[0][0], 0, 0)]  # (rupee, x, y)
    while pq:
        rupee, x, y = heapq.heappop(pq)
        if rupee > dp[y][x]:
            continue

        for move in range(4):
            nx = x + dx[move]
            ny = y + dy[move]
            if 0 <= nx < N and 0 <= ny < N:
                more_rupee = rupee + cave[ny][nx]
                if more_rupee < dp[ny][nx]:
                    dp[ny][nx] = more_rupee
                    heapq.heappush(pq, (more_rupee, nx, ny))

    print(f"Problem {testcase}: {dp[N - 1][N - 1]}")
