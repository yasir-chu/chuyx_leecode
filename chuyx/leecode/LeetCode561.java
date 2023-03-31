package leecode;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author yuxiang_chu
 * @date 2023/3/31 15:32
 */
public class LeetCode561 {

    public static void main(String[] args) {
        Solution solution = new LeetCode561().new Solution();
        int[] a = {1,4,2,3};
        System.out.println(solution.arrayPairSum2(a));
    }

    class Solution {
        // 5.46 5.05
        public int arrayPairSum(int[] nums) {
            nums = Arrays.stream(nums).sorted().toArray();
            int count = 0;
            for (int i = 0; i < nums.length; i = i + 2) {
                count += Math.min(nums[i], nums[i+1]);
            }
            return count;
        }



        // 5.46 63.94
        public int arrayPairSum2(int[] nums) {
            maopao(nums);
            int count = 0;
            for (int i = 0; i < nums.length; i = i + 2) {
                count += Math.min(nums[i], nums[i+1]);
            }
            return count;
        }

        // 冒泡
        private void maopao(int[] nums) {
            for (int i = 0; i < nums.length -1; i++) {
                for (int i1 = i+1; i1 < nums.length; i1++) {
                    if (nums[i] >= nums[i1]) {
                        int item = nums[i];
                        nums[i] = nums[i1];
                        nums[i1] = item;
                    }
                }
            }
        }
    }


}
