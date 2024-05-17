package leetcode1_100;

import auxiliary.ListNode;

/**
 * @author yuxiang_chu
 * @since 2024/5/13 16:38
 */
public class LeetCode2 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        solution.addTwoNumbers(l1, l2);
    }


    static class Solution {

        /**
         * 耗时 100
         * 内存 32.7
         */
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = null;
            ListNode tail = null;
            int carry = 0;
            while (l1 != null || l2 != null) {
                int a = l1 != null ? l1.val : 0;
                int b = l2 != null ? l2.val : 0;
                if (head == null) {
                    head = tail = new ListNode((a + b + carry)%10);
                }else {
                    tail = tail.next = new ListNode((a + b + carry)%10);
                }
                carry = (a + b + carry)/10;
                l1 = l1 != null ? l1.next : null;
                l2 = l2 != null ? l2.next : null;
            }
            if (carry == 1) {
                tail.next = new ListNode(1);
            }
            return head;
        }

    }
}
