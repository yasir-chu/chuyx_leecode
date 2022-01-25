package leecode;

/**
 * @author yuxiang.chu
 * @date 2022/1/25 9:23
 **/
public class LeetCode83 {

    public static void main(String[] args) {
        Solution solution = new LeetCode83().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
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
