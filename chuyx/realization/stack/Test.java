package realization.stack;

/**
 * @author yuxiang.chu
 * @date 2022/1/26 9:59
 **/
public class Test {

    public static void main(String[] args) {
//        ArrayStack arrayStack = new ArrayStack(3);
//        arrayStack.pushStack(1);
//        System.out.println(arrayStack.pullStack());
//        arrayStack.pushStack(2);
//        arrayStack.pushStack(3);
//        arrayStack.pushStack(4);
//        arrayStack.pushStack(5);
//        System.out.println(arrayStack.pullStack());
//        System.out.println(arrayStack.pullStack());
//        System.out.println(arrayStack.pullStack());
//        System.out.println(arrayStack.pullStack());


        ListStack listStack = new ListStack();
        listStack.push("1");
        System.out.println(listStack.pop());
        listStack.push("2");
        listStack.push("3");
        listStack.push("4");
        System.out.println(listStack.pop());
        System.out.println(listStack.pop());
        System.out.println(listStack.pop());
    }
}
