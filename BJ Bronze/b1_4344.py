C = int(input()) #C는 test case의 개수

for i in range(C):
  scoreSet = list(map(int, input().split()))
  avg = sum(scoreSet[1:])/scoreSet[0] #평균 구하기
  count = 0
  for j in scoreSet[1:]:
    if j > avg: count += 1
  rate = count / scoreSet[0] * 100 #평균 이상인 학생 비율 구하기
  print(f'{rate:.3f}%')
