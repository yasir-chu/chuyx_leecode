package leetcode1_100;

import auxiliary.ListNode;

/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的
 *  返回同样按升序排列的结果链表。
 *
 *  示例 1：
 *
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 *
 *  示例 2：
 *
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 *
 *
 *  提示：
 *
 *  链表中节点数目在范围 [0, 300] 内
 *  -100 <= Node.val <= 100
 *  题目数据保证链表已经按升序排列
 *
 *  Related Topics 链表 👍 718 👎 0
 * @author yuxiang.chu
 * @date 2022/1/25 9:23
 **/
public class LeetCode83 {

    public static void main(String[] args) {
        Solution solution = new LeetCode83.Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode item = head;
            while (item.next != null){
                if (item.val == item.next.val){
                    item.next = item.next.next;
                    continue;
                }
                item = item.next;
            }
            return head;
        }
    }
}
