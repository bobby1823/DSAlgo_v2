package io.ghost.datastructure.arraystring;

import java.util.HashSet;

/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 */
public class Sudoku_Problem {

    public static void main(String[] args) {
        System.out.println(isValidSudoku(new char[][]{
                 {'.','.','.','.','5','.','.','1','.'}
                ,{'.','4','.','3','.','.','.','.','.'}
                ,{'.','.','.','.','.','3','.','.','1'}
                ,{'8','.','.','.','.','.','.','2','.'}
                ,{'.','.','2','.','7','.','.','.','.'}
                ,{'.','1','5','.','.','.','.','.','.'}
                ,{'.','.','.','.','.','2','.','.','.'}
                ,{'.','2','.','9','.','.','.','.','.'}
                ,{'.','.','4','.','.','.','.','.','.'}
        }));
    }

    /**
     * 9*9 matrix
     * 
     * At any given point of board[i][j]
     * Algo:
     * 1. First maintain a loop (for row) to check if element is valid for row. I.E, only on instance of element should
     *    present in the respective row. Using HashSet. here we use HashSet since in HashSet O(n) is 1.
     *    
     * 2. Do same for column as well.
     * 
     * 3. Now we must divide entire 9*9 matrix in 3*3 matrix to check the element is unique in each 9 3*3 sub-matrix
     *    We can do this by row = row/3, column = column/3
     * 
     * 
     */
    public static boolean isValidSudoku(char[][] board) {
        boolean isValidSudoku = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.println(checkGrid(board, i-i%3, j-j%3));
                if (!(checkRow(board, i) && checkColumn(board, j) && checkGrid(board, i-i%3, j-j%3))) {
                    return false;
                }
            }
        }   
        return isValidSudoku;
    }

    // Note this method. We are checking each element
    private static boolean checkGrid(char[][] board, int row, int col) {
        HashSet<Character> gridSet = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i+row][j+col] == '.')
                    continue;
                if (gridSet.contains(board[i+row][j+col])){
                    return false;
                }
                gridSet.add(board[i+row][j+col]);
            }
        }
        return true;
    }

    private static boolean checkColumn(char[][] board, int col) {
        HashSet<Character> columnSet = new HashSet<>();
        for (int k = 0; k < 9; k++) {
            if (board[k][col] == '.')
                continue;
            if (columnSet.contains(board[k][col])){
                return false;
            }
            columnSet.add(board[k][col]);
        }
        return true;
    }

    private static boolean checkRow(char[][] board, int row) {
        HashSet<Character> rowSet = new HashSet<>();
        for (int k = 0; k < 9; k++) {
            if (board[row][k] == '.')
                continue;
            if (rowSet.contains(board[row][k])){
                return false;
            }
            rowSet.add(board[row][k]);
        }
        return true;
    }
}
