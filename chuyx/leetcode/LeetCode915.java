package leetcode;

/**
 * @author yuxiang_chu
 * @date 2022/10/24 14:40
 */
public class LeetCode915 {

    public static void main(String[] args) {
        Solution solution = new LeetCode915.Solution();
        int[] a= {5,0,3,8,6};
        System.out.println(solution.partitionDisjoint(a));
    }

    static class Solution {
        public int partitionDisjoint(int[] nums) {
            int result = 0;
            int leftMax = nums[0];
            int nowMax = nums[0];
            int rightMin = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nowMax < nums[i]) {
                    nowMax = nums[i];
                }
                if (rightMin > nums[i]) {
                    rightMin = nums[i];
                }
                if (leftMax > rightMin) {
                    rightMin  = Integer.MAX_VALUE;
                    result = i;
                    leftMax = nowMax;
                }

            }
            return result + 1;
        }


        public int partitionDisjoint2(int[] nums) {
            int result = 0,leftMax = nums[0],max = leftMax;
            for (int i = 1; i < nums.length; i++) {
                if (leftMax < nums[i]) {
                    leftMax = max;
                    result = i;
                }else{
                    max = Math.max(max, nums[i]);
                }
            }
            return result + 1;
        }
    }
}


