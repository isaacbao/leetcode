package io.github.isaacbao.leetcode.accepted;

import java.util.HashMap;

/**
 * Created by rongyang_lu on 2017/10/13.
 */
public class LongestSubString {
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int stringLength = s.length();
        HashMap<Character, Integer> indexOfCharInSlidingWindows = new HashMap<>();
        int i = 0;
        int j = 0;
        while (i < stringLength && j < stringLength) {
            StringBuilder stringInCurrentWindow = new StringBuilder(s);
            char c = s.charAt(j);
            Integer indexOfChar = indexOfCharInSlidingWindows.get(c);

            if (null != indexOfChar && !indexOfChar.equals(j)) {
                if (indexOfChar >= i) {
                    maxLength = Math.max(maxLength, j - indexOfChar);
                    i = indexOfChar + 1;
                }
            }
            indexOfCharInSlidingWindows.put(c, j);
            j++;
            maxLength = Math.max(maxLength, j - i);
            stringInCurrentWindow.insert(i, "|");
            stringInCurrentWindow.insert(j + 1, "|");
            System.out.println(stringInCurrentWindow.toString());
            System.out.println(indexOfCharInSlidingWindows.toString());
        }

        return maxLength;
    }
}
