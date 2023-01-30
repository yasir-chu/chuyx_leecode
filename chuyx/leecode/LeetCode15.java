package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yuxiang_chu
 * @date 2023/1/29 16:29
 */
public class LeetCode15 {

    public static void main(String[] args) {
        Solution solution = new LeetCode15().new Solution();
        int[] a = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = solution.threeSum(a);
        System.out.println(lists);


    }

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums.length < 2) {
                return result;
            }
            Arrays.sort(nums);

            for (int i = 0; i < nums.length - 2; i++) {
                if (nums[i] > 0) {
                    break;
                }
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int l = i + 1;
                int r = nums.length - 1;
                while (l < r) {
                    int sum = nums[i] + nums[l] + nums[r];
                    if (sum > 0) {
                        while (l < r && nums[r] == nums[--r]) {
                        }
                    } else if (sum < 0) {
                        while (l < r && nums[l] == nums[++l]) {
                        }
                    } else {
                        result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[r] == nums[--r]) {
                        }
                        while (l < r && nums[l] == nums[++l]) {
                        }

                    }
                }
            }
            return result;
        }
    }

}

