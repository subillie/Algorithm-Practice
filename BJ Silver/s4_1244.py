# 1244 스위치 켜고 끄기
import sys
INPUT = sys.stdin.readline

N = int(INPUT())
switches = list(map(int, INPUT().split()))

for _ in range(int(INPUT())):
    sex, num = map(int, INPUT().split())
    if sex == 1:  # 남학생
        for n in range(num, N + 1, num):
            switches[n - 1] = 1 - switches[n - 1]
    else:  # 여학생
        index = num - 1
        switches[index] = 1 - switches[index]
        gap = 1
        while 0 <= index - gap and index + gap < N:
            if switches[index - gap] != switches[index + gap]:
                break
            switches[index - gap] = 1 - switches[index - gap]
            switches[index + gap] = 1 - switches[index + gap]
            gap += 1

for i in range(N):
    print(switches[i], end=" ")
    if (i + 1) % 20 == 0:
        print()