# 올림, 내림, 반올림
import math

num = 1.23456

# 소수점 셋째 자리까지 출력 (버림)
print("format {:.3f}".format(num))
print(f"f-string {num:.3f}")
print("print %.3f" %num)

# 소수점 셋째 자리까지 출력 (반올림)
print("\n[ROUND 자릿수 지정 O]")
print("round", round(num, 3))
print("round", round(num - 1, 3))

print("\n[ROUND 자릿수 지정 X]")
print("round", round(num))  # 정수 부분이 홀수면 올림
print("round", round(num - 1))  # 정수 부분이 짝수면 내림

print("\n[CEIL, FLOOR]")
print("ceil", math.ceil(num))  # 올림
print("floor", math.floor(num))  # 내림
print("floor", math.floor(num + 0.5))  # 반올림