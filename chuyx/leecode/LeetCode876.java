package leecode;

/**
 * @author yuxiang.chu
 * @date 2022/6/27 19:52
 **/
public class LeetCode876 {

    public static void main(String[] args) {
        Solution solution = new LeetCode876().new Solution();
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode listNode1 = solution.middleNode(listNode);

    }


    class Solution {
        public ListNode middleNode(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode slow = head;
            ListNode fast = head.next.next;
            while(fast!= null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow.next;

        }
    }
}
