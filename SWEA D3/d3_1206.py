# 1206 View
for t in range(1, 11):
    N = int(input())
    deq = list(map(int, input().split()))

    count = 0
    for i in range(2, N - 2):
        highest = max(deq[i - 2], deq[i - 1], deq[i + 1], deq[i + 2])
        if deq[i] > highest:
            count += deq[i] - highest
    print(f"#{t}", count)