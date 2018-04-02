package io.github.isaacbao.leetcode;

/**
 * https://leetcode.com/problems/powx-n/description/
 * Created by Administrator on 2018/3/29.
 */
public class Pow {
    public double myPow(double x, int n) {
        if (1 == n) {
            return x;
        }
        if (0 == n) {
            return 1;
        }
        if( n == Integer.MIN_VALUE ) {
            ++n;
            n = -n;
            x = 1/x;
            return x * x * myPow( x * x, n / 2 );
        }
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        if ((n % 2) == 1) {
            return myPow(x * x, n / 2) * x;
        } else {
            return myPow(x * x, n / 2);
        }
    }
}
