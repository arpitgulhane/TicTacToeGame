package game;
import java.util.Scanner;

public class TicTacToeGame {
    private char[] board;
    private char playerMark;
    private char computerMark;

    public TicTacToeGame() {
        board = new char[10];
        for (int i = 1; i < board.length; i++) {
            board[i] = ' ';
        }
    }

    public void displayBoard() {
        System.out.println(" " + board[1] + " | " + board[2] + " | " + board[3] + " ");
        System.out.println("---+---+---");
        System.out.println(" " + board[4] + " | " + board[5] + " | " + board[6] + " ");
        System.out.println("---+---+---");
        System.out.println(" " + board[7] + " | " + board[8] + " | " + board[9] + " ");
    }

    public boolean placeMark(int position, char mark) {
        if (position < 1 || position > 9 || board[position] != ' ') {
            return false;
        }
        board[position] = mark;
        return true;
    }

    public boolean isBoardFull() {
        for (int i = 1; i < board.length; i++) {
            if (board[i] == ' ') {
                return false;
            }
        }
        return true;
    }

    public boolean hasWon(char mark) {
        return (board[1] == mark && board[2] == mark && board[3] == mark) ||
                (board[4] == mark && board[5] == mark && board[6] == mark) ||
                (board[7] == mark && board[8] == mark && board[9] == mark) ||
                (board[1] == mark && board[4] == mark && board[7] == mark) ||
                (board[2] == mark && board[5] == mark && board[8] == mark) ||
                (board[3] == mark && board[6] == mark && board[9] == mark) ||
                (board[1] == mark && board[5] == mark && board[9] == mark) ||
                (board[3] == mark && board[5] == mark && board[7] == mark);
    }

    public void choosePlayerMark() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose X or O:");
            String input = scanner.nextLine().toUpperCase();
            if (input.equals("X")) {
                playerMark = 'X';
                computerMark = 'O';
                break;
            } else if (input.equals("O")) {
                playerMark = 'O';
                computerMark = 'X';
                break;
            } else {
                System.out.println("Invalid input, please try again.");
            }
        }
    }

    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        game.choosePlayerMark();
        System.out.println("You are " + game.playerMark + ", computer is " + game.computerMark);
        game.displayBoard();
        // game logic goes here
    }
}
