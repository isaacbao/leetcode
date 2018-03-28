package io.github.isaacbao.leetcode.accepted;

import java.util.*;

/**
 * Created by rongyang_lu on 2017/11/14.
 */
public class LetterCombinations {
    private static Map<Integer, String> DIGIT_LETTER_MAP = new HashMap<>();

    static {
        DIGIT_LETTER_MAP.put(0, "0");
        DIGIT_LETTER_MAP.put(1, "1");
        DIGIT_LETTER_MAP.put(2, "abc");
        DIGIT_LETTER_MAP.put(3, "def");
        DIGIT_LETTER_MAP.put(4, "ghi");
        DIGIT_LETTER_MAP.put(5, "jkl");
        DIGIT_LETTER_MAP.put(6, "mno");
        DIGIT_LETTER_MAP.put(7, "pqrs");
        DIGIT_LETTER_MAP.put(8, "tuv");
        DIGIT_LETTER_MAP.put(9, "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (!digits.matches("\\d+")) {
            return result;
        }
        result.add("");

        int combinationLength = digits.length();

        for (int i = 0; i < combinationLength; i++) {
            List<String> tempResult = new ArrayList<>();
            int digit = Integer.parseInt(digits.charAt(i) + "");
            String lettersOfCurrentDigit = DIGIT_LETTER_MAP.get(digit);
            result.forEach(str -> {
                StringBuilder lettersOfCurrentDightBuilder = new StringBuilder(lettersOfCurrentDigit);
                while (lettersOfCurrentDightBuilder.length() != 0) {
                    tempResult.add(str + lettersOfCurrentDightBuilder.charAt(0));
                    lettersOfCurrentDightBuilder.deleteCharAt(0);
                }
            });
            result = tempResult;
        }
        return result;
    }

}
