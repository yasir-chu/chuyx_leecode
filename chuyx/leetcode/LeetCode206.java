package leetcode;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 *
 *
 *  示例 1：
 *
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 *
 *  示例 2：
 *
 * 输入：head = [1,2]
 * 输出：[2,1]
 *
 *  示例 3：
 *
 * 输入：head = []
 * 输出：[]
 *
 *
 *  提示：
 *
 *  链表中节点的数目范围是 [0, 5000]
 *  -5000 <= Node.val <= 5000
 *
 *
 *  进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 *
 *
 *  Related Topics 递归 链表 👍 2253 👎 0
 * @author yuxiang.chu
 * @date 2022/2/7 16:24
 **/
public class LeetCode206 {

    public static void main(String[] args) {
        Solution solution = new LeetCode206.Solution();
        ListNode listNode = new ListNode(2, new ListNode(3, new ListNode(4)));
        ListNode listNode1 = solution.reverseList(listNode);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class Solution {

        // 递归
        public ListNode reverseList(ListNode head) {
            if (head==null || head.next == null){
                return head;
            }
            ListNode listNode = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return listNode;
        }

        // 双指针
        public ListNode reverseList2(ListNode head) {
            ListNode cur = null,pre = head;
            while (pre != null){
                ListNode item = pre.next;
                pre.next = cur;
                cur = pre;
                pre = item;
            }
            return cur;

        }

    }
}
