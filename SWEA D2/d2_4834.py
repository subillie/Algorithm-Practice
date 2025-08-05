# 4834 숫자 카드
T = int(input())
for t in range(1, T + 1):
    # 숫자 카드가 담긴 nums 배열 초기화
    N = int(input())
    nums = list(map(int, list(input())))

    # counts 배열 초기화 및 가장 많은 카드 찾기
    counts = [0] * 10
    for num in nums:
        counts[num] += 1
    max_count = max(counts)

    # 가장 많은 카드에 적인 숫자(num)와 카드 수(count) 출력
    for num, count in list(enumerate(counts))[::-1]:
        if count == max_count:
            print(f"#{t}", num, count)
            break