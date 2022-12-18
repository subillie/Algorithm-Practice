#include <stdio.h>
#include <stdlib.h>

int	check_index(int x, int y, int *board)
{
	for (int i = 0; i < x; i++)
	{
		if (board[i] == y)
			return 0;
		if (board[i] == y - (x - i) || board[i] == y + (x - i))
			return 0;
	}
	return 1;
}

void	put_queens(int x, int y, int *count, int *board, int num)
{
	if (x == num)
		*count += 1;
	else
	{
		y = 0;
		while (y < num)
		{
			board[x] = y;
			if (check_index(x, y, board))
				put_queens(x + 1, y, count, board, num);
			y++;
		}
	}
}

int	main()
{
	int	num, count = 0;
	scanf("%d", &num);
	int	*board = (int *)malloc(sizeof(int) * num);
	for (int i = 0; i < num; i++)
		board[i] = 0;
	put_queens(0, 0, &count, board, num);
	printf("%d", count);
	free(board);
	return 0;
}
