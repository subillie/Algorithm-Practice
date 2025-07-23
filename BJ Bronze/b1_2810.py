# 2810 컵홀더
import sys
INPUT = sys.stdin.readline

N = int(INPUT())
seats = INPUT().rstrip()
cup_holder = 1
couple_seat = 0
for seat in seats:
    if seat == "S":
        cup_holder += 1
    elif seat == "L":
        couple_seat += 1
cup_holder += couple_seat // 2
print(N) if cup_holder > N else print(cup_holder)