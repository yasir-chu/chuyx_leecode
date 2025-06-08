package leetcode1_100;

public class LeetCode19 {


    public static void main(String[] args) {
        LeetCode19.ListNode node=new LeetCode19.ListNode(1, new LeetCode19.ListNode(2, new LeetCode19.ListNode(3, new LeetCode19.ListNode(4, new LeetCode19.ListNode(5)))));
        LeetCode19.ListNode node1=new LeetCode19.ListNode(1, new LeetCode19.ListNode(2));
        LeetCode19.ListNode listNode = removeNthFromEnd(node, 5);
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 	内存消耗:41.2 MB,击败了5.40% 的Java用户
     */

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        ListNode quik = head;
        int slowSize = 0;
        while (quik.next != null) {
            quik = quik.next;
            slowSize++;
            if (slowSize >= n){
                slow = slow.next;
            }
        }
        slow.next = slow.next.next;
        return dummy.next;

    }

    /**
     *
     * 删除正数
     * if (n == 1) {
     *             return head.next;
     *         }
     *         ListNode res = head;
     *         for (int i = 2; i < n; i++) {
     *             res = res.next;
     *         }
     *         res.next = res.next.next;
     *         return head;
     */


    public  static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
