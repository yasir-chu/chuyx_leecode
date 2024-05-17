package leetcode1_100;

/**
 * @author yuxiang.chu
 * @date 2022/3/28 15:54
 **/
public class LeetCode11 {

    public static void main(String[] args) {
        int[] a = {1,8,6,2,5,4,8,3,7};
        Solution solution = new Solution();
        System.out.println(solution.maxArea2(a));
    }

    static class Solution {
        /**
         * 暴力破解  leetCode 会超时
         * @param height
         * @return
         */
        public int maxArea(int[] height) {
            int result =0;
            for (int i = 0; i < height.length; i++) {
                for (int j = i + 1; j < height.length; j++) {
                    int minH = Math.min(height[i], height[j]);
                    int w =  j - i;
                    result = Math.max(minH * w, result);
                }
            }
            return result;
        }

        /**
         * 考虑 怎么会变大  短板 向内移 可能会变大   （短板变长了）
         * @param height
         * @return
         */
        public int maxArea2(int[] height) {
            int i = 0, j = height.length - 1, res = 0;
            while(i < j) {
                res = height[i] < height[j] ?
                        Math.max(res, (j - i) * height[i++]):
                        Math.max(res, (j - i) * height[j--]);
            }
            return res;
        }
    }
}
