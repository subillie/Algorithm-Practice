# 2628 종이자르기
import sys
INPUT = sys.stdin.readline

width, height = map(int, INPUT().split())
cut_count = int(INPUT())
horizontal_cut = []
vertical_cut = []
for _ in range(cut_count):
    is_vertical, position = map(int, INPUT().split())
    if is_vertical:
        vertical_cut.append(position)
    else:
        horizontal_cut.append(position)
vertical_cut.sort()
horizontal_cut.sort()

widths = []
prev = 0
for cut in vertical_cut:
    widths.append(cut - prev)
    prev = cut
widths.append(width - prev)

heights = []
prev = 0
for cut in horizontal_cut:
    heights.append(cut - prev)
    prev = cut
heights.append(height - prev)

area = 0
for w in widths:
    for h in heights:
        area = max(area, w * h)
print(area)