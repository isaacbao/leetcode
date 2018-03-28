package io.github.isaacbao.leetcode.accepted;

import java.util.ArrayList;
import java.util.List;

public class RemoveNthFromEnd {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode currentNode = head;
        List<ListNode> nodes = new ArrayList<>();
        nodes.add(currentNode);
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            nodes.add(currentNode);
        }
        if(n==nodes.size()){
            return  head.next;
        }
        ListNode removedNode = nodes.get(nodes.size() - n);
        ListNode nodeBeforeRemovedNode = nodes.get(nodes.size() - n - 1);
        nodeBeforeRemovedNode.next = removedNode.next;
        return head;
    }

}

