package realization.queue;

/**
 * 循坏队列的自我实现
 *
 * @author yuxiang.chu
 * @date 2022/1/27 11:56
 **/
public class CircularQueue {

    private Object[] data;
    private int tail;
    private int head;

    public CircularQueue() {
        data = new Object[10];
    }

    public CircularQueue(int initSize) {
        data = new Object[initSize];
    }

    public boolean join(Object o) {
        // 队满判断  循环队列会浪费一个数组的存储空间。
        if ((tail + 1) % data.length == head) {
            return false;
        }
        data[tail] = o;
        tail = (tail + 1) % data.length;
        return true;
    }

    public Object pop() {
        // 队空判断
        if (tail == head) {
            return null;
        }
        Object o = data[head];
        head = (head + 1) % data.length;
        return o;
    }
}
