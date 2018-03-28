package io.github.isaacbao.leetcode.accepted;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * Created by rongyang_lu on 2017/10/18.
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int stringLength = s.length();
        PalindromicString result = new PalindromicString(0, "");
        for (int i = 0; i < stringLength; i++) {
            char middleChar = s.charAt(i);
            if (result.length < 2) {
                result.length = 1;
                result.str = middleChar + "";
            }
            if (i + 1 < stringLength) {
                if (i > 0 && s.charAt(i + 1) == s.charAt(i - 1)) {
                    PalindromicString palindromicString = new PalindromicString(1, "");
                    Anchors anchors = new Anchors(i - 1, i + 1);
                    moveAnchor(s, stringLength, palindromicString, result, anchors);
                }
                if (s.charAt(i + 1) == middleChar) {
                    PalindromicString palindromicString = new PalindromicString(2, "");
                    Anchors anchors = new Anchors(i - 1, i + 2);
                    moveAnchor(s, stringLength, palindromicString, result, anchors);
                }
            }
        }
        return result.str;
    }

    private void moveAnchor(String s, int stringLength, PalindromicString palindromicString, PalindromicString result, Anchors anchors) {
        while (anchors.leftAnchor > -1 && anchors.rightAnchor < stringLength) {
            if (s.charAt(anchors.leftAnchor) == s.charAt(anchors.rightAnchor)) {
                palindromicString.length += 2;
                anchors.leftAnchor--;
                anchors.rightAnchor++;
            } else {
                break;
            }
        }
        if (palindromicString.length > result.length) {
            result.length = palindromicString.length;
            result.str = s.substring(anchors.leftAnchor + 1, anchors.rightAnchor);
        }
    }

    class Anchors {
        public int leftAnchor;
        public int rightAnchor;

        public Anchors(int leftAnchor, int rightAnchor) {
            this.leftAnchor = leftAnchor;
            this.rightAnchor = rightAnchor;
        }

        @Override
        public String toString() {
            return "Anchors{" +
                    "leftAnchor=" + leftAnchor +
                    ", rightAnchor=" + rightAnchor +
                    '}';
        }
    }

    class PalindromicString {
        public int length;
        public String str;

        public PalindromicString(int length, String str) {
            this.length = length;
            this.str = str;
        }

        @Override
        public String toString() {
            return "PalindromicString{" +
                    "length=" + length +
                    ", str='" + str + '\'' +
                    '}';
        }
    }
}
