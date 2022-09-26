package leecode;

/**
 * @author yuxiang_chu
 * @date 2022/9/23 15:33
 */
public class LeetCode707 {

    public static void main(String[] args) {
        LeetCode707.MyLinkedList linkedList = new LeetCode707.MyLinkedList();
        linkedList.addAtHead(7);
        linkedList.addAtHead(2);
        linkedList.addAtHead(1);
        linkedList.addAtIndex(3,0);
        linkedList.deleteAtIndex(2);
        linkedList.addAtHead(6);
        linkedList.addAtTail(4);
        linkedList.get(4);
        linkedList.addAtHead(4);
        linkedList.addAtIndex(5,0);
        linkedList.addAtHead(6);
    }


    /**
     * 注意边界判断
     * 优化点：
     * 增加len
     */
    static class MyLinkedList {

        private Integer val;

        private MyLinkedList next;

        private int len = 0;

        public MyLinkedList() {
        }

        public MyLinkedList(int val) {
            this.val = val;
        }

        public MyLinkedList(int val, MyLinkedList next) {
            this.val = val;
            this.next = next;
        }

        public int get(int index) {
            if (index < 0 || index >= len) {
                return -1;
            }
            MyLinkedList result = this;
            for (int i = 0; i <= index && result != null; i++, result = result.next) {
                if (i == index) {
                    return result.val == null ? -1 : result.val;
                }
            }
            return -1;
        }

        public void addAtHead(int val) {
            len++;
            // 边界判断
            if (this.val == null) {
                this.val = val;
                return;
            }
            MyLinkedList next = new MyLinkedList(this.val, this.next);
            this.val = val;
            this.next = next;
        }

        public void addAtTail(int val) {
            // 边界判断
            if (this.val == null) {
                addAtHead(val);
                return;
            }
            len++;
            // 其余情况
            MyLinkedList tail = this;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = new MyLinkedList(val);
        }

        public void addAtIndex(int index, int val) {
            if (index > len) {
                return;
            }
            if (index <= 0) {
                addAtHead(val);
                return;
            }
            len++;
            MyLinkedList addIndex = this;
            for (int i = 0; i < index - 1; i++) {
                addIndex = addIndex.next;
            }
            MyLinkedList newAdd = new MyLinkedList(val);
            MyLinkedList next = addIndex.next;
            addIndex.next = newAdd;
            newAdd.next = next;
        }

        public void deleteAtIndex(int index) {
            // 边界判断  ||  超越尾节点，不进行del操作
            if (len == 0 || index < 0 || index >= len) {
                return;
            }
            len--;
            if (index == 0) {
                this.val = this.next == null ? null : this.next.val;
                this.next = this.next == null ? null : this.next.next;
                return;
            }
            // 删除节点的上一个节点
            MyLinkedList delIndex = this;
            for (int i = 0; i < index - 1; i++) {
                delIndex = delIndex.next;
            }
            MyLinkedList next1 = delIndex.next;
            delIndex.next = next1.next;
        }
    }
}
