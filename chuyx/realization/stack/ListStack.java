package realization.stack;

/**
 * 链表-栈的实现
 *
 * @author yuxiang.chu
 * @date 2022/1/26 10:09
 **/
public class ListStack {
    private Node top;
    private int size;

    public void clear(){
        this.top = null;
        this.size = 0;
    }

    /**
     * 入参操作
     * @param data
     */
    public void push(String data) {
        if (top == null) {
            top = createNode(data, null);
        } else {
            top = createNode(data, top);
        }
    }

    /**
     * 出栈操作
     * @return
     */
    public String pop() {
        if (top == null){
            return null;
        }
        Node result = top;
        top = top.next;
        return result.data;
    }


    public static Node createNode(String data, Node node) {
        return new Node(data, node);
    }

    public static class Node {

        private String data;
        private Node next;

        public Node(String data) {
            this(data, null);
        }

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public void setData(String data) {
            this.data = data;
        }

        public String getData() {
            return this.data;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return this.next;
        }
    }
}
