package io.github.isaacbao.leetcode.accepted;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/1/29.
 */
public class Rotate {
    public void rotate(int[][] matrix) {
        int maxEdgeLength = matrix.length;
        int maxCircuit = maxEdgeLength / 2;
        int currentCircuitEdgeLength = maxEdgeLength;
        for (int currentCircuit = 0; currentCircuit < maxCircuit; currentCircuit++) {
            for (int i = 0; i < currentCircuitEdgeLength - 1; i++) {
                int[] currentPoint = {currentCircuit, currentCircuit + i};
                int valueCache = matrix[currentPoint[0]][currentPoint[1]];
                for (int edge = 0; edge < 4; edge++) {
                    int[] targetPoint = getTargetPoint(currentPoint[0], currentPoint[1], maxEdgeLength);
                    int temp = matrix[targetPoint[0]][targetPoint[1]];
                    matrix[targetPoint[0]][targetPoint[1]] = valueCache;
                    valueCache = temp;
                    currentPoint = targetPoint;
                }
            }
            System.out.println("=====");
            for (int[] in : matrix) {
                System.out.println(Arrays.toString(in));
            }
            currentCircuitEdgeLength -= 2;
        }
    }

    public int[] getTargetPoint(int x, int y, int maxEdgeLength) {
        int targetX = 0;
        int targetY = 0;
        while (isInOuterRing(x, y, maxEdgeLength)) {
            int[] preResult = getTargetPoint(x - 1, y - 1, maxEdgeLength - 2);
            preResult[0]++;
            preResult[1]++;
            return preResult;
        }
        if (isInUpLine(x)) {
            targetY = maxEdgeLength - 1;
            targetX = y;
            return new int[]{targetX, targetY};
        }
        if (isInDownLine(x, maxEdgeLength)) {
            targetY = 0;
            targetX = y;
            return new int[]{targetX, targetY};
        }
        if (isInLeftLine(y)) {
            targetY = maxEdgeLength - 1 - x;
            targetX = 0;
            return new int[]{targetX, targetY};
        }
        if (isInRightLine(y, maxEdgeLength)) {
            targetY = maxEdgeLength - 1 - x;
            targetX = maxEdgeLength - 1;
            return new int[]{targetX, targetY};
        }

        return new int[]{targetX, targetY};
    }

    private boolean isInOuterRing(int x, int y, int maxEdgeLength) {
        return x != 0 && x != (maxEdgeLength - 1) && y != (maxEdgeLength - 1) && y != 0;
    }

    private boolean isInLeftLine(int y) {
        return y == 0;
    }

    private boolean isInRightLine(int y, int maxEdgeLength) {
        return y == (maxEdgeLength - 1);
    }

    private boolean isInDownLine(int x, int maxEdgeLength) {
        return x == (maxEdgeLength - 1);
    }

    private boolean isInUpLine(int x) {
        return x == 0;
    }

}
