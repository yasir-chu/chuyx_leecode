package leecode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表
 *
 *  示例 1：
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 *  示例 2：
 *
 * 输入：l1 = [], l2 = []
 * 输出：[]
 *
 *  示例 3：
 *
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *
 *
 *  提示：
 *
 *  两个链表的节点数目范围是 [0, 50]
 *  -100 <= Node.val <= 100
 *  l1 和 l2 均按 非递减顺序 排列
 *
 *  Related Topics 递归 链表 👍 2191 👎 0
 * @author yuxiang.chu
 * @date 2022/2/17 14:41
 **/
public class LeetCode21 {

    public static void main(String[] args) {
        Solution solution = new LeetCode21().new Solution();
    }


    public class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null || list2 == null) {
                return list1 == null ? list2 : list1;
            }
            ListNode node = new ListNode(0);
            ListNode p = node;
            while (list1 != null && list2 != null) {
                if (list1.val > list2.val) {
                    p.next = list2;
                    list2 = list2.next;
                } else {
                    p.next = list1;
                    list1 = list1.next;
                }
                p = p.next;
            }
            if (list1 != null) {
                p.next = list1;
            } else {
                p.next = list2;
            }

            return node.next;
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
