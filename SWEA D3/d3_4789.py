# 4789 성공적인 공연 기획
T = int(input())
for t in range(1, T + 1):
    crowd = input()
    hired = 0
    clapping = 0
    for i in range(len(crowd)):
        ashamed = i - clapping
        if ashamed > 0:
            hired += ashamed
            clapping += ashamed
        clapping += int(crowd[i])
    print(f"#{t}", hired)