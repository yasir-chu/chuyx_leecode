package leecode;

/**
 * @author yuxiang_chu
 * @date 2022/11/10 14:44
 */
public class LeetCode746 {

    public static void main(String[] args) {
        Solution solution = new LeetCode746().new Solution();
        int[] a = {10,15,20};
        System.out.println(solution.minCostClimbingStairs2(a));
    }


    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            if (cost.length == 0) {
                return 0;
            }
            if (cost.length == 1) {
                return cost[0];
            }
            return Math.min(min(cost, cost[0], 0), min(cost, cost[1], 1));
        }

        // 超时？？？
        public int min(int[] cost, int count, int nowNum) {
            if (nowNum >= cost.length - 2) {
                return count;
            }
            return Math.min(min(cost, count + cost[nowNum + 1], nowNum + 1), min(cost, count + cost[nowNum + 2], nowNum + 2));
        }

        public int minCostClimbingStairs2(int[] cost) {
            int n = cost.length;
            int[] dp = new int[n + 1];
            dp[0] = dp[1] = 0;
            for (int i = 2; i <= n; i++) {
                dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
            }
            return dp[n];
        }
    }
}
