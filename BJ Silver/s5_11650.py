# 11650 좌표 정렬하기
import sys
input = sys.stdin.readline

N = int(input())
arr = []
for _ in range(N):
    arr.append(tuple(map(int, input().split())))

# 정렬 우선순위 설정하려면 sort 메소드의 key 인자 재정의
# e.g. arr.sort(key=lambda x: (x[1], x[0]))
arr.sort()

for x, y in arr:
    print(x, y)