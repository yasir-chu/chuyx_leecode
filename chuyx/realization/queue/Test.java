package realization.queue;

/**
 * @author yuxiang.chu
 * @date 2022/1/27 11:09
 **/
public class Test {

    public static void main(String[] args) {
//        ArrayQueue arrayQueue = new ArrayQueue();
//        arrayQueue.join(1);
//        arrayQueue.join(2);
//        arrayQueue.join(3);
//        System.out.println(arrayQueue.pop());
//        System.out.println(arrayQueue.pop());
//        System.out.println(arrayQueue.pop());
//        System.out.println(arrayQueue.pop());
//        arrayQueue.join(1);
//        arrayQueue.join(2);
//        arrayQueue.join(3);
//        arrayQueue.join(4);
//        arrayQueue.join(5);
//        arrayQueue.join(6);
//        arrayQueue.join(7);
//        arrayQueue.join(8);
//        arrayQueue.join(9);
//        arrayQueue.join(10);
//        arrayQueue.join(11);
//        arrayQueue.join(12);
//        System.out.println(arrayQueue.pop());
//        System.out.println(arrayQueue.pop());
//        System.out.println(arrayQueue.pop());
//        System.out.println(arrayQueue.pop());
//        System.out.println(arrayQueue.pop());
//        System.out.println(arrayQueue.pop());
//        System.out.println(arrayQueue.pop());
//        System.out.println(arrayQueue.pop());
//        System.out.println(arrayQueue.pop());
//        System.out.println(arrayQueue.pop());
//        System.out.println(arrayQueue.pop());
//        System.out.println(arrayQueue.pop());
//        System.out.println(arrayQueue.pop());

//        ListQueue listQueue = new ListQueue();
//        listQueue.join(1);
//        listQueue.join(2);
//        listQueue.join(3);
//        System.out.println(listQueue.pop());
//        System.out.println(listQueue.pop());
//        System.out.println(listQueue.pop());
//        System.out.println(listQueue.pop());
//        listQueue.join(1);
//        listQueue.join(2);
//        listQueue.join(3);
//        listQueue.join(4);
//        listQueue.join(5);
//        System.out.println(listQueue.pop());
//        System.out.println(listQueue.pop());
//        System.out.println(listQueue.pop());
//        System.out.println(listQueue.pop());
//        System.out.println(listQueue.pop());

        CircularQueue circularQueue = new CircularQueue(2);
        System.out.println(circularQueue.join(1));
        System.out.println(circularQueue.join(2));
        System.out.println(circularQueue.join(3));
        System.out.println(circularQueue.join(4));
        System.out.println(circularQueue.pop());
        System.out.println(circularQueue.pop());
        System.out.println(circularQueue.pop());
    }
}
