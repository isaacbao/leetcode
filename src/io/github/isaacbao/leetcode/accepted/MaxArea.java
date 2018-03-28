package io.github.isaacbao.leetcode.accepted;

/**
 * Created by rongyang_lu on 2017/11/6.
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int w = right - left;
            int leftHeight = height[left];
            int rightHeight = height[right];
            int h;
            if (leftHeight < rightHeight) {
                h = leftHeight;
                left++;
            } else {
                h = rightHeight;
                right--;
            }
            int currentArea = h * w;
            maxArea = Math.max(maxArea, currentArea);
        }
        return maxArea;
    }
}
