# 12605 단어순서 뒤집기
import sys
INPUT = sys.stdin.readline

N = int(INPUT())
words = [INPUT().rstrip().split() for _ in range(N)]
for n in range(N):
    print(f"Case #{n + 1}:", ' '.join(words[n][::-1]))