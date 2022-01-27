package realization.queue;

import realization.stack.ListStack;

/**
 * 基于链表的队列的自我实现
 * @author yuxiang.chu
 * @date 2022/1/27 11:34
 **/
public class ListQueue {

    private Node tail;
    private Node head;

    public void join(Object o){
        if (head == null){
            head = new Node(o);
            tail = head;
        }else{
            tail.next = new Node(o);
        }
    }

    public Object pop(){
        if (head == null){
            return null;
        }
        Node result = head;
        head = head.next;
        return result.data;
    }


    public class Node {

        private Object data;
        private Node next;

        public Node(Object data) {
            this(data, null);
        }

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }


    }
}
