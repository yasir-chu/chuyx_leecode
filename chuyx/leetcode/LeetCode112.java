package leetcode;


/**
 * @author yuxiang_chu
 * @date 2023/1/31 14:03
 */
public class LeetCode112 {

    public static void main(String[] args) {
        Solution solution = new LeetCode112.Solution();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        solution.hasPathSum(treeNode, 1);
    }

    static class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return false;
            }
            int sum = targetSum;
            TreeNode node = root;
            // 左节点还有  向左走  右节点还有  向右走
            return checkEnd(node, sum, node.left == null && node.right == null);
        }

        private boolean checkEnd(TreeNode node, int sum, boolean isEndNode) {
            if (node == null) {
                return sum == 0 && isEndNode;
            }
            boolean checkEndNode = node.left == null && node.right == null;
            boolean b = checkEnd(node.left, sum - node.val, checkEndNode);
            boolean b1 = checkEnd(node.right, sum - node.val, checkEndNode);
            return b || b1;
        }
    }

    public static class TreeNode {
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
