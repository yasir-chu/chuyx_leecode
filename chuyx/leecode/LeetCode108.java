package leecode;

/**
 * @author yuxiang_chu
 * @date 2023/4/10 16:06
 */
public class LeetCode108 {

    public static void main(String[] args) {
        Solution solution = new LeetCode108().new Solution();
        int[] a = {-10, -3, 0, 5, 9};
        System.out.println(solution.sortedArrayToBST(a));
    }

    class Solution {
        // 100 58.52
        public TreeNode sortedArrayToBST(int[] nums) {
            return set(nums, nums.length / 2, 0, nums.length);
        }

        private TreeNode set(int[] nums, int center, int start, int end) {
            if (center < 0 || center > nums.length - 1) {
                return null;
            }
            TreeNode treeNode = new TreeNode(nums[center]);
            if (center - 1 >= start) {
                treeNode.left = set(nums, (center + start - 1) / 2, start, center - 1);
            }
            if (end >= center + 1) {
                treeNode.right = set(nums, (center + 1 + end) / 2, center + 1, end);
            }
            return treeNode;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
