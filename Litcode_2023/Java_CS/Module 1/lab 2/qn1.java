public class Main {
    public static void main(String[] args) {
        char[][] sudokuBoard = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };

        boolean isValid = val_sudoku(sudokuBoard);

        if (isValid) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static boolean val_sudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!check(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean check(char[][] board, int row, int column) {
        int count = 0;
        for (int i = 0; i < 9; i++) {
            if (i != row && board[i][column] == board[row][column]) {
                return false;
            }
            if (i != column && board[row][i] == board[row][column]) {
                return false;
            }
            if (board[3 * (row / 3) + i / 3][3 * (column / 3) + i % 3] == board[row][column]) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}