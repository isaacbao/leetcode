package io.github.isaacbao.leetcode.accepted;

/**
 * Created by rongyang_lu on 2017/12/11.
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums.length==0){
            return -1;
        }
        if (target >= nums[0]) {
            for (int i = 0; i < nums.length; i++) {
                int current = nums[i];
                if (target == current) {
                    return i;
                }
                if (i < nums.length - 1 && current > nums[i + 1]) {
                    return -1;
                }
            }
        }
        if (target <= nums[nums.length-1]) {
            for (int i = nums.length-1; i > -1; i--) {
                int current = nums[i];
                if (target == current) {
                    return i;
                }
                if (i > 0 && current < nums[i - 1]) {
                    return -1;
                }
            }
        }
        return -1;
    }
}
