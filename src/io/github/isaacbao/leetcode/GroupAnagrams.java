package io.github.isaacbao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/group-anagrams/description/
 * Created by Administrator on 2018/3/1.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        List<String> sortedStrings = new ArrayList<>();
        for (String str : strs) {
            sortedStrings.add(sortCharsInString(str));
        }
        List<String> groups = new ArrayList<>();
        for (int stringIndex = 0; stringIndex < sortedStrings.size(); stringIndex++) {
            String sortedString = sortedStrings.get(stringIndex);
            boolean isHitGroup = false;
            for (int i = 0; i < groups.size(); i++) {
                String group = groups.get(i);
                if (group.equals(sortedString)) {
                    result.get(i).add(strs[stringIndex]);
                    isHitGroup = true;
                }
            }
            if (!isHitGroup) {
                groups.add(sortedString);
                List<String> resultSet = new ArrayList<>();
                resultSet.add(strs[stringIndex]);
                result.add(resultSet);
            }
        }
        return result;
    }

    public String sortCharsInString(String str) {
        char[] charArray = str.toCharArray();
        quickSort(charArray, 0, charArray.length - 1);
        return new String(charArray);
    }

    private void quickSort(char[] charArray, int start, int end) {
        if (charArray.length <= 1 || start >= end || start < 0) {
            return;
        }
        int pivot = (start + end) / 2;
        pivot = partition(charArray, start, end, pivot);
        quickSort(charArray, 0, pivot - 1);
        quickSort(charArray, pivot + 1, end);
    }

    private int partition(char[] charArray, int start, int end, int pivot) {
        char charPivot = charArray[pivot];
        swap(charArray, pivot, end);
        int nextPivot = start;
        for (int i = start; i < end; i++) {
            char chari = charArray[i];
            if (chari <= charPivot) {
                swap(charArray, i, nextPivot);
                nextPivot++;
            }
        }
        swap(charArray, nextPivot, end);
        return nextPivot;
    }

    private void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }
}
