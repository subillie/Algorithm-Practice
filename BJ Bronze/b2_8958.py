# 8958 OX퀴즈
import sys
INPUT = sys.stdin.readline

T = int(INPUT())
for _ in range(T):
    quiz_result = INPUT().rstrip()
    score = length = 0
    for res in quiz_result:
        if res == 'O':
            length += 1
            score += length
        else:
            length = 0
    print(score)