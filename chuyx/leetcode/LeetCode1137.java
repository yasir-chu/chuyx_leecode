package leetcode;

/**
 * @author yuxiang_chu
 * @date 2022/11/10 16:11
 */
public class LeetCode1137 {

    public static void main(String[] args) {
        Solution solution = new LeetCode1137.Solution();
        System.out.println(solution.tribonacci2(25));

    }

    static class Solution {
        // 注意边界考虑
        public int tribonacci(int n) {
            if (0 == n) {
                return 0;
            }
            int[] resArr = new int[Math.max(n + 1, 3)];
            resArr[0] = 0;
            resArr[1] = 1;
            resArr[2] = 1;
            for (int i = 3; i <= n; i++) {
                resArr[i] = resArr[i-2] + resArr[i-1] + resArr[i -3];
            }
            return resArr[n];
        }

        public int tribonacci2(int n) {
            if (n < 3) {
                return n == 0 ? 0 : 1;
            }
            int a = 0, b = 1, c = 1;
            int res = 0;
            for (int i = 3; i <= n; i++) {
                res = a + b + c;
                a = b;
                b = c;
                c = res;
            }
            return c;
        }
    }

}
