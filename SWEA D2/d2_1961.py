# 1961 숫자 배열 회전
T = int(input())
for t in range(T):
    N = int(input())
    matrix = [list(input().split()) for _ in range(N)]
    mat_90 = [list(row) for row in zip(*matrix[::-1])]
    mat_180 = [row[::-1] for row in matrix[::-1]]
    mat_270 = [list(row) for row in zip(*matrix)][::-1]
    print(f"#{t + 1}")
    for n in range(N):
        print(''.join(mat_90[n]), ''.join(mat_180[n]), ''.join(mat_270[n]))