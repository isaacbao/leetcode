package io.github.isaacbao.leetcode.accepted;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rongyang_lu on 2017/11/29.
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        BuildingParenthesis buildingParenthesis = new BuildingParenthesis(n);
        findLegalParenthesis(buildingParenthesis, result, n * 2);

        return result;
    }

    private void findLegalParenthesis(BuildingParenthesis buildingParenthesis, List<String> result, int n) {
        if (buildingParenthesis.isAllLeftBracketSetted()) {
            buildingParenthesis.appendAllRightBracket();
            result.add(buildingParenthesis.legalParenthesis.toString());
            return;
        }
        BuildingParenthesis addLeft = new BuildingParenthesis(buildingParenthesis);
        addLeft.appendLeftBracket();
        findLegalParenthesis(addLeft, result, n);
        if (buildingParenthesis.leftBracketAmount > buildingParenthesis.rightBracketAmount) {
            BuildingParenthesis addRight = new BuildingParenthesis(buildingParenthesis);
            addRight.appendRightBracket();
            findLegalParenthesis(addRight, result, n);
        }

    }


    class BuildingParenthesis {
        int leftBracketAmount;
        int rightBracketAmount;
        int maxParenthisisAmount;
        StringBuilder legalParenthesis;

        public BuildingParenthesis(int maxParenthisisAmount) {
            this.leftBracketAmount = 0;
            this.legalParenthesis = new StringBuilder();
            this.maxParenthisisAmount = maxParenthisisAmount;
            this.rightBracketAmount = 0;
        }

        public BuildingParenthesis(BuildingParenthesis buildingParenthesis) {
            this.leftBracketAmount = buildingParenthesis.leftBracketAmount;
            this.legalParenthesis = new StringBuilder(buildingParenthesis.legalParenthesis);
            this.maxParenthisisAmount = buildingParenthesis.maxParenthisisAmount;
            this.rightBracketAmount = buildingParenthesis.rightBracketAmount;
        }

        public boolean isAllLeftBracketSetted() {
            return this.leftBracketAmount == this.maxParenthisisAmount;
        }

        public void appendAllRightBracket() {
            while (this.rightBracketAmount < maxParenthisisAmount) {
                this.legalParenthesis.append(")");
                this.rightBracketAmount++;
            }
        }

        public void appendLeftBracket() {
            this.legalParenthesis.append("(");
            this.leftBracketAmount++;
        }

        public void appendRightBracket() {
            this.legalParenthesis.append(")");
            this.rightBracketAmount++;
        }
    }

}
