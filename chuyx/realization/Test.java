package realization;

/**
 * @author yuxiang.chu
 * @date 2022/1/25 10:26
 **/
public class Test {

    public static void main(String[] args) {

    }

    public static void testMyLinkedList(){
        MyLinkedList.Node node = new MyLinkedList.Node(1, null);
        node.setNext(new MyLinkedList.Node(2, null));
        node.getNext().setNext(new MyLinkedList.Node(3, null));
        MyLinkedList.Node node2 = new MyLinkedList.Node(4, null);
        node.getNext().getNext().setNext(node2);
        node.getNext().getNext().getNext().setNext(new MyLinkedList.Node(5, null));
        node.getNext().getNext().getNext().getNext().setNext(new MyLinkedList.Node(6, null));
        node.getNext().getNext().getNext().getNext().getNext().setNext(node2);
        MyLinkedList myLinkedList = new MyLinkedList();
//        MyLinkedList.Node reverse = myLinkedList.reverse(node);
        System.out.println(myLinkedList.checkRing(node));
//        myLinkedList.delEndIndex(reverse, 3);
//        MyLinkedList.Node node1 = myLinkedList.mergeOrderedNode(reverse, node);
    }
}
