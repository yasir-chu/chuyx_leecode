package leetcode1_100;

/**
 * @author yuxiang_chu
 * @since 2024/5/17 15:10
 */
public class LeetCode66 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {9};
        solution.plusOne(a);
    }


    static class Solution {
        /**
         * 耗时100
         * 内存 5.44
         */
        public int[] plusOne(int[] digits) {
            int carry = 0;
            for (int i = digits.length - 1; i >= 0; i--) {
                if (i == digits.length - 1) {
                    carry = digits[i] + 1 == 10 ? 1 : 0;
                    digits[i] = digits[i] + 1 == 10 ? 0 : digits[i] + 1;
                    continue;
                }
                if (digits[i] + carry== 10) {
                    digits[i] = 0;
                    carry = 1;
                } else {
                    digits[i] = digits[i] + carry;
                    carry = 0;
                }
            }
            if (carry == 1) {
                int[] res = new int[digits.length + 1];
                res[0] = 1;
                for (int i = 1; i < res.length; i++) {
                    res[i] = digits[i-1];
                }
                return res;
            }
            return digits;
        }
    }
}
