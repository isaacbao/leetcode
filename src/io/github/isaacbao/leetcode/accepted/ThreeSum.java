package io.github.isaacbao.leetcode.accepted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rongyang_lu on 2017/11/7.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int firstIndex = 0; firstIndex < length - 2; firstIndex++) {
            int first = nums[firstIndex];
            int secondIndex = firstIndex + 1;
            int thirdIndex = length - 1;
            while (secondIndex < thirdIndex) {
                int second = nums[secondIndex];
                int third = nums[thirdIndex];
                if (-first < second + third) {
                    thirdIndex--;
                } else if (-first > second + third) {
                    secondIndex++;
                } else {
                    result.add(getCapableGroup(first, second, third));
                    while (secondIndex < thirdIndex && second == nums[secondIndex + 1]) {
                        secondIndex++;
                    }
                    if (first == second) {
                        firstIndex = secondIndex;
                    }
                    while (secondIndex < thirdIndex && third == nums[thirdIndex - 1]) {
                        thirdIndex--;
                    }
                    secondIndex++;
                    thirdIndex--;
                }
                while (firstIndex < length - 1 && first == nums[firstIndex + 1]) {
                    firstIndex++;
                }
            }
        }
        return result;
    }

    private List<Integer> getCapableGroup(int first, int second, int thrid) {
        List<Integer> result = new ArrayList<>();
        result.add(first);
        result.add(second);
        result.add(thrid);
        return result;
    }
}
