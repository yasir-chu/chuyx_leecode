package leetcode;

import auxiliary.ListNode;

/**
 * @author yuxiang.chu
 * @date 2022/6/28 9:07
 **/
public class LeetCode328 {

    public static void main(String[] args) {
        LeetCode328.Solution solution = new LeetCode328.Solution();
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode listNode1 = solution.oddEvenList(listNode);
    }

    static class Solution {
        /**
         * 执行耗时:0 ms,击败了100.00% 的Java用户
         * 内存消耗:41.4 MB,击败了5.08% 的Java用户
         */
        public ListNode oddEvenList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode baseNode = head;
            ListNode evenBase = head.next, evenNode = head.next;
            while (evenNode != null) {
                if (evenNode.next == null) {
                    break;
                }
                baseNode = baseNode.next = evenNode.next;
                evenNode = evenNode.next = baseNode.next;
            }
            baseNode.next = evenBase;
            return head;
        }

    }
}
