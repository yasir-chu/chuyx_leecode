package leecode;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 *  请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *  示例 1：
 *  输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 *
 *  示例 2：
 *  输入：lists = []
 * 输出：[]
 *
 *  示例 3：
 *  输入：lists = [[]]
 * 输出：[]
 *
 *
 *  提示：
 *
 *  k == lists.length
 *  0 <= k <= 10^4
 *  0 <= lists[i].length <= 500
 *  -10^4 <= lists[i][j] <= 10^4
 *  lists[i] 按 升序 排列
 *  lists[i].length 的总和不超过 10^4
 *
 *  Related Topics 链表 分治 堆（优先队列） 归并排序 👍 1749 👎 0
 * @author yuxiang.chu
 * @date 2022/2/17 14:28
 **/
public class LeeCode23 {

    public static void main(String[] args) {
        Solution solution = new LeeCode23().new Solution();
        ListNode listNode = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNode3 = new ListNode(2, new ListNode(6));
        ListNode[] arr = {listNode, listNode2, listNode3};
        ListNode listNode1 = solution.mergeKLists3(arr);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        /**
         * 两两合并+遍历
         * @param lists
         * @return
         */
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0){
                return null;
            }
            ListNode result = lists[0];
            for (int i = 1; i < lists.length; i++) {
                result = mergeTwoLists(result, lists[i]);
            }
            return result;
        }

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



        public ListNode mergeKLists2(ListNode[] lists) {
            if (lists.length == 0){
                return null;
            }
            ListNode node = new ListNode(0);
            ListNode p = node;

            while (true){
                int[] sortArr = new int[lists.length];
                for (int i = 0; i < lists.length; i++) {
                    if (lists[i] != null){
                        sortArr[i] = lists[i].val;
                    }else{
                        sortArr[i] = Integer.MAX_VALUE;
                    }
                }
                int n = sortArrIndex(sortArr);
                if (n == -1){
                    break;
                }
                p.next = lists[n];
                lists[n] = lists[n].next;

                p = p.next;
            }
            return node.next;
        }

        /**
         * 找到数组中最小值的下表
         *
         * @param sortArr
         * @return
         */
        private int sortArrIndex(int[] sortArr) {
            if (sortArr.length == 0){
                return -1;
            }
            int min = Integer.MAX_VALUE;
            int size = 0;
            int index = 0;
            for (int i = 0; i < sortArr.length; i++) {
                if (sortArr[i] < min){
                    index = i;
                    min = sortArr[i];
                }
                if (sortArr[i] == Integer.MAX_VALUE){
                    size ++ ;
                }
            }
            if (size == sortArr.length){
                return -1;
            }
            return index;
        }

        /**
         * 分治
         * @param lists
         * @return
         */
        public ListNode mergeKLists3(ListNode[] lists) {
            return merge(lists,0, lists.length-1);
        }

        public ListNode merge(ListNode[] node, int l, int r){
            if (r == l){
                return node[l];
            }
            if (l > r){
                return null;
            }
            int mid = l  + (r - l - 1)/2;
            return mergeTwoLists(merge(node, l, mid), merge(node, mid + 1, r));
        }
    }
}
