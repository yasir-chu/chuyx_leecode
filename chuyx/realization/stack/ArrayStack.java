package realization.stack;

import java.util.Arrays;

/**
 * 数组-栈的自我实现
 *
 * @author yuxiang.chu
 * @date 2022/1/26 9:48
 **/
public class ArrayStack {

    /**
     * 存储数据的数组
     */
    private Object[] data;

    /**
     * 栈顶指针
     */
    private int top = -1;


    /**
     * 定义一个初始化大小为n的栈
     *
     * @param n
     */
    public ArrayStack(int n) {
        data = new Object[n];
    }

    /**
     * 入栈操作
     *
     * @param o
     */
    public void pushStack(Object o) {
        top++;
        if (top >= data.length) {
            // 数组长度不够，扩容至原来的1.5 倍
            Object[] newData = new Object[data.length + (data.length + 1) / 2];
            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
        data[top] = o;
    }

    /**
     * 出栈操作
     */
    public Object pullStack() {
        if (top < 0) {
            return null;
        }
        Object result = data[top];
        top--;
        return result;
    }
}
