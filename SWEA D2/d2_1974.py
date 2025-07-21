# 1974 스도쿠 검증
def examine_rows(puzzle: list) -> int:
    for row in puzzle:
        if sorted(row) != list(range(1, 10)):
            return 0
    return 1

def examine_columns(puzzle: list) -> int:
    for col in range(9):
        col = [puzzle[row][col] for row in range(9)]
        if sorted(col) != list(range(1, 10)):
            return 0
    return 1

def examine_boxes(puzzle: list) -> int:
    for row in range(0, 9, 3):
        for col in range(0, 9, 3):
            box = []
            for r in range(row, row + 3):
                box.extend([x for x in puzzle[r][col:col + 3]])
                # for c in range(col, col + 3):
                #     box.append(puzzle[r][c])
            if sorted(box) != list(range(1, 10)):
                return 0
    return 1

if __name__ == "__main__":
    T = int(input())
    for t in range(T):
        puzzle = [list(map(int, input().split())) for _ in range(9)]
        answer = 0
        if examine_rows(puzzle):
            if examine_columns(puzzle):
                if examine_boxes(puzzle):
                    answer = 1
        print(f"#{t + 1}", answer)