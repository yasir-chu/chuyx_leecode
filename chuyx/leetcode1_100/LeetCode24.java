package leetcode1_100;

public class LeetCode24 {


    public static void main(String[] args) {
        ListNode node=new ListNode(1, new ListNode(2, new  ListNode(3, new ListNode(4))));
        ListNode listNode = swapPairs(node);

    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 	内存消耗:40.6 MB,击败了26.12% 的Java用户
     * @param head
     * @return
     */

    public static ListNode swapPairs(ListNode head) {
        /**
         * a-b-c-d
         * a.next != null
         * a.next = b.next
         * b.next = a
         * 判定head至少有两个元素
         */
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nodeTwo = head.next;
        head.next = nodeTwo.next;
        nodeTwo.next = head;
        head.next = swapPairs(head.next);
        return nodeTwo;
    }



    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
