package leetcode;

/**
 * @author yuxiang_chu
 * @since 2024/3/15 10:17
 */
public class LeetCode2312 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] prices = {{1,4,2},{2,2,7},{2,1,3}};
        solution.sellingWood(3, 5, prices);
    }


    /**
     * 注意是每次只能选择横切或者是竖切全部长宽
     */
    static class  Solution {
        public long sellingWood(int m, int n, int[][] prices) {
            // 初始化长宽价格
            // 初始化假设mn随意切 都为0
            Long[][] arrPrice = new Long[m+1][n+1];
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    arrPrice[i][j] = 0L;
                }
            }
            for (int i = 0; i < prices.length; i++) {
                arrPrice[prices[i][0]][prices[i][1]] = (long) prices[i][2];
            }

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    for (int k = 1; k < i; k++) {
                        // 横切
                        arrPrice[i][j] = Math.max(arrPrice[i][j], arrPrice[k][j] + arrPrice[i-k][j]);
                    }
                    for (int k = 1; k < j; k++) {
                        // 竖切
                        arrPrice[i][j] = Math.max(arrPrice[i][j], arrPrice[i][j - k] + arrPrice[i][k]);
                    }
                }
            }
            return arrPrice[m][n];
        }
    }
}
