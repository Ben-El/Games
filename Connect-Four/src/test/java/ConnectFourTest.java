import org.junit.jupiter.api.Test;

public class ConnectFourTest {

    char player = 'X';

    char[][][] boards = {
            {
                    {'-', '-', '-', '-', '-'},
                    {'-', '-', '-', '-', '-'},
                    {'-', '-', '-', '-', '-'},
                    {'X', 'X', 'X', 'X', '-'}
            },
            {
                    {'-', '-', '-', '-', '-'},
                    {'-', '-', '-', '-', '-'},
                    {'-', '-', '-', '-', '-'},
                    {'-', 'X', 'X', 'X', 'X'}
            },
            {
                    {'-', 'X', '-', '-', '-'},
                    {'-', 'X', '-', '-', '-'},
                    {'-', 'X', '-', '-', '-'},
                    {'-', 'X', 'O', 'O', 'O'}
            },
            {
                    {'-', 'X', '-', '-', 'X'},
                    {'-', 'O', '-', 'X', 'X'},
                    {'-', 'X', 'X', 'O', 'X'},
                    {'-', 'X', 'O', 'O', 'O'}
            },
            {
                    {'X', 'O', '-', '-', 'O'},
                    {'O', 'X', '-', 'O', 'O'},
                    {'X', 'O', 'X', 'X', 'O'},
                    {'O', 'O', 'X', 'X', 'X'}
            },
            {
                    {'-', '-', '-', '-', 'X'},
                    {'X', 'O', '-', 'X', 'X'},
                    {'O', 'X', 'O', 'O', 'X'},
                    {'X', 'X', 'O', 'O', 'X'}
            },
            {
                    {'-', '-', '-', '-', 'X'},
                    {'X', 'O', '-', 'X', 'X'},
                    {'O', 'X', 'O', 'O', 'X'},
                    {'X', 'X', 'O', 'O', 'O'}
            },
            {
                    {'-', '-', '-', '-', '-'},
                    {'-', '-', '-', '-', '-'},
                    {'-', '-', '-', '-', '-'},
                    {'X', 'O', 'X', 'X', 'X'}
            },
            {
                    {'-', '-', '-', '-', '-'},
                    {'-', '-', '-', '-', '-'},
                    {'-', '-', '-', '-', '-'},
                    {'-', 'X', 'X', 'X', '-'}
            },
            {
                    {'-', 'O', '-', '-', '-'},
                    {'-', 'X', '-', '-', '-'},
                    {'-', 'O', '-', '-', '-'},
                    {'-', 'O', 'X', 'X', 'X'}
            },
            {
                    {'-', 'O', '-', '-', 'O'},
                    {'-', 'X', '-', 'O', 'O'},
                    {'-', 'O', 'X', 'X', 'O'},
                    {'-', 'O', 'X', 'X', 'X'}
            },
            {
                    {'-', 'O', '-', '-', 'O'},
                    {'O', 'X', '-', 'O', 'O'},
                    {'X', 'O', 'X', 'X', 'O'},
                    {'O', 'O', 'X', 'X', 'X'}
            },
            {
                    {'-', '-', '-', '-', '-'},
                    {'O', 'X', '-', 'O', 'O'},
                    {'X', 'O', 'X', 'X', 'O'},
                    {'O', 'O', 'X', 'X', 'O'}
            },
            {
                    {'O', 'O', 'O', 'X', 'O'},
                    {'X', 'X', 'X', 'O', 'X'},
                    {'O', 'O', 'O', 'X', 'O'},
                    {'X', 'X', 'X', 'O', 'X'}
            }
    };

    @Test
    public void test() {
        for (char[][] board : boards) {
            Cell[][] convertedBoard = convertBoard(board);

            if (ConnectFour.checkWinForPlayer(convertedBoard, player)) {
                ConnectFour.printBoard(convertedBoard);
                System.out.println("\nPlayer " + player + " is The winner !!!");
            } else if (isDraw(convertedBoard)) {
                ConnectFour.printBoard(convertedBoard);
                System.out.println("\nIt's a draw!!!");
            } else {
                ConnectFour.printBoard(convertedBoard);
                System.out.println("\nNothing, keep playing");
            }

            System.out.println("\n==========================");
        }
    }

    public Cell[][] convertBoard(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        Cell[][] convertedBoard = new Cell[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'X')
                    convertedBoard[i][j] = new Cell('X');
                else if (board[i][j] == 'O')
                    convertedBoard[i][j] = new Cell('O');
                else
                    convertedBoard[i][j] = new Cell('-');
            }
        }

        return convertedBoard;
    }

    public boolean isDraw(Cell[][] board) {
        for (Cell[] cells : board) {
            for (int j = 0; j < board[0].length; j++) {
                if (cells[j].getSign() == '-')
                    return false;
            }
        }

        return true;
    }
}