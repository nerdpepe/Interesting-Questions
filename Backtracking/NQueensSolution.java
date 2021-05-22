import java.util.*;

public class NQueensSolution {

    static List<List<String>> finalBoard;
    static boolean fullyCompleted = false;

    {
        finalBoard = new ArrayList<>();
        //System.out.println("initiated");
    }

    static void prepareAnswer(char[][] board, int size) {
        List<String> row = new ArrayList<>();
        for(int i = 0; i<size; i++) {
            row.add(new String(board[i]));
        }
        System.out.println("ADDED");
        finalBoard.add(row);
    }

    static boolean isSafe(int row, int col, char[][] board, int n) {
        boolean safe = true;

        // check column from 0 to the given row
        for(int i = 0; i < row; i++) {
            if(board[i][col] == 'Q')
                return false;
        }

        // check left diagonal
        for(int i = row, j = col; i >= 0 && j>=0; i--,j--) {
            if(board[i][j] == 'Q')
                return false;
        }

        // check upper right diagonal
        for(int i = row, j = col; i >= 0 && j<n; i--,j++) {
            if(board[i][j] == 'Q')
                return false;
        }

        return safe;
    }

    static void solve(char[][] board, int currentRow) {
        int totalRowsToBeFilled = board[0].length;
        // base condition
        if (currentRow == totalRowsToBeFilled) {
            //make a  List<List<String>> from char[][]
            fullyCompleted = true;
            prepareAnswer(board,totalRowsToBeFilled);            
            return;
        }

        // loop for each row (as each row is to be filled)
        for (int i = 0; i < totalRowsToBeFilled; i++) {
            // check for safety
            if(isSafe(currentRow, i, board, totalRowsToBeFilled)) {
            // put Queen if safe
            board[currentRow][i] = 'Q';
            // proceed to next row
            solve(board,currentRow + 1);
            // if it reaches this, it means the 'next' row was not successful, hence put
            // dot(.) in the cell mentioned before it
            board[currentRow][i] = '.';
            }
        }

    }

    static List<List<String>> solveNQueens(int n) {
        // create a 2d array of char[n][n] and fill with dot(.) denoting empty cells
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';

        solve(board, 0);
        if(!fullyCompleted)
            prepareAnswer(board, n);        

        return finalBoard;
    }

    public static void main(String... arg) {
        new NQueensSolution();
        int n = 3;
        List<List<String>> ans = solveNQueens(n);
        for(int i = 0; i<ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}