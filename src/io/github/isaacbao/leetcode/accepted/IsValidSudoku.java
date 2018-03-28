package io.github.isaacbao.leetcode.accepted;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rongyang_lu on 2017/12/13.
 */
public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        try {
            boolean result = true;
            for (int row = 0; row < 9; row++) {
                result = validRow(board, row);
                if (!result) {
                    return false;
                }
            }

            for (int column = 0; column < 9; column++) {
                result = validColumn(board, column);
                if (!result) {
                    return false;
                }
            }

            result = validNineBlockBox(board);
            return result;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean validNineBlockBox(char[][] board) {
        for (int boxRow = 0; boxRow < 3; boxRow++) {
            for (int boxColumn = 0; boxColumn < 3; boxColumn++) {
                Set<Character> charSet = new HashSet<>();
                for (int blockRow = 0; blockRow < 3; blockRow++) {
                    for (int blockColumn = 0; blockColumn < 3; blockColumn++) {
                        char c = board[blockColumn + boxColumn * 3][blockRow + boxRow * 3];
                        if (c == '.') {
                            continue;
                        }
                        if (charSet.contains(c)) {
                            return false;
                        }
                        charSet.add(c);
                    }
                }
            }
        }
        return true;
    }

    private boolean validRow(char[][] board, int row) {
        Set<Character> set = new HashSet<>();
        char[] rowToBeValided = board[row];
        for (char c : rowToBeValided) {
            if (c == '.') {
                continue;
            }
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }

    private boolean validColumn(char[][] board, int column) {
        Set<Character> set = new HashSet<>();
        for (char[] charArray : board) {
            char c = charArray[column];
            if (c == '.') {
                continue;
            }
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }
}
