package io.github.isaacbao.leetcode.accepted;

/**
 * Created by rongyang_lu on 2017/12/12.
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return new int[]{-1, -1};
        }
        int leftBoundary;
        int rightBoundary;
        int left = 0;
        int right = length - 1;
        int flag = binarySearch(nums, left, right, target);
        int middle = (left + right) / 2;
        while (flag != 0) {
            if (flag == -1) {
                left = middle;
                flag = binarySearch(nums, left, right, target);
                middle = (left + 1 + right) / 2;
            } else if (flag == 1) {
                right = middle;
                flag = binarySearch(nums, left, right, target);
                middle = (left + right - 1) / 2;
            }
//            middle = (left + right) / 2;
            if (left >= right) {
                break;
            }
        }
        if (flag != 0) {
            return new int[]{-1, -1};
        }
        leftBoundary = (left + right - 1) / 2;
        leftBoundary = findLeftBoundary(nums, left, leftBoundary, target);
        rightBoundary = (left + 1 + right) / 2;
        rightBoundary = findRightBoundary(nums, rightBoundary, right, target);
        if (leftBoundary > 0 && nums[leftBoundary - 1] == target) {
            leftBoundary--;
        }
        if (nums[leftBoundary] != target) {
            leftBoundary++;
        }
        if (nums[rightBoundary] != target) {
            rightBoundary--;
        }
        if (rightBoundary + 1 < length && nums[rightBoundary + 1] == target) {
            rightBoundary++;
        }
        return new int[]{leftBoundary, rightBoundary};
    }

    private int findRightBoundary(int[] nums, int rightBoundary, int right, int target) {
        int flag = binarySearch(nums, rightBoundary, right, target);
        int middle = (rightBoundary + right) / 2;
        while (rightBoundary != middle) {
            if (flag == 1) {
                right = middle;
            } else {
                rightBoundary = middle;
            }
            flag = binarySearch(nums, rightBoundary, right, target);
            middle = (rightBoundary + right) / 2;
        }
        if (flag == 0) {
            rightBoundary = middle;
        }
        return rightBoundary;
    }

    private int findLeftBoundary(int[] nums, int left, int leftBoundary, int target) {
        int flag = binarySearch(nums, left, leftBoundary, target);
        int middle = (left + leftBoundary) / 2;
        while (left != middle) {
            if (flag == -1) {
                left = middle;
            } else {
                leftBoundary = middle;
            }
            flag = binarySearch(nums, left, leftBoundary, target);
            middle = (left + leftBoundary) / 2;
        }
        if (flag == 0) {
            leftBoundary = middle;
        }
        return leftBoundary;
    }

    public int binarySearch(int[] nums, int left, int right, int target) {
        int middle = (left + right) / 2;
        int middleValue = nums[middle];
        if (middleValue < target) {
            return -1;
        }
        if (target < middleValue) {
            return 1;
        }
        return 0;
    }
}
