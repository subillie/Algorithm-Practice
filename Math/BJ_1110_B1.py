num = int(input())
count = 0
inputNum = num

while 1:
  if num < 10:
    left = 0
    right = num
  else:
    left = num // 10
    right = num % 10
  tmp = left + right
  tmp2 = right * 10 + tmp % 10
  count += 1
  if tmp2 == inputNum: break
  else: num = tmp2

print(count)
