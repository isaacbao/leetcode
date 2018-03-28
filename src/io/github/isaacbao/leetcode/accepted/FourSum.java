package io.github.isaacbao.leetcode.accepted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rongyang_lu on 2017/11/22.
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = 4;
        int numsLength = nums.length;
        if (numsLength < n) {
            return result;
        }
        Arrays.sort(nums);

        for (int i = 0; i < numsLength - (n - 1); i++) {
            int numOfCurrentIndex = nums[i];
            int targetOfNSum = target - numOfCurrentIndex;
            int[] subArray = Arrays.copyOfRange(nums, i + 1, numsLength);

            List<List<Integer>> threeSumGroups = nSum(subArray, targetOfNSum, 3);
            result.addAll(getNSumGroups(numOfCurrentIndex, threeSumGroups));
            while (i < numsLength - 1 && numOfCurrentIndex == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }

    public List<List<Integer>> nSum(int[] nums, int target, int n) {
        int numsLength = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (numsLength < n) {
            return result;
        }

        for (int i = 0; i < numsLength - (n - 1); i++) {
            int numOfCurrentIndex = nums[i];
            int targetOfNSubOneSum = target - numOfCurrentIndex;
            int[] subArray = Arrays.copyOfRange(nums, i + 1, numsLength);

            List<List<Integer>> nSumGroups;
            if (n == 3) {
                nSumGroups = twoSum(subArray, targetOfNSubOneSum);
            } else {
                nSumGroups = nSum(subArray, targetOfNSubOneSum, n - 1);
            }
            result.addAll(getNSumGroups(numOfCurrentIndex, nSumGroups));
            while (i < numsLength - 1 && numOfCurrentIndex == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }

    private List<List<Integer>> twoSum(int[] subArray, int targetOfTwoSum) {
        List<List<Integer>> twoSumGroups = new ArrayList<>();
        int headIndex = 0;
        int tailIndex = subArray.length - 1;
        while (headIndex < tailIndex) {
            int head = subArray[headIndex];
            int tail = subArray[tailIndex];
            if (targetOfTwoSum < head + tail) {
                tailIndex--;
            } else if (targetOfTwoSum > head + tail) {
                headIndex++;
            } else {
                twoSumGroups.add(getTwoSumGroup(head, tail));
                while (headIndex < tailIndex && head == subArray[headIndex + 1]) {
                    headIndex++;
                }
                while (headIndex < tailIndex && tail == subArray[tailIndex - 1]) {
                    tailIndex--;
                }
                headIndex++;
                tailIndex--;
            }
        }
        return twoSumGroups;
    }

    private List<List<Integer>> getNSumGroups(int a, List<List<Integer>> nSubOneSumGroups) {
        nSubOneSumGroups.forEach(nSumOneSumGroup -> nSumOneSumGroup.add(a));
        return nSubOneSumGroups;
    }

    private List<Integer> getTwoSumGroup(int a, int b) {
        List<Integer> result = new ArrayList<>();
        result.add(a);
        result.add(b);
        return result;
    }
}
