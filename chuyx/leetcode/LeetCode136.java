package leetcode;

import java.util.Arrays;

/**
 * @author yuxiang_chu
 * @date 2023/3/23 16:46
 */
public class LeetCode136 {

    public static void main(String[] args) {
        Solution solution = new LeetCode136.Solution();
        int[] a = {4,1,2,1,2};
        System.out.println(solution.singleNumber(a));
    }

    static class Solution {
        public int singleNumber(int[] nums) {
            int[] ints = Arrays.stream(nums).sorted().toArray();
            for (int i = 0; i < ints.length - 1; i = i+2) {
                if (ints[i] != ints[i+1]) {
                    return ints[i];
                }
            }
            return ints[ints.length - 1];

        }

        /**
         * 使用异或运算
         */
        public int singleNumber2(int[] nums) {
            int ans = nums[0];
            if (nums.length > 1) {
                for (int i = 1; i < nums.length; i++) {
                    ans = ans ^ nums[i];
                }
            }
            return ans;
        }

    }
}
