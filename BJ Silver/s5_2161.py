# 2161 카드1
from collections import deque
import sys
INPUT = sys.stdin.readline

N = int(INPUT())
cards = deque(n + 1 for n in range(N))
while len(cards) > 1:
    print(cards.popleft(), end=' ')
    card = cards.popleft()
    cards.append(card)
print(cards[0])