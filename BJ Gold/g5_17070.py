# 17070 파이프 옮기기 1
from collections import deque
import sys
INPUT = sys.stdin.readline

def dfs(y: int, x: int, direction: int) -> int:
    """
    Args:
        - (y, x) : 현재 좌표
        - direction : 0 가로, 1 세로, 2 대각선
    """
    # Base Case
    if y == N - 1 and x == N - 1:  # 도착점에 도달하면 count
        return 1
    if dp[y][x][direction] != -1:  # 이미 계산한 값 재사용
        return dp[y][x][direction]

    x_is_movable = x + 1 < N and home[y][x + 1] == 0
    y_is_movable = y + 1 < N and home[y + 1][x] == 0
    xy_are_movable = y + 1 < N and x + 1 < N \
                    and home[y][x + 1] == 0 \
                    and home[y + 1][x] == 0 \
                    and home[y + 1][x + 1] == 0

    # Recursion
    ways = 0
    if direction == 0:  # 가로 -> [가로, 대각선]
        if x_is_movable:
            ways += dfs(y, x + 1, 0)
        if xy_are_movable:
            ways += dfs(y + 1, x + 1, 2)
    elif direction == 1:  # 세로 -> [세로, 대각선]
        if y_is_movable:
            ways += dfs(y + 1, x, 1)
        if xy_are_movable:
            ways += dfs(y + 1, x + 1, 2)
    else:  # direction == 2, 대각선 -> [가로, 세로, 대각선]
        if x_is_movable:
            ways += dfs(y, x + 1, 0)
        if y_is_movable:
            ways += dfs(y + 1, x, 1)
        if xy_are_movable:
            ways += dfs(y + 1, x + 1, 2)

    dp[y][x][direction] = ways  # Memoization
    return ways

N = int(INPUT())
home = [list(map(int, INPUT().split())) for _ in range(N)]
dp = [[[-1] * 3 for _ in range(N)] for _ in range(N)]  # 3차원 DP
print(dfs(0, 1, 0))  # DFS
