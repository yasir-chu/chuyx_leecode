package practice;

/**
 * 单链表实现回文字符串算法
 * @author yuxiang.chu
 * @date 2022/1/24 10:53
 **/
public class LinkedListString {

    public static void main(String[] args) {
        // 构造一个字符串
        Node<Character> a = new Node<>( 'a', null);
        a.setNext(new Node<>( 'b', null));
        a.next.setNext(new Node<>( 'c', null));
        a.next.next.setNext(new Node<>( 'c', null));
        a.next.next.next.setNext(new Node<>( 'b', null));
        a.next.next.next.next.setNext(new Node<>( 'g', null));
        // 回文字符串判定
        if (determinePalindrome(a)){
            System.out.println("Yes");
        }else{
            System.out.println("NO");
        }
    }

    /**
     * 判断str是否是回文字符串
     * @param str
     * @return
     */
    private static boolean determinePalindrome(Node<Character> str) {
        // 边界值考虑 start
        Node<Character> center = null;
        if (str.next == null){
            return true;
        }
        Node<Character> small = str.next;
        if (str.next.next == null){
            if (str.data.equals(small.data)){
                return true;
            }else{
                return false;
            }
        }
        // 边界值考虑 end
        // 双指针 快慢指针
        Node<Character> fast = str.next.next;
        while(true) {
            center = small;
            if (fast.next == null){
                break;
            }
            fast = fast.next.next;
            if (fast == null){
                center = small.next;
                break;
            }
            small =small.next;
        }
        Node<Character> reverse = reverse(center);
        while(true){
            if (reverse.next == null){
                break;
            }else if (!str.data.equals(reverse.data)){
                return false;
            }
            reverse = reverse.next;
            str = str.next;
        }
        return true;
    }


    public static Node<Character> reverse(Node<Character> head){
        if (head == null || head.next == null){
            return head;
        }
        Node<Character> beg = null;
        Node<Character> mid = head;
        Node<Character> end = head.next;

        while (true){
            mid.next = beg;
            if (end == null){
                break;
            }

            beg = mid;
            mid = end;
            end = end.next;
        }
        head = mid;
        return head;
    }

    /**
     * 新建链表 头插法生成新的链表
     * @param head
     * @return
     */
    public static Node<Character> reverse2(Node<Character> head){
        if (head == null || head.next == null){
            return head;
        }
        Node<Character> newHead = new Node<Character>(head.data, null);

        while (head.next != null){
            Node<Character> item = head.next;
            Node<Character> newHead2 = new Node<>(item.data, null);
            newHead2.setNext(newHead);
            newHead = newHead2;
            head = head.next;
        }

        return newHead;
    }

    /**
     * 就地逆转
     * @param head
     * @return
     */
    public static Node<Character> reverse3(Node<Character> head){
        if (head == null || head.next == null){
            return head;
        }
        Node<Character> beg = head;
        Node<Character> end = head.next;
        while (end != null){
            beg.setNext(end.next);
            end.setNext(head);
            head = end;
            end = beg.next;
        }
        return head;
    }


    /**
     * 节点
     * @param <E>
     */
    static class Node<E>{
        E data;
        Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}
