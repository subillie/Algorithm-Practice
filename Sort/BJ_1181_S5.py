import sys
INPUT = sys.stdin.readline

n = int(INPUT())
words = []

for i in range(n):
    words.append(INPUT().rstrip())
no_overlap = set(words)
words = list(no_overlap)
words.sort()
words.sort(key = len)

for j in words:
    print(j)
