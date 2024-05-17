package leetcode;

import java.util.Arrays;

/**
 * @author yuxiang_chu
 * @date 2022/9/26 14:07
 */
public class Test1719 {
    public static void main(String[] args) {
        int[] a = {2,3};
        Solution solution = new Test1719.Solution();
        for (int i : solution.missingTwo(a)) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    static class Solution {
        /**
         * 排序时间复杂度On
         * @param nums
         * @return
         */
        public int[] missingTwo(int[] nums) {
            nums = Arrays.stream(nums).sorted().toArray();
            int compare = 1;
            int n = 0,i=0;
            int[] res = new int[2];
            do {
                if (i < nums.length && nums[i] == compare) {
                    i++;
                    compare++;
                    continue;
                }
                res[n] = compare;
                compare++;
                n++;
            }while (n != 2);
            return res;
        }

        /**
         * 数学思维：一共有nums+2 个数，有两个数丢了，计算0 到 nums+2 之和 sum，然后计算二元一次方程
         *
         * @param nums
         * @return
         */
        public int[] missingTwo2(int[] nums) {
            return new int[]{1,2};

        }

        public int[] missingTwo3(int[] nums) {
            // todo 位运算 还不会
            return new int[]{1,2};
        }
    }
}
