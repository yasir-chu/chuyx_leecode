package leecode;

import java.util.HashMap;
import java.util.List;

/**
 * 此题图解，进leecode官网看：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * @author yuxiang.chu
 * @date 2022/1/27 10:15
 **/
public class LeeCode160 {

    public static void main(String[] args) {
        Solution solution = new LeeCode160().new Solution();
        ListNode item = new ListNode(8, new ListNode(4, new ListNode(5)));
        ListNode listNode = new ListNode(4, new ListNode(1, item));
        ListNode listNode2 = new ListNode(5, new ListNode(6, new ListNode(1, item)));
        ListNode intersectionNode = solution.getIntersectionNode2(listNode, listNode2);
    }

//leetcode submit region begin(Prohibit modification and deletion)

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode a = headA;
            ListNode b = headB;
            while (a != null){
                while (b != null){
                    if (a == b){
                        return a;
                    }
                    b = b.next;
                }
                b = headB;
                a = a.next;
            }
            return null;
        }

        /**
         * 哈希表存取算法
         * @param headA
         * @param headB
         * @return
         */
        public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
            if (headA == null ||headB == null){
                return null;
            }
            HashMap<ListNode, Integer> listNodeHashMap = new HashMap<ListNode, Integer>();
            ListNode a = headA;
            ListNode b = headB;
            while (a != null){
                listNodeHashMap.put(a, 1);
                a = a.next;
            }
            while (b != null){
                if (listNodeHashMap.containsKey(b)){
                    return b;
                }
                listNodeHashMap.put(b, 1);
                b = b.next;
            }
            return null;
        }


        /**
         * 双指针
         * @param headA
         * @param headB
         * @return
         */
        public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
            if (headA == null ||headB == null){
                return null;
            }
            ListNode a = headA;
            ListNode b = headB;
            while (a != b){
                a = a == null ? headB : a.next;
                b = b == null ? headA : b.next;
            }
            return a;
        }
    }
}
