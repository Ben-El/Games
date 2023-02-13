import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConnectFour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char player = 'X';
        int roundCounter = 0;
        int rows = 4, cols = 5; // Original Connect Four game is 6X7
        Cell[][] board = new Cell[rows][cols];

        Map<Integer, Integer> rowsInColsMap = new HashMap<>();

        for (int i = 0; i < cols; i++)
            rowsInColsMap.put(i, rows - 1);

        initBoard(board);
        printBoard(board);

        while (true) {
            System.out.print("\nPlayer " + player + ", choose a column:  ");
            int colChoice = sc.nextInt();

            if (isValidInput(board, rowsInColsMap, colChoice)) {
                roundCounter++;
                int currentRowInCol = rowsInColsMap.get(colChoice);
                board[currentRowInCol][colChoice].setSign(player);
                rowsInColsMap.put(colChoice, currentRowInCol - 1);

                if (checkWinForPlayer(board, player)) {
                    printBoard(board);
                    System.out.println("\nPlayer " + player + " is The winner !!!");
                    break;
                } else if (roundCounter == rows * cols) {
                    printBoard(board);
                    System.out.println("\nIt's a draw!!!");
                    break;
                } else printBoard(board);
            } else continue;

            if (player == 'X') player = 'O';
            else player = 'X';
        }
    }

    public static boolean checkWinForPlayer(Cell[][] board, char player) {
        int rows = board.length;
        int cols = board[0].length;
        int[] offsets = {0, 1, 2, 3};

        // Check rows
        for (Cell[] cells : board)
            for (int j = 0; j < cols - 3; j++)
                if (cells[j].getSign() == player &&
                        cells[j + 1].getSign() == player &&
                        cells[j + 2].getSign() == player &&
                        cells[j + 3].getSign() == player) {
                    for (int offset : offsets)
                        cells[j + offset].setColor(Cell.WINNING_COLOR);

                    return true;
                }

        // Check cols
        for (int i = 0; i < rows - 3; i++)
            for (int j = 0; j < cols; j++)
                if (board[i][j].getSign() == player &&
                        board[i + 1][j].getSign() == player &&
                        board[i + 2][j].getSign() == player &&
                        board[i + 3][j].getSign() == player) {
                    for (int offset : offsets)
                        board[i + offset][j].setColor(Cell.WINNING_COLOR);

                    return true;
                }

        // Check diagonals
        for (int i = 0; i < rows - 3; i++)
            for (int j = 0; j < cols; j++) {
                if ((j <= cols / 2 && j + 3 < cols &&
                        board[i][j].getSign() == player &&
                        board[i + 1][j + 1].getSign() == player &&
                        board[i + 2][j + 2].getSign() == player &&
                        board[i + 3][j + 3].getSign() == player)) {
                    for (int offset : offsets)
                        board[i + offset][j + offset].setColor(Cell.WINNING_COLOR);

                    return true;
                } else if (j >= cols / 2 && j - 3 >= 0 &&
                        board[i][j].getSign() == player &&
                        board[i + 1][j - 1].getSign() == player &&
                        board[i + 2][j - 2].getSign() == player &&
                        board[i + 3][j - 3].getSign() == player) {
                    for (int offset : offsets)
                        board[i + offset][j - offset].setColor(Cell.WINNING_COLOR);

                    return true;
                }
            }

        return false;
    }

    public static void initBoard(Cell[][] board) {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                board[i][j] = new Cell();
    }

    public static boolean isValidInput(Cell[][] board, Map<Integer, Integer> map, int colChoice) {
        if (colChoice < 0 || colChoice > board[0].length - 1) {
            printBoard(board);
            System.out.println("Your col choice is out of bound !!!");
            return false;
        } else if (map.get(colChoice) < 0) {
            printBoard(board);
            System.out.println("This col is full !!! Enter another col choice.");
            return false;
        }

        return true;
    }

    public static void printBoard(Cell[][] board) {
        System.out.println();

        for (int j = 0; j < board[0].length; j++)
            System.out.print(j + "\t");

        System.out.println();

        for (int j = 0; j < 4 * board[0].length - 2; j++)
            System.out.print("-");

        System.out.println();

        for (Cell[] cells : board) {
            for (int i = 0; i < board[0].length; i++)
                System.out.print(cells[i].getColor() + cells[i].getSign() + Cell.DEFAULT_COLOR + "\t");

            System.out.println();
        }
    }
}