package leecode;

//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//
//
//
// 示例 1:
//
//
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
//
//
// 示例 2:
//
//
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4
//
//
//
// 提示：
//
//
// 1 <= k <= nums.length <= 10⁴
// -10⁴ <= nums[i] <= 10⁴
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 1304 👎 0

import java.util.Arrays;

/**
 * @author yuxiang.chu
 */
public class LeetCode215 {
    public static void main(String[] args) {
        Solution solution = new LeetCode215().new Solution();
        int[] a = {7,8,5,1,3,2,5,9,6};
        System.out.println(solution.findKthLargest2(a, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 冒泡排序后获得  最菜算法
         */
        public int findKthLargest(int[] nums, int k) {
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < nums.length - 1; j++) {
                    if (nums[j] < nums[j+1]){
                        int temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;
                    }
                }
            }
            return nums[k - 1];
        }

        /**
         * 这玩意逗比冒泡牛X
         */
        public int findKthLargest2(int[] nums, int k) {
            Arrays.sort(nums);
            return nums[nums.length - 2];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}