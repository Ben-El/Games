import java.util.*;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char player = 'X';
        int roundCounter = 0;
        Cell[] board = new Cell[10];

        for (int i = 0; i < board.length; i++)
            board[i] = new Cell();

        int[][] winningVectors = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {1, 4, 7}, {2, 5, 8}, {3, 6, 9}, {1, 5, 9}, {3, 5, 7}};

        printBoard(board);

        while (true) {
            System.out.print("\nPlayer " + player + ", choose a cell (1 - 9):  ");
            int cellChoice = sc.nextInt();

            if (isValidInput(board, cellChoice)) {
                roundCounter++;
                board[cellChoice].setSign(player);

                if (isThereWinner(board, winningVectors, player)) {
                    printBoard(board);
                    System.out.println("\nPlayer " + player + " is The winner !!!");
                    break;
                } else if (roundCounter == 9) {
                    printBoard(board);
                    System.out.println("\nIt's a draw!!!");
                    break;
                } else printBoard(board);

                if (player == 'X') player = 'O';
                else player = 'X';
            }
        }
    }

    public static boolean isThereWinner(Cell[] board, int[][] winningVectors, char player) {
        for (int[] vector : winningVectors) {
            if (board[vector[0]].getSign() == player &&
                board[vector[0]].getSign() == board[vector[1]].getSign() &&
                board[vector[1]].getSign() == board[vector[2]].getSign()) {
                board[vector[0]].setColor(Cell.WINNING_COLOR);
                board[vector[1]].setColor(Cell.WINNING_COLOR);
                board[vector[2]].setColor(Cell.WINNING_COLOR);
                return true;
            }
        }

        return false;
    }

    public static boolean isValidInput(Cell[] board, int cellChoice) {
        if (cellChoice < 1 || cellChoice > 9) {
            printBoard(board);
            System.out.println("Your col choice is out of bound !!!");
            return false;
        } else if (board[cellChoice].getSign() != '-') {
            printBoard(board);
            System.out.println("This cell is taken !!! Enter another cell choice.");
            return false;
        }

        return true;
    }

    public static void printBoard(Cell[] board) {
        System.out.println();

        for (int i = 9; i >= 3; i -= 3) {
            System.out.print(board[i - 2].getColor() + board[i - 2].getSign() + Cell.DEFAULT_COLOR + "\t\t");
            System.out.print(board[i - 1].getColor() + board[i - 1].getSign() + Cell.DEFAULT_COLOR + "\t\t");
            System.out.print(board[i].getColor() + board[i].getSign() + Cell.DEFAULT_COLOR + "\n");
        }
    }
}