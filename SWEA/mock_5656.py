# 5656 벽돌 깨기
from itertools import product
from collections import deque
from copy import deepcopy

def boom(board: list, y: int, x: int) -> None:
    queue = deque([(x, y, board[y][x])])
    board[y][x] = 0
    while queue:
        cx, cy, power = queue.popleft()
        for p in range(1, power):
            for dx, dy in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
                nx = cx + dx * p
                ny = cy + dy * p
                if 0 <= nx < W and 0 <= ny < H and board[ny][nx] != 0:
                    queue.append((nx, ny, board[ny][nx]))
                    board[ny][nx] = 0

def apply_gravity(board: list) -> None:
    for x in range(W):
        tmp = []
        for y in range(H):
            if board[y][x] != 0:
                tmp.append(board[y][x])
        for y in range(H - 1, -1, -1):
            board[y][x] = tmp.pop() if tmp else 0

def simulate(prod: tuple, board: list) -> int:
    board = deepcopy(board)
    for x in prod:
        for y in range(H):
            if board[y][x] != 0:
                boom(board, y, x)
                apply_gravity(board)
                break
    return sum(1 for y in range(H) for x in range(W) if board[y][x] != 0)


if __name__ == "__main__":
    T = int(input())
    for t in range(1, T + 1):
        N, W, H = map(int, input().split())
        board = [list(map(int, input().split())) for _ in range(H)]

        min_result = float("inf")
        for prod in product(range(W), repeat=N):
            result = simulate(prod, board)
            min_result = min(min_result, result)
            if min_result == 0:
                break

        print(f"#{t}", min_result)