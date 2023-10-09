import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TicTacToeTest {

    char player = 'X'; //
    int[][] winningVectors = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {1, 4, 7}, {2, 5, 8}, {3, 6, 9}, {1, 5, 9}, {3, 5, 7}};

    char[][] boards = {
            {
                    'X', 'X', 'X',
                    '-', '-', '-',
                    '-', '-', '-'
            },
            {
                    '-', '-', '-',
                    'X', 'X', 'X',
                    '-', '-', '-'
            },
            {
                    '-', '-', '-',
                    '-', '-', '-',
                    'X', 'X', 'X'
            },
            {
                    'X', '-', '-',
                    'X', '-', '-',
                    'X', '-', '-'
            },
            {
                    '-', 'X', '-',
                    '-', 'X', '-',
                    '-', 'X', '-'
            },
            {
                    '-', '-', 'X',
                    '-', '-', 'X',
                    '-', '-', 'X'
            },
            {
                    'X', '-', '-',
                    '-', 'X', '-',
                    '-', '-', 'X'
            },
            {
                    '-', '-', 'X',
                    '-', 'X', '-',
                    'X', '-', '-'
            },
            {
                    'X', 'X', 'O',
                    'O', 'O', 'X',
                    'X', 'O', 'X'
            },
            {
                    'X', '-', '-',
                    'O', '-', '-',
                    '-', '-', '-'
            }
    };

    @Test
    public void test() {
        for (char[] board : boards) {
            Cell[] convertedBoard = convertBoard(board);

            if (TicTacToe.isThereWinner(convertedBoard, winningVectors, player)) {
                TicTacToe.printBoard(convertedBoard);
                System.out.println("\nPlayer " + player + " is The winner !!!");
            } else if (isDraw(convertedBoard)) {
                TicTacToe.printBoard(convertedBoard);
                System.out.println("\nIt's a draw!!!");
            } else {
                TicTacToe.printBoard(convertedBoard);
                System.out.println("\nNothing, keep playing");
            }

            System.out.println("\n--------------------------");
        }
    }

    public Cell[] convertBoard(char[] board) {
        Cell[] convertedBoard = new Cell[10];
        convertedBoard[0] = new Cell(' '); // Fictive value for proper isDraw check

        convertedBoard[7] = new Cell(board[0]);
        convertedBoard[8] = new Cell(board[1]);
        convertedBoard[9] = new Cell(board[2]);
        convertedBoard[4] = new Cell(board[3]);
        convertedBoard[5] = new Cell(board[4]);
        convertedBoard[6] = new Cell(board[5]);
        convertedBoard[1] = new Cell(board[6]);
        convertedBoard[2] = new Cell(board[7]);
        convertedBoard[3] = new Cell(board[8]);

        return convertedBoard;
    }

    public boolean isDraw(Cell[] board) {
        return Arrays.stream(board).noneMatch(cell -> cell.getSign() == '-');
    }
}