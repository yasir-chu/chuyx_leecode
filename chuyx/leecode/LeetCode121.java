package leecode;

/**
 * @author yuxiang.chu
 * @date 2021/10/18 11:04
 **/
public class LeetCode121 {

    public static void main(String[] args) {
        Solution solution = new LeetCode121().new Solution();
        int[] arr = {2,4,1};
        System.out.println(solution.maxProfit(arr));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 暴力解法  会超出时间限制
        public int maxProfit(int[] prices) {
            int maxProfit = 0;
            for (int i = 0; i < prices.length; i++) {
                for (int j = i + 1; j < prices.length; j++) {
                    maxProfit = Math.max(prices[j] - prices[i], maxProfit);
                }
            }
            return maxProfit;
        }

        public int maxProfit3(int[] prices){
            int len = prices.length;
            // 特殊判断
            if (len < 2) {
                return 0;
            }
            int[][] dp = new int[len][2];

            // dp[i][0] 下标为 i 这天结束的时候，不持股，手上拥有的现金数
            // dp[i][1] 下标为 i 这天结束的时候，持股，手上拥有的现金数

            // 初始化：不持股显然为 0，持股就需要减去第 1 天（下标为 0）的股价
            dp[0][0] = 0;
            dp[0][1] = -prices[0];

            // 从第 2 天开始遍历
            for (int i = 1; i < len; i++) {
                // 不持股
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                // 持股
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            }
            return dp[len - 1][0];

        }


        public int maxProfit2(int[] prices){
            int len = prices.length;
            if (len < 2) {
                return 0;
            }

            int[] dp = new int[2];
            dp[0] = 0;
            dp[1] = -prices[0];
            for (int i = 1; i < len; i++) {
                dp[0] = Math.max(dp[0], dp[1] + prices[i]);
                dp[1] = Math.max(dp[1], -prices[i]);
            }
            return dp[0];
        }

    }
}
