package io.github.isaacbao.leetcode.accepted;

import java.util.Arrays;

/**
 * Created by rongyang_lu on 2017/11/10.
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int result = 0;
        int minDistance = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int length = nums.length;
        int leftIndex = 0;
        while (leftIndex < nums.length) {
            int middleIndex = leftIndex + 1;
            int rightIndex = length - 1;
            int left = nums[leftIndex];
            int sum;
            while (middleIndex < rightIndex) {
                int middle = nums[middleIndex];
                int right = nums[rightIndex];
                sum = left + middle + right;
                int currentDistance = Math.abs(sum - target);
                if (currentDistance == 0) {
                    return sum;
                }
                if (currentDistance < minDistance) {
                    minDistance = currentDistance;
                    result = sum;
                }
                if(sum-target<0) {
                    middleIndex++;
                }else{
                    rightIndex--;
                }
            }
            leftIndex++;
        }
        return result;
    }
}
