package io.github.isaacbao.leetcode.accepted;

/**
 * Created by rongyang_lu on 2017/10/12.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (isEmptyNode(l1) && isEmptyNode(l2)) {
            return new ListNode(0);
        }
        ListNode result = new ListNode(0);
        ListNode currentNode = result;
        while (true) {
            currentNode.val = l1.val + l2.val + currentNode.val;
            if (currentNode.val >= 10) {
                currentNode.val = currentNode.val % 10;
                currentNode.next = new ListNode(1);
            }else {
                currentNode.next = new ListNode(0);
            }
            l1 = l1.next;
            l2 = l2.next;
            if(isEmptyNode(l1) || isEmptyNode(l2)) {
                if(currentNode.next.val == 0) {
                    currentNode.next = null;
                }
                break;
            }
            currentNode = currentNode.next;

        }
        if (isEmptyNode(l1)) {
            addCarry(l2, currentNode);
        }
        if (isEmptyNode(l2)) {
            addCarry(l1, currentNode);
        }
        return result;
    }

    private static void addCarry(ListNode node, ListNode currentNode) {
        if (null == node) {
            return;
        }
        while (null != currentNode.next) {
            currentNode = currentNode.next;
            currentNode.val = currentNode.val + node.val;
            if (currentNode.val >= 10) {
                currentNode.val = currentNode.val % 10;
                currentNode.next = new ListNode(1);
            }
            node = node.next;
            if(null == node){
                return;
            }
        }
        currentNode.next = node;
    }

    private static boolean isEmptyNode(ListNode node) {
        return null == node;
    }
}
