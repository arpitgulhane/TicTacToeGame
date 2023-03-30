package game;
public class TicTacToeGame {
    private char[] board;

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

    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        game.displayBoard();
        game.placeMark(1, 'X');
        game.placeMark(2, 'O');
        game.placeMark(5, 'X');
        game.placeMark(9, 'O');
        game.placeMark(3, 'X');
        game.placeMark(4, 'O');
        game.placeMark(7, 'X');
        game.placeMark(8, 'O');
        game.placeMark(6, 'X');
        game.displayBoard();
        if (game.hasWon('X')) {
            System.out.println("X wins!");
        } else if (game.hasWon('O')) {
            System.out.println("O wins!");
        } else if (game.isBoardFull()) {
            System.out.println("Tie game!");
        }
    }
}
