package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuxiang_chu
 * @since 2024/3/18 14:04
 */
public class LeetCode542 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] a = {{1,1,1},{1,1,1},{1,1,0}};
        solution.updateMatrix(a);

    }

    static class Solution {

        /**
         * 执行耗时:19 ms,击败了9.32% 的Java用户
         * 内存消耗:48.8 MB,击败了5.08% 的Java用户
         */
        public int[][] updateMatrix(int[][] mat) {
            int[][] res = new int[mat.length][mat[0].length];

            // 找到一个起始0
            List<int[]> zeroList = new ArrayList<>();
            for (int i = 0; i < mat.length; i++) {
                for (int i1 = 0; i1 < mat[i].length; i1++) {
                    if (mat[i][i1] == 0) {
                        res[i][i1] = 0;
                        zeroList.add(new int[]{i, i1});
                    } else {
                        res[i][i1] = -1;
                    }
                }
            }
            fillStep(zeroList, res, mat, 0);
            return res;
        }

        private void fillStep(List<int[]> zeroList, int[][] res, int[][] mat, int i) {
            List<int[]> secondList = new ArrayList<>();
            for (int[] nowCoordinate : zeroList) {
                int x = nowCoordinate[0];
                int y = nowCoordinate[1];
                // 上
                if (y - 1 >= 0 && res[x][y - 1] == -1) {
                    res[x][y - 1] = i + 1;
                    secondList.add(new int[]{x, y - 1});
                }
                // 下
                if (y + 1 < mat[x].length && res[x][y + 1] == -1) {
                    res[x][y + 1] = i + 1;
                    secondList.add(new int[]{x, y + 1});
                }
                // 左
                if (x - 1 >= 0 && res[x - 1][y] == -1) {
                    res[x - 1][y] = i + 1;
                    secondList.add(new int[]{x - 1, y});
                }
                // 右
                if (x + 1 < mat.length && res[x + 1][y] == -1) {
                    res[x + 1][y] = i + 1;
                    secondList.add(new int[]{x + 1, y});
                }
            }

            if (secondList.isEmpty()) {
                return;
            }
            fillStep(secondList, res, mat, i + 1);
        }


    }
}
