package io.github.isaacbao.leetcode.accepted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rongyang_lu on 2017/12/18.
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int candidatedLength = candidates.length;
        if (candidatedLength == 0) {
            return result;
        }
        Arrays.sort(candidates);
        for (int i = 0; i < candidatedLength; i++) {
            List<Integer> buildingCombination = new ArrayList<>();
            findValidCombination(buildingCombination, candidates, i, target, result);
        }

        return result;
    }

    private void findValidCombination(List<Integer> buildingCombination, int[] candidates, int index, int target, List<List<Integer>> result) {
        List<Integer> combination = new ArrayList<>(buildingCombination);
        while (index < candidates.length-1 && candidates[index] == candidates[index + 1]) {
            int valueOfIndex = candidates[index];
            target -= valueOfIndex;
            combination.add(valueOfIndex);
            index++;
        }
        int valueOfIndex = candidates[index];
        target -= valueOfIndex;
        if (target < 0) {
            return;
        }
        combination.add(valueOfIndex);
        if (target == 0) {
            result.add(combination);
            return;
        }
        for (int i = index + 1; i < candidates.length; i++) {
            findValidCombination(combination, candidates, i, target, result);
        }
    }
}
