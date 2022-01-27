package realization.list;

/**
 * 最近最少使用实现
 *
 * @author yuxiang.chu
 * @date 2022/1/27 16:33
 **/
public class LRUTest {

    public static void main(String[] args) {
        LRUTest lruTest = new LRUTest();
        lruTest.use(1);
        lruTest.use(2);
        lruTest.use(1);
        lruTest.use(3);
        lruTest.use(4);
        lruTest.del();
    }

    private MyLinkedList.Node list;

    public LRUTest() {

    }

    public void use(int useData) {
        if (list == null) {
            list = new MyLinkedList.Node(useData, null);
        } else {
            // 判断是否存在
            MyLinkedList.Node item = list;
            if (item.getData() == useData) {
                return;
            }
            // 存在删除这个节点
            while (item.getNext() != null) {
                if (item.getNext().getData() == useData) {
                    item.setNext(item.getNext().getNext());
                    continue;
                }
                item = item.getNext();
            }
            MyLinkedList.Node node = new MyLinkedList.Node(useData, list);
            list = node;
        }

    }

    public void del() {
        MyLinkedList.Node item = list;
        while (item != null && item.getNext() != null) {
            if (item.getNext().getNext() == null) {
                item.setNext(null);
            } else {
                item = item.getNext();
            }
        }
    }


}
