# None과 False는 모두 False
# 결과가 정해지는 시점에 있는 것을 출력
# or -> 하나만 만족하면 됨 (모두 False면 마지막 변수, 하나라도 True면 그 지점에 있는 변수)
# and -> 모두 만족해야 함 (모두 True면 True, 하나라도 False면 그 지점에 있는 변수)

# True
print(True or None)  # True
print(None or True)  # True
print(True and None)  # None
print(None and True)  # None
print()

# False
print(False or None)  # None
print(None or False)  # False
print(False and None)  # False
print(None and False)  # None

print()

# None
print(None or None)  # None
print(None and None)  # None