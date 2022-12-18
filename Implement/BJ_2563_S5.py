import sys
INPUT = sys.stdin.readline

N = int(INPUT())
coordinates = [[0 for col in range(101)] for row in range(101)]

for i in range(N):
    x, y = map(int, INPUT().split())
    for i in range(x, x + 10):
        for j in range(y, y + 10):
            coordinates[i][j] = 1

cnt = 0
for j in coordinates:
    cnt += j.count(1)
print(cnt)
