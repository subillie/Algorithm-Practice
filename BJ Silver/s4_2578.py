# 2578 빙고
import sys
INPUT = sys.stdin.readline

def find_index(lst, target):
    for i in range(5):
        for j in range(5):
            if lst[i][j] == target:
                return i, j

board = [list(map(int, INPUT().split())) for _ in range(5)]  # 이차원 배열
calls = []  # 일차원 배열
for _ in range(5):
    calls += list(map(int, INPUT().split()))

bingo_count = 0
for index, num in enumerate(calls, start=1):
    # 빙고판에서 숫자 지우기
    i, j = find_index(board, num)
    board[i][j] = -1
    
    if all(board[i][iter] == -1 for iter in range(5)):  # 가로
        bingo_count += 1
    if all(board[iter][j] == -1 for iter in range(5)):  # 세로
        bingo_count += 1
    if i == j and all(board[iter][iter] == -1 for iter in range(5)):  # 대각선
        bingo_count += 1
    if i + j == 4 and all(board[iter][4 - iter] == -1 for iter in range(5)):
        bingo_count += 1

    # 빙고가 3개 이상이면 게임 끝
    if bingo_count >= 3:
        print(index)
        break