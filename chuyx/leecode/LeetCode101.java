package leecode;

/**
 * @author yuxiang.chu
 * @date 2022/6/29 16:18
 **/
public class LeetCode101 {

    public static void main(String[] args) {
        Solution solution = new LeetCode101().new Solution();
        LeetCode101.TreeNode l1 = new LeetCode101.TreeNode(1);
        LeetCode101.TreeNode l2 = new LeetCode101.TreeNode(2);
        LeetCode101.TreeNode l3 = new LeetCode101.TreeNode(2);
        LeetCode101.TreeNode l4 = new LeetCode101.TreeNode(3);
        LeetCode101.TreeNode l5 = new LeetCode101.TreeNode(3);
        LeetCode101.TreeNode l6 = new LeetCode101.TreeNode(4);
        LeetCode101.TreeNode l7 = new LeetCode101.TreeNode(3);
        l1.left = l2;
        l1.right = l3;
        l2.left = l4;
        l2.right = l5;
        l3.left = l6;
        l3.right = l7;
        System.out.println(solution.isSymmetric(l1));
    }

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (root.left == null && root.right == null) {
                return true;
            }
            if (root.left == null || root.right == null) {
                return false;
            }
            return digui(root.left, root.right);
        }

        public boolean digui(TreeNode l, TreeNode r) {
            if (l == null && r==null) {
                return true;
            }
            if (l == null || r==null) {
                return false;
            }
            if (l.val != r.val) {
                return false;
            }
            return digui(l.left, r.right) && digui(l.right, r.left);
        }

    }

    public static class TreeNode {
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
