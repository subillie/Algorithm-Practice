# 1936 1대1 가위바위보
A, B = map(int, input().split())
if (A == 1 and B == 2) or (A == 2 and B == 3) or (A == 3 and B == 1):
    print("B")
else:
    print("A")