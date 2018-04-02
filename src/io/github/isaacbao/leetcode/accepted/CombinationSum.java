package io.github.isaacbao.leetcode.accepted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rongyang_lu on 2017/12/14.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (0 == candidates.length) {
            return result;
        }
        Arrays.sort(candidates);
        getCombination(candidates, target, result, new ArrayList<>(), 0);

        return result;
    }

    private void getCombination(int[] candidates, int target, List<List<Integer>> result, List<Integer> combination,
                                int index) {
        for (int j = index; j < candidates.length; j++) {
            int candidate = candidates[j];
            int transitionalTarget = target - candidate;
            if (transitionalTarget < 0) {
                continue;
            }
            ArrayList<Integer> currentCombination = new ArrayList<>(combination);
            currentCombination.add(candidate);
            if (transitionalTarget > 0) {
                getCombination(candidates, target - candidate, result, currentCombination, j);
            }
            if (transitionalTarget == 0) {
                result.add(currentCombination);
            }
        }
    }
}
