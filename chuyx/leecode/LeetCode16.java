package leecode;

import java.util.Arrays;

/**
 * @author yuxiang_chu
 * @date 2023/1/30 16:25
 */
public class LeetCode16 {

    public static void main(String[] args) {
        Solution solution = new LeetCode16().new Solution();
        int[] a = {4,0,5,-5,3,3,0,-4,-5};
        System.out.println(solution.threeSumCloses3(a, -2));
    }

    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            int res = target;
            Integer nowMin = null;
            for (int i = 0; i < nums.length-2; i++) {
                for (int j = i+1; j < nums.length-1; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        int sum = nums[i] + nums[j] + nums[k];
                        if (sum == target) {
                            return target;
                        }
                        int len = Math.abs(sum - target);
                        if (nowMin == null || len < nowMin) {
                            nowMin = len;
                            res = sum;
                        }

                    }
                }
            }
            return res;
        }

        public int threeSumClosest2(int[] nums, int target) {
            Arrays.sort(nums);
            int res = target;
            Integer nowMin = null;
            for (int i = 0; i < nums.length - 2; i++) {
                int l = i + 1;
                int r = nums.length - 1;
                while (l < r) {
                    int sum = nums[i] + nums[l] + nums[r];
                    if (sum == target) {
                        return target;
                    }else if (nowMin == null || Math.abs(sum - target) < nowMin) {
                        nowMin =  Math.abs(sum - target);
                        res = sum;
                    }
                    if (sum > target) {
                        while (l < r && nums[r] == nums[--r]) {

                        }
                    }else {
                        while (l < r && nums[l] == nums[++l]) {

                        }
                    }

                }
            }

            return res;
        }



        public int threeSumCloses3(int[] nums, int target) {
            Arrays.sort(nums);
            int res = target;
            Integer nowMin = null;
            for (int i = 0; i < nums.length - 2; i++) {
                int l = i + 1;
                int r = nums.length - 1;
                while (l < r) {
                    int sum = nums[i] + nums[l] + nums[r];
                    if (sum == target) {
                        return sum;
                    } else {
                        int len = sum - target;
                        if (nowMin == null || Math.abs(len) < nowMin) {
                            nowMin = Math.abs(len);
                            res = sum;
                        }
                        if (len > 0) {
                            r--;
                        }else {
                            l++;
                        }
                    }


                }
            }
            return res;
        }
    }
}


