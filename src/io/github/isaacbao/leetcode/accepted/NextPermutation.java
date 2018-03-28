package io.github.isaacbao.leetcode.accepted;

/**
 * Created by rongyang_lu on 2017/12/8.
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int anchor = nums.length - 2;
        printArray(nums);
        int indexSwapWithAnchor = -1;
        while (anchor > -1) {
            int numberToBeSwapped = nums[anchor];
            int leastNumLargerThanAnchor = Integer.MAX_VALUE;
            int cursor = nums.length - 1;
            while (cursor > anchor) {
                int numberInCurrentCursor = nums[cursor];
                if (numberToBeSwapped < numberInCurrentCursor) {
                    if (leastNumLargerThanAnchor > numberInCurrentCursor) {
                        leastNumLargerThanAnchor = numberInCurrentCursor;
                        indexSwapWithAnchor = cursor;
                    }
                }
                cursor--;
            }
            if (indexSwapWithAnchor > -1) {
                swap(nums, anchor, indexSwapWithAnchor);
                quickSort(nums, anchor + 1, nums.length - 1);
                break;
            }
            anchor--;
        }
        if (indexSwapWithAnchor < 0) {
            reverse(nums, 0, nums.length - 1);
        }
        printArray(nums);
    }

    private void printArray(int[] array) {
        for (int a : array) {
            System.out.print(a + ",");
        }
        System.out.println();
    }

    public int[] quickSort(int[] array, int left, int right) {
        if (left <= right) {
            int middleIndex = (left + right) / 2;
            int newMiddleIndex = partition(array, left, middleIndex, right);
            quickSort(array, left, newMiddleIndex - 1);
            quickSort(array, newMiddleIndex + 1, right);
        }
        return array;
    }

    public int partition(int[] array, int left, int anchor, int right) {
        int pivot = array[anchor];
        swap(array, anchor, right);
        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (array[i] <= pivot) {
                swap(array, i, storeIndex);
                storeIndex++;
            }
        }
        swap(array, storeIndex, right);
        return storeIndex;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * reverse the sort of elements in array between index i and j
     */
    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
