# 1979 어디에 단어가 들어갈 수 있을까
T = int(input())
for t in range(1, T + 1):
    N, K = map(int, input().split())
    mat = [list(map(int, input().split())) for _ in range(N)]
    count = 0
    # 벽에 부딪힐 때까지 연속된 칸 수 세기
    for i in range(N):
        length = 0
        # 가로
        for j in range(N):
            if mat[i][j]:
                length += 1
            if not mat[i][j] or j == N - 1:
                if length == K:
                    count += 1
                length = 0
        # 세로
        for j in range(N):
            if mat[j][i]:
                length += 1
            if not mat[j][i] or j == N - 1:
                if length == K:
                    count += 1
                length = 0
    print(f"#{t}", count)