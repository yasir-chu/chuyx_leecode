package leecode;

/**
 * 有一个长度为N的整形数组，我们从位置下标0开始，可以向前也可以向后走一步，即到N，或者1
 * 问经过给的n步，能有几种方式可以到达远点
 * @author yuxiang.chu
 * @date 2022/2/21 9:59
 **/
public class My1 {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,7,8,9,10};
        System.out.println(jisuan(10,a));
    }

    public static int jisuan(int n, int[] N){
        return jisuan(n, N, 0);
    }

    public static int jisuan(int n, int[] N, int now){
        int max = 0;
        if (n == 0){
            return now == 0 ? 1 : 0;
        }

        // 向前走
        if (now + 1>N.length){
            now = 0;
        }
        max = max + jisuan(n - 1, N, now);
        // 向后走
        if (now - 1 < 0){
            now = N.length;
        }
        max = max + jisuan(n - 1, N, now);
        return max;
    }
}
