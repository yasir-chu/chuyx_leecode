package leetcode;

import auxiliary.TreeNode;
import leetcode1_100.LeetCode100;

/**
 * @author yuxiang_chu
 * @date 2022/10/26 16:56
 */
public class LeetCode437 {


    static class Solution {
        public int pathSum(TreeNode root, int targetSum) {
            if (root==null) {
                return 0;
            }
            return dfs(root, targetSum) + pathSum(root.left, targetSum) +pathSum(root.right, targetSum);
        }

        private int dfs(TreeNode root, int targetSum) {
            if (root==null) {
                return 0;
            }
            return (root.val == targetSum ? 1:0) + dfs(root.left, targetSum - root.val) +dfs(root.right, targetSum - root.val);
        }


    }
}
