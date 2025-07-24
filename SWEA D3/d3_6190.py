# 6190 정곤이의 단조 증가하는 수
T = int(input())
for t in range(1, T + 1):
    N = int(input())
    nums = sorted(list(map(int, input().split())), reverse=True)

    max_num = -1
    for i in range(len(nums)):
        for j in range(i + 1, len(nums)):
            product = nums[i] * nums[j]
            product_str = str(product)
            for index in range(len(product_str) - 1):
                if product_str[index] > product_str[index + 1]:
                    break
            else:
                max_num = max(max_num, product)
            # 시간 초과
            # if list(str(product)) == sorted(str(product)):
            #     max_num = max(max_num, product)

    print(f"#{t} {max_num}")