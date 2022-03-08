package leecode;

/**
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 如果存在一个整数 x 使得 n == 2ˣ ，则认为 n 是 2 的幂次方。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1
 * 输出：true
 * 解释：2⁰ = 1
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 16
 * 输出：true
 * 解释：2⁴ = 16
 * <p>
 * 示例 3：
 * <p>
 * 输入：n = 3
 * 输出：false
 * <p>
 * 示例 4：
 * <p>
 * 输入：n = 4
 * 输出：true
 * <p>
 * 示例 5：
 * <p>
 * 输入：n = 5
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * -2³¹ <= n <= 2³¹ - 1
 * <p>
 * <p>
 * 进阶：你能够不使用循环/递归解决此问题吗？
 * Related Topics 位运算 递归 数学 👍 458 👎 0
 *
 * @author yuxiang.chu
 * @date 2022/2/8 11:29
 **/
public class LeetCode231 {

    public static void main(String[] args) {
        Solution solution = new LeetCode231().new Solution();

    }

    class Solution {
        // 递归
        public boolean isPowerOfTwo(int n) {
            if (n == 0){
                return false;
            }
            if (n == 1) {
                return true;
            }
            return n % 2 == 0 && isPowerOfTwo(n / 2);
        }

        // 利用位运算
        public boolean isPowerOfTwo2(int n) {
            return n > 0 && (n & (n - 1)) == 0;
        }
    }
}
