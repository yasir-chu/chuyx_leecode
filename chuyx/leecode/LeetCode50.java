package leecode;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xⁿ ）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * <p>
 * 示例 2：
 * <p>
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * <p>
 * 示例 3：
 * <p>
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 * <p>
 * <p>
 * 提示：
 * <p>
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * -104 <= xⁿ <= 104
 * <p>
 * Related Topics 递归 数学 👍 866 👎 0
 *
 * @author yuxiang.chu
 * @date 2022/2/9 10:21
 **/
public class LeetCode50 {

    public static void main(String[] args) {
        Solution solution = new LeetCode50().new Solution();
        System.out.println(solution.myPow2(2, 2));
    }

    class Solution {
        /**
         * 常规解法
         * @param x
         * @param n
         * @return
         */
        public double myPow(double x, int n) {
            if (n == 0 || x == 1) {
                return 1;
            }
            double result = x;
            boolean flag = false;
            if (n < 0) {
                n = -n;
                flag = true;
            }
            for (int i = 1; i < n; i++) {
                result = result * x;
            }
            if (flag) {
                result = 1 / result;
            }
            return result;
        }

        public double myPow2(double x, int n) {
            long N = n;
            return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
        }

        private double quickMul(double x, long N) {
            if (N == 0) {
                return 1.0;
            }
            double y = quickMul(x, N / 2);
            return N % 2 == 0 ? y * y : y * y * x;

        }
    }
}
