# 1220 Magnetic
# import sys
# sys.stdin = open("c:/Users/SSAFY/Desktop/subin_git/Algorithm-Practice/SWEA D3/d3_1220_input.txt", "r")

T = 10
for t in range(1, T + 1):
    N = int(input())
    mat = [list(map(int, input().split())) for _ in range(N)]
    mat = [list(col) for col in zip(*mat)]
    deadlock = 0
    for row in mat:
        prev = -1
        for magnet in row:
            if magnet == 1:
                prev = 1
            elif magnet == 2 and prev == 1:
                deadlock += 1
                prev = -1  # 한 줄에 여러 개의 교착 상태 가능 (break X)
    print(f"#{t}", deadlock)