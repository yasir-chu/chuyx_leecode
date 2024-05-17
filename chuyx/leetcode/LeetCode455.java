package leetcode;

import java.util.Arrays;

/**
 * @author yuxiang_chu
 * @date 2023/4/3 16:36
 */
public class LeetCode455 {


    public static void main(String[] args) {
            int[] a = {1,2,3};
        int[] b = {1,3};
        Solution solution = new LeetCode455.Solution();
        System.out.println(solution.findContentChildren(a, b));
    }
    static class Solution {

        // 100 92.89
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int i = g.length - 1;
            int j = s.length - 1;
            int count = 0;
            while (i >= 0 &&j >=0) {
                if (s[j] >= g[i]) {
                    count++;
                    j--;
                }
                i--;
            }
            return count;
        }

    }
}
