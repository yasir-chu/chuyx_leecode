package leetcode;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 *  push(x) —— 将元素 x 推入栈中。
 *  pop() —— 删除栈顶的元素。
 *  top() —— 获取栈顶元素。
 *  getMin() —— 检索栈中的最小元素。
 *
 *
 *  示例:
 *  输入：
 * ["MinStack","push","push","push","getMin","pop",
 * [[],[-2],[0],[-3],[],[],[],[]]
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 *
 *  提示：
 *
 *  pop、top 和 getMin 操作总是在 非空栈 上调用。
 *
 *  Related Topics 栈 设计 👍 1151 👎 0
 * @author yuxiang.chu
 * @date 2022/1/26 11:24
 **/
public class LeetCode155 {
    public static void main(String[] args) {
//        ["MinStack","push","push","push","push","getMin","pop","getMin","pop","getMin","pop","getMin"]
//			[[],[2],[0],[3],[0],[],[],[],[],[],[],[]]
        MinStackTwo minStack = new LeetCode155.MinStackTwo();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(2147483647);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.push(-2147483648);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());

    }


    class MinStack {

        private Node top;
        private int size;

        public MinStack() {

        }

        public void push(int val) {
            if (top == null){
                top = createNode(val);
            }else{
                Node item = createNode(val);
                item.setNext(top);
                top = item;
            }
        }

        public void pop() {
            if (top != null){
                top = top.next;
            }
        }

        public int top() {
            if (top!=null){
                return top.var;
            }else{
                return 0;
            }
        }

        public int getMin() {
            if (top == null){
                return 0;
            }
            Node item = top;
            int min = item.var;
            while (item.next != null) {
                int bj = item.next.var;
                min = bj < min ? bj : min;
                item = item.next;
            }
            return min;
        }

        public Node createNode(int var){
            return new Node(var, null);
        }

        class Node{
            private int var;
            private Node next;

            public Node(int data, Node node){
                this.var = data;
                this.next = node;
            }

            public void setNext(Node next) {
                this.next = next;
            }
        }
    }

    static class MinStackTwo {

        private Integer[] data;
        private int top;
        private Integer minData;

        public MinStackTwo() {
            data = new Integer[10];
            top = -1;
        }

        public void push(int val) {
            top++;
            if (top >= data.length){
                // 扩容
                Integer[] newData = new Integer[data.length * 2];
                for (int i = 0; i < data.length; i++) {
                    newData[i] = data[i];
                }
                data = newData;
            }
            if (minData == null || val < minData) {
                minData = val;
            }
            data[top] = val;
        }

        public void pop() {
            if (top == 0){
                data[top] = null;
                minData = null;
            }
            if (top > 0){
                int item = data[top];
                data[top] = null;
                if (item == minData) {
                    minData = data[0];
                    for (int i = 1; i < data.length; i++) {
                        minData = data[i] != null && data[i] < minData ? data[i] : minData;
                    }
                }
            }
            top--;
        }

        public int top() {
            if (top < data.length && top >= 0){
                return data[top];
            }
            return 0;
        }

        public int getMin() {
            return minData;
        }


    }
}
