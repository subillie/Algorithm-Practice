# 2029 몫과 나머지 출력하기
T = int(input())
for t in range(1, T + 1):
    print(f"#{t}", end=" ")
    a, b = map(int, input().split())
    print(a // b, a % b)