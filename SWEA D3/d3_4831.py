# 4831 전기버스
T = int(input())
for t in range(1, T + 1):
    K, N, M = map(int, input().split())
    chargers = list(map(int, input().split()))
    stops = [False] * (N + 1)
    for charger in chargers:
        stops[charger] = True
    
    count = 0
    curr = 0
    while True:
        # 최대로 갈 수 있는 정류장 (현재 숫자 + K)
        next = curr + K
        if next >= N:
            break
        # 실제로 갈 정류장 (최대 지점과 가장 가까운 충전소)
        for chargable in range(next, curr, -1):
            if stops[chargable]:
                next = chargable
                count += 1
                break
        else:  # 충전기 설치가 잘못된 경우
            count = 0
            break
        # 충전이 가능하면, 다음 정류장으로 이동
        curr = next

    print(f"#{t}", count)