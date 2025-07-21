# Floating Point Rounding Error
from decimal import Decimal

# case 1: round
print("1(1)", 0.1 + 0.2)
result = 0.1 + 0.2
print("1(2)", result)
print("1(3)", round(result, 1))  # 정답

print()

# case 2: float
result = float(0.1 + 0.2)
print("2(1)", result)
result = float(0.1) + float(0.2)
print("2(2)", result)

print()

# case 3: decimal
# result = Decimal('0.1' + '0.2')  # 에러
result = Decimal('0.1') + Decimal('0.2')  # 정답
print("3(1)", result)