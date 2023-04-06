package leecode;

/**
 * @author yuxiang_chu
 * @date 2023/4/6 16:16
 */
public class LeetCode111 {

    public static void main(String[] args) {

    }

    class Solution {

        // 5.65 23.55
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (root.left == null &&root.right == null) {
                return 1;
            }
            return Math.min(calculate(root.left, 1), calculate(root.right, 1));
        }

        public int calculate(TreeNode root, int nowDepth) {
            if (root == null) {
                return Integer.MAX_VALUE;
            }
            if (root.left == null && root.right == null) {
                return nowDepth + 1;
            }
            return Math.min(calculate(root.left, nowDepth + 1), calculate(root.right, nowDepth + 1));
        }


        // 39.05 31.59
        public int minDepth2(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (root.left == null &&root.right == null) {
                return 1;
            }
            int l = minDepth2(root.left);
            int r = minDepth2(root.right);
            if (root.left == null || root.right == null) {
                return l+r+1;
            }
            return Math.min(l, r) + 1;
        }


        public int minDepth3(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (root.left == null &&root.right == null) {
                return 1;
            }
            int l = minDepth2(root.left);
            int r = minDepth2(root.right);
            if (root.left == null || root.right == null) {
                return l+r+1;
            }
            return Math.min(l, r) + 1;
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
