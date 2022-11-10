package leecode;

/**
 * @author yuxiang_chu
 * @date 2022/11/9 15:42
 */
public class LeetCode764 {

    // todo chuyx 没有get到动态规划
    public static void main(String[] args) {
        Solution solution = new LeetCode764().new Solution();
        int[][] a = {{0,2},{1,0},{2,0}};
        System.out.println(solution.orderOfLargestPlusSign(3, a));
    }

    class Solution {

        /**
         * 超时
         * @param n
         * @param mines
         * @return
         */
        public int orderOfLargestPlusSign(int n, int[][] mines) {
            int res = 0;
            for (int i = 0; i < n; i++) {
                loop:
                for (int j = 0; j < n; j++) {
                    for (int[] mine : mines) {
                        int x = mine[0];
                        int y = mine[1];
                        if (x == i && y == j) {
                            continue loop;
                        }
                    }
                    int allMin = Integer.MAX_VALUE;
                    for (int[] mine : mines) {
                        int x = mine[0];
                        int y = mine[1];
                        if (x == i && y == j) {
                            continue loop;
                        }
                        int transverseMin = 0;
                        int verticalMin = 0;
                        int itemMin = 0;
                        if (y == j) {
                            transverseMin = Math.min(Math.abs(x - i), x > i ? i + 1 : n - i);
                            itemMin = Math.max(transverseMin, res);
                        } else if (x == i) {
                            verticalMin = Math.min(Math.abs(y - j), y > j ? j + 1 : n - j);
                            itemMin = Math.max(verticalMin, res);
                        } else {
                            itemMin = Math.max(res, Math.min(Math.min(i + 1, n - i), Math.min(j + 1, n - j)));
                        }
                        allMin = Math.min(itemMin, allMin);
                    }
                    res = Math.max(allMin, res);
                }
            }
            return mines.length == n*n ? 0 : res == 0 ? 1: res;
        }


        public int orderOfLargestPlusSign2(int n, int[][] mines) {
            return 0;
        }
    }
}
