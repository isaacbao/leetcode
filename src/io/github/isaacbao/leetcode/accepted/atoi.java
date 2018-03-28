package io.github.isaacbao.leetcode.accepted;

/**
 * Created by rongyang_lu on 2017/11/2.
 */
public class atoi {
    public int myAtoi(String str) {
        if (null == str || str.isEmpty()) {
            return 0;
        }
        str = str.trim();
        int result = 0;
        int length = str.length();
        int sign = 1;
        int firstDigitIndex = 0;
        char firstChar = str.charAt(0);
        if ('+' == firstChar) {
            sign = 1;
            firstDigitIndex = 1;
        }
        if ('-' == firstChar) {
            sign = -1;
            firstDigitIndex = 1;
        }
        for (int i = firstDigitIndex; i < length; i++) {
            char c = str.charAt(i);
            if (!isDigit(c)) {
                break;
            }
            int currentDigit = c - '0';
            if (Integer.MAX_VALUE / 10 < result ||
                    (Integer.MAX_VALUE / 10 == result && Integer.MAX_VALUE % 10 < currentDigit)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + currentDigit;
        }
        result = sign * result;
        return result;
    }

    private boolean isDigit(char c) {
        return '0' <= c && c <= '9';
    }


}
