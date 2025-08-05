# 1208 Flatten
for t in range(1, 11):
    N = int(input())
    arr = list(map(int, input().split()))

    for i in range(N):
        max_arr = max(arr)
        min_arr = min(arr)
        # 평탄화가 완료되면 즉시 종료
        if max_arr - min_arr <= 1:
            break
        # 덤프 수행
        arr[arr.index(max_arr)] -= 1
        arr[arr.index(min_arr)] += 1

    print(f"#{t}", max(arr) - min(arr))