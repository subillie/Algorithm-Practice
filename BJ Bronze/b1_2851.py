# 2851 슈퍼 마리오
import sys
INPUT = sys.stdin.readline

history = [int(INPUT()) for _ in range(10)]
turn = score = 0
for turn, mushroom in enumerate(history):
    score += mushroom
    if score >= 100:
        break
if (score - 100) > (100 - (score - history[turn])):
    score -= history[turn]
print(score)