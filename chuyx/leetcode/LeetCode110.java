package leetcode;

/**
 * @author yuxiang.chu
 * @date 2022/6/29 17:02
 **/
public class LeetCode110 {

    public static void main(String[] args) {
        Solution solution = new LeetCode110.Solution();
    }


    static class Solution {
        public boolean isBalanced(TreeNode root) {
            return recr(root) != -1;
        }

        public int recr(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int left = recr(node.left);
            if (left == -1) {
                return -1;
            }
            int right = recr(node.right);
            if (right == -1) {
                return -1;
            }
            return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
        }

        public boolean isBalanced2(TreeNode root) {
            if (root == null) {
                return true;
            }
            return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced2(root.left) && isBalanced2(root.right);
        }


        private int depth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(depth(root.left), depth(root.right)) + 1;
        }


    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
