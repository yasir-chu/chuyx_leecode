package leecode;

import java.util.*;

/**
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * <p>
 * L0 → L1 → … → Ln - 1 → Ln
 * <p>
 * 请将其重新排列后变为：
 * <p>
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[1,4,2,3]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5]
 * 输出：[1,5,2,4,3]
 * <p>
 * 提示：
 * <p>
 * 链表的长度范围为 [1, 5 * 10⁴]
 * 1 <= node.val <= 1000
 * <p>
 * Related Topics 栈 递归 链表 双指针 👍 785 👎 0
 *
 * @author yuxiang.chu
 * @date 2022/2/9 11:24
 **/
public class LeetCode143 {

    public static void main(String[] args) {
        Solution solution = new LeetCode143().new Solution();
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(7, new ListNode(6, new ListNode(5, new ListNode(4,new ListNode(7,new ListNode(6))))))))));
        solution.reorderList3(listNode);
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        /**
         * 自我解法
         *
         * @param head
         */
        public void reorderList(ListNode head) {
            if (head == null || head.next == null) {
                return;
            }
            ListNode item = head;
            Queue<ListNode> queue = new LinkedList<>();
            Stack quickStack = new Stack();
            // small开始
            boolean flag = true;
            // 慢
            ListNode smallNode = head;
            ListNode quickNode = head.next;
            // 找到中间节点
            while (quickNode != null && quickNode.next != null) {
                smallNode = smallNode.next;
                queue.add(smallNode);
                quickNode = quickNode.next.next;
            }
            while (smallNode != null) {
                quickStack.add(smallNode);
                smallNode = smallNode.next;
            }
            ListNode result = head;
            while (!queue.isEmpty() && !quickStack.empty() && result != null) {
                if (flag) {
                    result.next = (ListNode) quickStack.pop();
                } else {
                    result.next = queue.poll();
                }
                flag = !flag;
                result = result.next;
            }
            result.next = queue.isEmpty() ? (ListNode) quickStack.pop() : queue.poll();
            result = result.next;
            result.next = null;
        }

        /**
         * 通过线性表通过下表重建链表
         *
         * @param head
         */
        public void reorderList2(ListNode head) {
            if (head == null || head.next == null) {
                return;
            }
            List<ListNode> list = new ArrayList<>();
            ListNode node = head;
            while (node != null) {
                list.add(node);
                node = node.next;
            }
            int i = 0, j = list.size() - 1;
            while (i < j) {
                list.get(i).next = list.get(j);
                i++;
                if (i == j) {
                    break;
                }
                list.get(j).next = list.get(i);
                j--;
            }
            list.get(i).next = null;

        }

        /**
         * 利用 反转链表+快慢指针找到中间节点+合并节点
         *
         * @param head
         */
        public void reorderList3(ListNode head) {
            if (head == null || head.next == null || head.next.next == null) {
                return;
            }
            // 快慢指针找到中间节点
            ListNode slow = head;
            ListNode fast = head.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            // 断开中点
            // 1 记录后半截头节点
            ListNode next = slow.next;
            // 2 断开前半截和后半截
            slow.next = null;
            // 准备 ： 记录后半截头结点
            slow = next;
            // 准备 ： 反转后的头结点
            ListNode head2 = null;
            // 后半截反转 原地反转
            while (slow != null) {
                next = slow.next;
                slow.next = head2;
                head2 = slow;
                slow = next;
            }

            // 合并链表

            ListNode curr = head;
            ListNode curr2 = head2;

            while (curr != null && curr2 != null) {
                next = curr.next;
                curr.next = curr2;
                curr2 = curr2.next;
                curr.next.next = next;
                curr = next;
            }


        }
    }
}
