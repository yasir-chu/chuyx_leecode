package realization.list;

/**
 * 单链表的自我实现
 *
 * @author yuxiang.chu
 * @date 2022/1/25 9:22
 **/
public class MyLinkedList {


    /**
     * 单链表反转
     *
     * @param list
     * @return
     */
    public Node reverse(Node list) {
        Node beg = null, end = list;
        while (end != null) {
            Node next = end.next;
            end.next = beg;
            beg = end;
            end = next;
        }
        return beg;
    }


    /**
     * 找到单链表的中间节点
     * 注意：如果是偶数长度的单链表，会返回靠左中间节点
     *
     * @param head 单链表头节点
     * @return 该单链表的中间节点
     */
    public Node findCenterNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 删除单链表中倒数第index个节点
     *
     * @param head
     * @param index
     * @param
     * @return
     */
    public Node delEndIndex(Node head, int index) {
        if (head == null) {
            throw new NullPointerException();
        }
        int size = 0;
        Node item = head;
        while (item != null) {
            size++;
            item = item.next;
        }
        if (index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int delIndex = size + 1 - index;

        return delStartNode(head, delIndex);
    }

    /**
     * 删除单链表的第n个节点
     * @param list
     * @param index
     * @return
     */
    public Node delStartNode(Node list, int index) {
        Node item = list;
        int i = 1;
        while (item != null && i < index - 1) {
            item = item.next;
            i++;
        }
        if (item == null) {
            return list;
        }
        if (item.next == null) {
            return list;
        }
        if (item.next.next == null) {
            item.next = null;
        }
        item.next = item.next.next;
        return list;
    }

    /**
     * 合并两个有序链表
     *
     * @param la
     * @param lb
     * @return
     */
    public Node mergeOrderedNode(Node la, Node lb) {
        if (la == null) {
            return lb;
        }
        if (lb == null) {
            return la;
        }
        Node q = la;
        Node p = lb;
        Node head;
        if (q.value > p.value) {
            head = p;
            p = p.next;
        } else {
            head = q;
            q = q.next;
        }
        Node r = head;

        while (p != null && q != null) {
            if (q.value < p.value) {
                r.next = q;
                p = p.next;
            } else {
                r.next = p;
                q = q.next;
            }
            r = r.next;
        }
        if (p != null) {
            r.next = p;
        } else {
            r.next = q;
        }
        return head;
    }

    /**
     * 合并两个有序链表
     *
     * @param la
     * @param lb
     * @return
     */
    public Node mergeOrderedNodeTwo(Node la, Node lb) {
        Node node = createNode(0);
        Node p = node;
        while (la != null && lb != null) {
            if (la.value > lb.value) {
                p.next = lb;
                lb = lb.next;
            } else {
                p.next = la;
                la = la.next;
            }
            p = p.next;
        }
        if (la != null) {
            p.next = la;
        } else {
            p.next = la;
        }

        return node.next;
    }

    /**
     * 检测环
     *
     * @param head
     * @param
     * @return
     */
    public boolean checkRing(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        Node slow, fast;
        slow = head.next;
        fast = head.next.next;

        while (fast != null && fast.next != null) {
            if (fast == slow) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public Node createNode(int value) {
        return new Node(value, null);
    }


    public static class Node {

        private int value;
        private Node next;


        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public int getData() {
            return value;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return next;
        }
    }
}
