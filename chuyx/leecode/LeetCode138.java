package leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chuyx
 */
public class LeetCode138 {

    public static void main(String[] args) {

    }


    class Solution {
        Map<Node, Node> resultMap = new HashMap<>();
        public Node copyRandomList(Node head) {
            if (head == null){
                return null;
            }
            // 递归
            if (!resultMap.containsKey(head)){
                Node item = new Node(head.val);
                resultMap.remove(head,item);
                item.next = copyRandomList(head.next);
                item.random = copyRandomList(head.random);
            }
            return resultMap.get(head);
        }


        public Node copyRandomList2(Node head) {
            // 三次遍历 3-》6 再操作 画图
            if (head == null){
                return null;
            }
            for (Node node = head; node != null;node = node.next.next){
                Node newNode = new Node(node.val);
                newNode.next = node.next;
                node.next = newNode;
            }

            for (Node node = head; node != null;node = node.next.next){
                Node newNode = node.next;
                newNode.random = node.random != null ? node.random.next : null;
            }
            Node result = head.next;
            for (Node node = head;node != null; node = node.next){
                Node newNode = node.next;
                node.next = node.next.next;
                newNode.next = newNode.next == null ? null : newNode.next.next;
            }
            return result;
        }
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
