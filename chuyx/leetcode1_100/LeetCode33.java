package leetcode1_100;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使
 * k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标
 * ,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：nums = [1], target = 0
 * 输出：-1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * nums 中的每个值都 独一无二
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -10^4 <= target <= 10^4
 * <p>
 * <p>
 * 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？
 * Related Topics 数组 二分查找 👍 1825 👎 0
 *
 * @author yuxiang.chu
 * @date 2022/2/11 9:47
 **/
public class LeetCode33 {

    public static void main(String[] args) {
        Solution solution = new LeetCode33.Solution();
        int[] arr = {1};
        System.out.println(solution.search(arr, 2));
    }

    static class Solution {
        public int search(int[] nums, int target) {
            if (nums == null) {
                return -1;
            }
            int center = nums.length - 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < nums[i - 1]) {
                    center = i - 1;
                    break;
                }
            }

            if (nums[0] > target) {
                return findNum(nums, center + 1, nums.length - 1, target);
            }
            return findNum(nums, 0, center, target);


        }

        // 二分查找
        public int findNum(int[] nums, int l, int r, int target) {
            while (l <= r ) {
                int mid = l + ((r - l) >> 2);
                if (nums[mid] >= target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return l<nums.length && nums[l] == target ? l : -1;
        }
    }
}
