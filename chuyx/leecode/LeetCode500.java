package leecode;

/**
 * @author yuxiang_chu
 * @date 2022/11/10 14:28
 */
public class LeetCode500 {

    public static void main(String[] args) {
        Solution solution = new LeetCode500().new Solution();
        System.out.println(solution.fib2(30));
    }

    class Solution {
        public int fib(int n) {
            if (n == 0) {
                return n;
            }
            if (n == 1) {
                return n;
            }
            return fib(n-1) + fib(n-2);
        }

        public int fib2(int n) {
            if ( n < 2) {
                return n;
            }
            int a = 0,b=1;
            int c = 0;
            for (int i = 2; i <= n; i++) {
                c = a + b;
                int item = b;
                b = c;
                a = item;

            }
            return c;
        }
    }
}
