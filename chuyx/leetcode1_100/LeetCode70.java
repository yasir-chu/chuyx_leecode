package leetcode1_100;
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
// 注意：给定 n 是一个正整数。
//
// 示例 1：
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶
//
// 示例 2：
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
//
// Related Topics 记忆化搜索 数学 动态规划 👍 1903 👎 0
/**
 * @author yuxiang.chu
 */
public class LeetCode70 {
    public static void main(String[] args) {
        Solution solution = new LeetCode70.Solution();
        System.out.println(solution.climbStairs(9));
        System.out.println(solution.climbStairs2(9));
        System.out.println(solution.climbStairs3(9));
    }

    /**
     * 递归算法就是将大问题拆分成小问题 用小问题的答案整合成大问题的答案
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public int climbStairs(int n) {
            // 一个台阶特殊值 1  b 前n个台阶上的方式  c结果
            int a = 1, b=0, c=0;
            for (int i = 1; i <= n; i++) {
                c=0;
                if (i == 1){
                    // 只有一个台阶的话  只能走一个台阶
                    c = a;
                }
                if (i > 1){
                    // 不只一个台阶的话  可以走b+a种方式
                    c = b + a;
                }
                b=a;
                a=c;
            }
            return c;
        }


        public int climbStairs2(int n) {
            // 初始化 a=上两个台阶的方式  b=上一个台阶的方式  c = a
            int a = 2,b=1,c=2;

            // 直接从第三个台阶开始 减少循环次数
            for (int i = 3; i <= n; i++) {
                c = a + b;
                b=a;
                a=c;
            }
            return c;
        }

        public int climbStairs3(int n) {
            // 初始化 a=上两个台阶的方式  b=上一个台阶的方式  c = a
            if (n == 1){
                return 1;
            }
            if (n == 2){
                return 2;
            }
            return climbStairs3(n-1) + climbStairs3(n - 2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}