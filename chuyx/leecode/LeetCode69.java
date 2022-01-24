package leecode;

/**
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 4
 * 输出：2
 * <p>
 * 示例 2：
 * <p>
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= x <= 2³¹ - 1
 * <p>
 * Related Topics 数学 二分查找 👍 864 👎 0
 *
 * @author yuxiang.chu
 * @date 2022/1/18 16:45
 **/
public class LeetCode69 {

    public static void main(String[] args) {
        Solution solution = new LeetCode69().new Solution();
        System.out.println(solution.mySqrt2(4));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            if (x == 1 || x == 0) {
                return x;
            }
            long start = 0L;
            long end = (long) x;
            while (true) {
                // 因为判断了左右编辑 所以这里就不需要进行边界考虑
                long mid = (start + end) / 2;
                if (mid * mid == (long) x) {
                    return Integer.parseInt(String.valueOf(mid));
                } else if (mid * mid < (long) x && (mid + 1) * (mid + 1) > (long) x) {
                    return Integer.parseInt(String.valueOf(mid));
                } else if (mid * mid > (long) x && (mid - 1) * (mid - 1) < (long) x) {
                    return Integer.parseInt(String.valueOf(mid)) - 1;
                }
                if (mid * mid > (long) x || mid * mid < 0) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
        }

        public int mySqrt2(int x) {
            // 特殊值考虑
            if (x == 1 || x == 0) {
                return x;
            }
            // 边界提前确认 减少循坏次数
            int start = 1;
            int end = x / 2;
            while (start < end) {
                // 加一操作是为了向上取整  保证每个数都能够取到
                int mid = (start + end + 1) / 2;
                // 使用除法防止int溢出
                if (mid > x / mid) {
                    end = mid - 1;
                } else {
                    start = mid;
                }
            }
            return start;
        }
    }
}
