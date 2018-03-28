package io.github.isaacbao.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rongyang_lu on 2017/12/27.
 */
public class Permute2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        boolean[] isVisited = new boolean[length];
        for (int i = 0; i < length; i++) {
            boolean[] isVisitedMarks = isVisited.clone();
            if (i > 0 && nums[i - 1] == nums[i] && !isVisitedMarks[i - 1]) {
                continue;
            }
            List<Integer> possiblePermute = new ArrayList<>();
            possiblePermute.add(nums[i]);
            isVisitedMarks[i] = true;
            findPossiblePermute(possiblePermute, nums, result, isVisitedMarks);
        }
        return result;
    }

    private void findPossiblePermute(List<Integer> buildingPermute, int[] nums, List<List<Integer>> result, boolean[]
            isVisited) {
        if (allVisited(isVisited)) {
            result.add(buildingPermute);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            boolean[] currentIsVisit = isVisited.clone();
            if (currentIsVisit[i]) {
                continue;
            }
            if (i > 0 && nums[i - 1] == nums[i] && !currentIsVisit[i - 1]) {
                continue;
            }
            currentIsVisit[i] = true;
            List<Integer> possiblePermute = new ArrayList<>(buildingPermute);
            possiblePermute.add(nums[i]);
            findPossiblePermute(possiblePermute, nums, result, currentIsVisit);
        }

    }

    private boolean allVisited(boolean[] isVisit) {
        for (boolean visited : isVisit) {
            if (!visited) {
                return false;
            }
        }
        return true;
    }
}
