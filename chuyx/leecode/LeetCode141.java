package leecode;

/**
 * @author yuxiang_chu
 * @date 2023/4/20 14:49
 */
public class LeetCode141 {

    public static void main(String[] args) {
        Solution solution = new LeetCode141().new Solution();

    }

    public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }
            ListNode slow = head;
            ListNode quit = head.next;
            while (quit != null && quit != slow) {
                slow = slow.next;
                if (quit.next == null) {
                    return false;
                }
                quit = quit.next.next;
            }
            return quit == slow;
        }
    }


    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
