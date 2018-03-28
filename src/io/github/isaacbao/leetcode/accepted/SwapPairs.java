package io.github.isaacbao.leetcode.accepted;

import io.github.isaacbao.leetcode.bean.ListNode;

/**
 * Created by rongyang_lu on 2017/12/7.
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode second = head.next;
        head.next = second.next;
        second.next = head;
        head = second;

        if (null == head.next.next || null == head.next.next.next) {
            return head;
        }

        ListNode one = head.next;
        ListNode two = one.next;
        ListNode three = two.next;

        while (true) {
            two.next = three.next;
            three.next = two;
            one.next = three;
//            head.printNode();
            if (null == two.next || null == two.next.next) {
                break;
            }
            three = two.next.next;
            one = two;
            two = two.next;
        }

        return head;
    }

}
