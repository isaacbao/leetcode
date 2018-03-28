package io.github.isaacbao.leetcode.accepted;

/**
 * Created by rongyang_lu on 2017/12/7.
 */
public class Divide {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        long result = absDividend/absDivisor;
        if(result>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(result<Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return Math.toIntExact(result);
//        if (isPositive(dividend, divisor)) {
//            result--;
//            while (absDividend >= 0) {
//                absDividend -= absDivisor;
//                result++;
//                if (result == Integer.MAX_VALUE) {
//                    return result;
//                }
//            }
//        } else {
//            result++;
//            while (absDividend >= 0) {
//                absDividend -= absDivisor;
//                result--;
//                if (result == Integer.MIN_VALUE) {
//                    return result;
//                }
//            }
//        }
//        return result;
    }

    private boolean isPositive(int dividend, int divisor) {
        return (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
    }
}
