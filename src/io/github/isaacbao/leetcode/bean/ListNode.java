package io.github.isaacbao.leetcode.bean;

/**
 * Created by rongyang_lu on 2017/12/7.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public void printNode() {
        ListNode temp = this;
        while (null != temp) {
            System.out.print(temp.val + "→");
            temp = temp.next;
        }
        System.out.println();
    }
}
