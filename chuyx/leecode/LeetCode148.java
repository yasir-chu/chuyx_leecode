package leecode;

/**
 * @author yuxiang.chu
 * @date 2022/6/30 10:53
 **/
public class LeetCode148 {

    public static void main(String[] args) {
        Solution solution = new LeetCode148().new Solution();
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        solution.sortList(l1);
    }


    class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode fast = head.next, slow = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode tmp = slow.next;
            slow.next = null;
            ListNode left = sortList(head);
            ListNode right = sortList(tmp);
            ListNode h = new ListNode(0);
            ListNode res = h;
            while (left != null && right != null) {
                if (left.val < right.val) {
                    h.next = left;
                    left = left.next;
                } else {
                    h.next = right;
                    right = right.next;
                }
                h = h.next;
            }
            h.next = left != null ? left : right;
            return res.next;
        }
    }
}
