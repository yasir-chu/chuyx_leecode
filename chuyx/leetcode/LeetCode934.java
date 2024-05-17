package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author yuxiang_chu
 * @date 2022/10/25 10:02
 */
public class LeetCode934 {

    public static void main(String[] args) {
        Solution solution = new LeetCode934.Solution();
        int[][] a = {{0,1,0}, {0, 0, 0}, {0,0,1}};
        System.out.println(solution.shortestBridge(a));
    }

    static class Solution {
        int[][] condition = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[][] grid;
        Deque<int[]> boundary = new ArrayDeque<>();

        public int shortestBridge(int[][] grid) {
            int res = 0;
            this.grid = grid;
            loop:for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid.length; j++) {
                    if (grid[i][j] == 1) {
                        mackBoundary(i, j);
                        break loop;
                    }
                }
            }
            while (!boundary.isEmpty()) {
                int num = boundary.size();
                res++;
                for (int i = 0; i < num; i++) {
                    int[] ints = boundary.removeFirst();
                    for (int[] ints1 : condition) {
                        if (notOutOf(ints[0] + ints1[0], ints[1] + ints1[1]) && grid[ints[0] + ints1[0]][ints[1] + ints1[1]] == 0) {
                            int[] item = {ints[0] + ints1[0], ints[1]+ ints1[1]};
                            grid[ints[0] + ints1[0]][ints[1] + ints1[1]] = 2;
                            boundary.add(item);
                        }else if (notOutOf(ints[0] + ints1[0], ints[1] + ints1[1]) && grid[ints[0] + ints1[0]][ints[1] + ints1[1]] == 1) {
                            return res;
                        }
                    }
                }

            }
            return res;
        }

        private void mackBoundary(int i, int j) {
            if (!notOutOf(i,j) || grid[i][j] == 2) {
                return;
            }
            if (grid[i][j] == 0) {
                int[] item = {i,j};
                grid[i][j] =2;
                boundary.add(item);
                return;
            }
            grid[i][j] =2;
            for (int[] ints : condition) {
                mackBoundary(i + ints[0], j + ints[1]);
            }
        }

        private boolean notOutOf(int i, int j) {
            return i >= 0 && i < grid.length && j >= 0 && j < grid.length;
        }

    }
}
