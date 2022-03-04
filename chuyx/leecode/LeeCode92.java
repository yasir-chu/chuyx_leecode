package leecode;

import realization.list.MyLinkedList;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author yuxiang.chu
 * @date 2022/3/1 17:30
 **/
public class LeeCode92 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        Solution solution = new Solution();
        ListNode listNode1 = solution.reverseBetween(listNode, 2, 4);

    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    static class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            // 1 虚拟头结点
            ListNode dummyNode = new ListNode(-1);
            dummyNode.next = head;

            // 2 从虚拟节点都到要反转的子链开始节点
            ListNode pre = dummyNode;
            for (int i = 0; i < left-1; i++) {
                pre = pre.next;
            }

            // 3 从pre走 right-left+1步到子链的尾节点
            ListNode rightNode = pre;
            for (int i = 0; i < right - left +1; i++) {
                rightNode = rightNode.next;
            }

            // 4 切开
            ListNode leftNode = pre.next;
            ListNode curr = rightNode.next;

            pre.next = null;
            rightNode.next = null;

            // 5 反转子链表
            reverseLinkedList(leftNode);

            // 6 接起来
            pre.next = rightNode;
            leftNode.next = curr;

            return dummyNode.next;
        }

        private void reverseLinkedList(ListNode leftNode) {
            ListNode beg = null, end = leftNode;
            while (end != null){
                ListNode item = end.next;
                end.next = beg;
                beg = end;
                end = item;
            }
        }


        public ListNode reverseBetween2(ListNode head, int left, int right) {
            // 设置 dummyNode 是这一类问题的一般做法
            ListNode dummyNode = new ListNode(-1);
            dummyNode.next = head;
            ListNode pre = dummyNode;
            for (int i = 0; i < left - 1; i++) {
                pre = pre.next;
            }
            ListNode cur = pre.next;
            ListNode next;
            for (int i = 0; i < right - left; i++) {
                next = cur.next;
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
            return dummyNode.next;
        }


        // todo  这个没看懂
        int i = 0;
        public ListNode reverseBetween3(ListNode head, int left, int right) {
            i++;
            if (i == right) {
                return head;
            }
            if (i < left) {
                head.next = reverseBetween3(head.next, left, right);
                return head;
            } else {
                ListNode node = reverseBetween3(head.next, left, right);
                ListNode nex = head.next.next;
                head.next.next = head;
                head.next = nex;
                return node;
            }
        }


    }
}
