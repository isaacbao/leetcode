package io.github.isaacbao.leetcode.accepted;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rongyang_lu on 2017/12/27.
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }
        int length = numsList.size();
        for (int i = 0; i < length; i++) {
            List<Integer> cloneNums = new ArrayList<>(numsList);
            List<Integer> possiblePermute = new ArrayList<>();
            possiblePermute.add(cloneNums.remove(i));
            findPossiblePermute(possiblePermute, cloneNums, result);
        }
        return result;
    }

    private void findPossiblePermute(List<Integer> buildingPermute, List<Integer> nums, List<List<Integer>> result) {
        int length = nums.size();
        if (nums.size() == 0) {
            result.add(buildingPermute);
            return;
        }
        for (int i = 0; i < length; i++) {
            List<Integer> cloneNums = new ArrayList<>(nums);
            List<Integer> possiblePermute = new ArrayList<>(buildingPermute);
            possiblePermute.add(cloneNums.remove(i));
            if (cloneNums.size() == 0) {
                result.add(possiblePermute);
                return;
            }
            findPossiblePermute(possiblePermute, cloneNums, result);
        }
    }
}
