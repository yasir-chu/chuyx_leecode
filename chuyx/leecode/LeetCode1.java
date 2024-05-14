package leecode;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yuxiang_chu
 * @since 2024/5/13 15:11
 */
public class LeetCode1 {

    public static void main(String[] args) {

    }


    class Solution {

        /**
         * 最简单的 暴力计算
         * 内存 85.39
         * 运行速度 7.62
         */
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i+1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
            return new int[]{};
        }


        /**
         * 内存 71.7
         * 运行速度 47.49
         */
        public int[] twoSum2(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                map.put(target - nums[i], i);
            }
            for (int i = 0; i < nums.length; i++) {
                if (map.get(nums[i]) != i && map.containsKey(nums[i])) {
                    return new int[]{map.get(nums[i]), i};
                }
            }
            return new int[]{};
        }
    }
}
