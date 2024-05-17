package leetcode;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val
 *
 *  示例 1：
 *
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 *
 *  示例 2：
 *
 * 输入：head = [], val = 1
 * 输出：[]
 *
 *  示例 3：
 *
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 *
 *
 *  提示：
 *
 *  列表中的节点数目在范围 [0, 10⁴] 内
 *  1 <= Node.val <= 50
 *  0 <= val <= 50
 *
 *  Related Topics 递归 链表 👍 788 👎 0
 * @author yuxiang.chu
 * @date 2022/1/27 13:37
 **/
public class LeetCode203 {

    public static void main(String[] args) {
        Solution solution = new LeetCode203.Solution();
        ListNode listNode = new ListNode(7, new ListNode(7, new ListNode(7, new ListNode(7, null))));
        ListNode listNode1 = solution.removeElements2(listNode, 7);
    }
    static class Solution {
        // 循环
        public ListNode removeElements(ListNode head, int val) {
            if (head == null){
                return null;
            }
            ListNode item = head;
            while (item.next != null){
                if (item.next.val == val){
                    item.next = item.next.next;
                    continue;
                }
                item = item.next;
            }
            if (head.val == val){
                return  head.next;
            }
            return head;
        }

        // 递归
        public ListNode removeElements2(ListNode head, int val) {
            if (head == null){
                return null;
            }
            head.next = removeElements2(head.next, val);
            return head.val == val ? null : head.next;
        }

    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
