# 2564 경비원
import sys
INPUT = sys.stdin.readline

def get_distance(direction, position):
    """
    가장 북남쪽 지점 기준, 반시계 방향으로 얼마나 떨어져있는지 구하는 함수
    """
    if direction == 3:  # 서
        distance = position
    elif direction == 2:  # 남
        distance = height + position
    elif direction == 4:  # 동
        distance = height * 2 + width - position
    else:  # 북
        distance = (height + width) * 2 - position
    return distance

width, height = map(int, INPUT().split())
num = int(INPUT())
stores = [tuple(map(int, INPUT().split())) for _ in range(num)]
direction, position = map(int, INPUT().split())
start = get_distance(direction, position)

# 가장 북남쪽 지점 기준, 아래쪽으로 맵을 펼친다고 상상하고 문제 풀기
result = 0
for direction, position in stores:
    store = get_distance(direction, position)
    way_1 = abs(store - start)  # 사이 거리
    way_2 = (height + width) * 2 - way_1  # 전체 둘레 - 사이 거리
    result += min(way_1, way_2)
print(result)