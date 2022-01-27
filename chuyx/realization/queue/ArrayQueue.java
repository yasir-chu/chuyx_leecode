package realization.queue;

/**
 * 数组实现队列的自我实现
 *
 * @author yuxiang.chu
 * @date 2022/1/27 10:52
 **/
public class ArrayQueue {

    private Object[] data;
    private int head;
    private int tail;
    private int size;

    public ArrayQueue() {
        data = new Object[10];
        head = -1;
        tail = -1;
        size = 0;
    }

    public ArrayQueue(int initSize) {
        data = new Object[initSize];
        head = -1;
        tail = -1;
        size = 0;
    }

    public void join(Object o) {
        if (tail == -1) {
            tail++;
        }
        head++;
        if (head >= data.length) {
            if (size >= data.length){
                Object[] newData = new Object[data.length*2];
                for (int i = 0; i < data.length; i++) {
                    newData[i] = data[i];
                }
                data = newData;
            }else{
                head = 0;
            }

        }
        size++;
        data[head] = o;
    }

    public Object pop() {
        Object result = data[tail];
        tail++;
        // 这里还可以考虑 缩容 实现动态队列 节省空间
        if (tail >= data.length) {
            if (data[0] == null){
                throw new NullPointerException();
            }else{
                tail=0;
            }
        }
        if (result != null){
            size --;
        }
        return result;
    }


}
