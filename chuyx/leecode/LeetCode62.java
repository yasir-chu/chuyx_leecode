package leecode;

/**
 * <p>一个机器人位于一个 <code>m x n</code><em> </em>网格的左上角 （起始点在下图中标记为 “Start” ）。</p>
 * <p>机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。</p>
 * <p>问总共有多少条不同的路径？</p>
 * <p> </p>
 * <p><strong>示例 1：</strong></p>
 * <img src="https://assets.leetcode.com/uploads/2018/10/22/robot_maze.png" />
 * <pre>
 * <strong>输入：</strong>m = 3, n = 7
 * <strong>输出：</strong>28</pre>
 * <p><strong>示例 2：</strong></p>
 * <pre>
 * <strong>输入：</strong>m = 3, n = 2
 * <strong>输出：</strong>3
 * <strong>解释：</strong>
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 * </pre>
 * <p><strong>示例 3：</strong></p>
 * <pre>
 * <strong>输入：</strong>m = 7, n = 3
 * <strong>输出：</strong>28
 * </pre>
 * <p><strong>示例 4：</strong></p>
 * <pre>
 * <strong>输入：</strong>m = 3, n = 3
 * <strong>输出：</strong>6</pre>
 * <p> </p>
 * <p><strong>提示：</strong></p>
 * <ul>
 * 	<li><code>1 <= m, n <= 100</code></li>
 * 	<li>题目数据保证答案小于等于 <code>2 * 10<sup>9</sup></code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数学</li><li>动态规划</li><li>组合数学</li></div></div><br><div><li>👍 1282</li><li>👎 0</li></div>
 *
 * @author yuxiang.chu
 * @date 2022/2/22 10:05
 **/
public class LeetCode62 {


    public static void main(String[] args) {
        Solution solution = new LeetCode62().new Solution();
        System.out.println(solution.uniquePaths(7, 3));
    }


    class Solution {
        /**
         * 不建议采用递归，递出去加回递会导致超时。此时我们知道子集的结果，可以使用动态规划
         *
         * @param m
         * @param n
         * @return
         */
        public int uniquePaths(int m, int n) {
            int[][] ints = new int[m][n];
            ints[m - 1][n - 1] = 1;
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (i == m -1){
                        ints[i][j] = 1;
                    }else if (j == n -1){
                        ints[i][j] = 1;
                    }else{
                        ints[i][j] = ints[i+1][j] + ints[i][j+1];
                    }
                }
            }
            return ints[0][0];
        }


    }
}
