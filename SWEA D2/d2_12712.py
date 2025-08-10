# 12712 파리퇴치3
from collections import deque

T = int(input())
for t in range(T):
    N, M = map(int, input().split())
    matrix = [list(map(int, input().split())) for _ in range(N)]

    max_count = 0
    for x in range(N):
        for y in range(N):
            # 스프레이 노즐 + 형태
            count_t = matrix[x][y]
            for m in range(1, M):
                if 0 <= x + m < N:
                    count_t += matrix[x + m][y]
                if 0 <= x - m < N:
                    count_t += matrix[x - m][y]
                if 0 <= y + m < N:
                    count_t += matrix[x][y + m]
                if 0 <= y - m < N:
                    count_t += matrix[x][y - m]
            # 스프레이 노즐 x 형태
            count_x = matrix[x][y]
            for m in range(1, M):
                if 0 <= x + m < N and 0 <= y + m < N:
                    count_x += matrix[x + m][y + m]
                if 0 <= x + m < N and 0 <= y - m < N:
                    count_x += matrix[x + m][y - m]
                if 0 <= x - m < N and 0 <= y + m < N:
                    count_x += matrix[x - m][y + m]
                if 0 <= x - m < N and 0 <= y - m < N:
                    count_x += matrix[x - m][y - m]
            # 최대값 계산
            max_count = max(max_count, count_t, count_x)
    print(f"#{t + 1}", max_count)