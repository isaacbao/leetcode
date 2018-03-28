package io.github.isaacbao.leetcode.accepted;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * <p>
 * https://leetcode.com/problems/zigzag-conversion/description/
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        int length = s.length();
        StringBuilder result = new StringBuilder();
        if (numRows == 1) {
            return s;
        }
        for (int row = 0; row < numRows; row++) {
            int charIndex = row;
            while (charIndex < length) {
                result.append(s.charAt(charIndex));
                charIndex += (2 * numRows - 2);
                if (row != 0 && row != numRows - 1) {
                    int charIndexOfEvenColumn = charIndex - (2 * row);
                    if (charIndexOfEvenColumn < length) {
                        result.append(s.charAt(charIndexOfEvenColumn));
                    }
                }
            }
        }
        return result.toString();
    }

}
