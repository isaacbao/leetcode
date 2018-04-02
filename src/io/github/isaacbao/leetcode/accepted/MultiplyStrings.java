package io.github.isaacbao.leetcode.accepted;

/**
 * Created by rongyang_lu on 2017/12/19.
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        StringBuilder resultReversed = new StringBuilder("0");
        if("0".equals(num1)||"0".equals(num2)){
            return "0";
        }
        StringBuilder num1Reversed = new StringBuilder(num1).reverse();
        StringBuilder num2Reversed = new StringBuilder(num2).reverse();
        for (int i = 0; i < num2.length(); i++) {
            int singleDigit = num2Reversed.charAt(i) - '0';
            StringBuilder tempNumber = multiplySingleDigit(num1Reversed, singleDigit);
            for (int offset = 0; offset < i; offset++) {
                tempNumber.insert(0, "0");
            }
            resultReversed = plus(resultReversed, tempNumber);
        }

        return resultReversed.reverse().toString();
    }

    public StringBuilder multiplySingleDigit(StringBuilder reversedNumString, int singleDigit) {
        StringBuilder result = new StringBuilder();
        if (singleDigit == 0) {
            result.append(0);
            return result;
        }
        int carry = 0;
        for (int i = 0; i < reversedNumString.length(); i++) {
            int a = reversedNumString.charAt(i) - '0';
            int currentDigit = a * singleDigit + carry;
            carry = currentDigit / 10;
            if (currentDigit > 9) {
                currentDigit %= 10;
            }
            result.append(currentDigit);
        }
        if (carry != 0) {
            result.append(carry);
        }

        return result;
    }

    public StringBuilder plus(StringBuilder reversedNumString1, StringBuilder reversedNumString2) {
        StringBuilder result = new StringBuilder();
        StringBuilder shorterNum;
        StringBuilder longerNum;
        int shorterLength;
        int longerLength;
        if (reversedNumString1.length() < reversedNumString2.length()) {
            shorterNum = new StringBuilder(reversedNumString1);
            longerNum = new StringBuilder(reversedNumString2);
            shorterLength = reversedNumString1.length();
            longerLength = reversedNumString2.length();
        } else {
            shorterNum = new StringBuilder(reversedNumString2);
            longerNum = new StringBuilder(reversedNumString1);
            shorterLength = reversedNumString2.length();
            longerLength = reversedNumString1.length();
        }
//        shorterNum.reverse();
//        longerNum.reverse();
        int carry = 0;
        for (int i = 0; i < shorterLength; i++) {
            int a = shorterNum.charAt(i) - '0';
            int b = longerNum.charAt(i) - '0';
            int digit = a + b + carry;
            carry = digit / 10;
            if (digit > 9) {
                digit %= 10;
            }
            result.append(digit);
        }
        for (int i = shorterLength; i < longerLength; i++) {
            int b = longerNum.charAt(i) - '0';
            int digit = b + carry;
            carry = digit / 10;
            if (digit > 9) {
                digit %= 10;
                result.append(digit);
            } else {
                result.append(digit);
                if (i < longerLength - 1) {
                    result.append(longerNum.subSequence(i + 1, longerNum.length()));
                }
                break;
            }
        }
        if(carry>0){
            result.append(carry);
        }
//        return result.reverse();
        return result;
    }


}
