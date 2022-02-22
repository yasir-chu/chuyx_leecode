package leecode;

/**
 * @author yuxiang.chu
 * @date 2022/2/22 11:07
 **/
public class LeeCode64 {

    public static void main(String[] args) {
        Solution solution = new LeeCode64().new Solution();
        int[][] item = {{7,2},{6,6},{8,6},{8,7},{5,0},{6,0}};
        System.out.println(solution.minPathSum(item));
    }

    class Solution {
        public int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (i == m - 1) {
                        grid[i][j] = j + 1 < n ? grid[i][j] + grid[i][j + 1] : grid[i][j];
                    } else if (j == n - 1) {
                        grid[i][j] = i + 1 < m ? grid[i][j] + grid[i + 1][j] : grid[i][j];
                    } else {
                        if (grid[i][j + 1] > grid[i + 1][j]) {
                            grid[i][j] += grid[i + 1][j];
                        } else {
                            grid[i][j] += grid[i][j + 1];
                        }
                    }
                }
            }
            return grid[0][0];
        }
    }
}
