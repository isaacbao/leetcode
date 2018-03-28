package io.github.isaacbao.leetcode.accepted;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by rongyang_lu on 2017/11/27.
 */
public class FourSumAnother {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        List<Integer> arrayAplusB = plusTwoArray(A, B);
        List<Integer> arrayCplusD = plusTwoArray(C, D);
        arrayAplusB.sort(Comparator.naturalOrder());
        arrayCplusD.sort(Comparator.naturalOrder());
        int i = 0;
        int j = arrayCplusD.size() - 1;
        while (i < arrayAplusB.size() && j > -1) {

            int ab = arrayAplusB.get(i);
            int cd = arrayCplusD.get(j);
            int sum = ab + cd;
            if (sum == 0) {
                int countAB = 1;
                int countCD = 1;
                while (i < arrayAplusB.size() - 1) {
                    Integer abPlus1 = arrayAplusB.get(i + 1);
                    if (abPlus1.equals(ab)) {
                        countAB++;
                        i++;
                        ab = arrayAplusB.get(i);
                    } else {
                        break;
                    }
                }
                while (j > 0) {
                    Integer cdSub1 = arrayCplusD.get(j - 1);
                    if (cdSub1.equals(cd)) {
                        countCD++;
                        j--;
                        cd = arrayCplusD.get(j);
                    } else {
                        break;
                    }
                }
                count += (countAB * countCD);
            }
            if (sum < 0) {
                i++;
            } else {
                j--;
            }
        }

        return count;
    }

    private List<Integer> plusTwoArray(int[] A, int[] B) {
        List<Integer> arrayAplusB = new ArrayList<>();
        for (int aIndex = 0; aIndex < A.length; aIndex++) {
            int a = A[aIndex];
            for (int bIndex = 0; bIndex < B.length; bIndex++) {
                int b = B[bIndex];
                arrayAplusB.add(a + b);
            }
        }
        return arrayAplusB;
    }

}
