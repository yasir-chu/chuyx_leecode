package leetcode1_100;

/**
 * @author yuxiang.chu
 * @date 2022/6/28 15:33
 **/
public class LeetCode98 {

    public static void main(String[] args) {
        Solution solution = new LeetCode98.Solution();
        TreeNode l1 = new TreeNode(2);
        TreeNode l2 = new TreeNode(1);
        TreeNode l3 = new TreeNode(3);
        TreeNode l4 = new TreeNode(50);
        TreeNode l5 = new TreeNode(100);
        TreeNode l6 = new TreeNode(130);
        TreeNode l7 = new TreeNode(160);
        TreeNode l8 = new TreeNode(20);
        TreeNode l9 = new TreeNode(55);
        TreeNode l10 = new TreeNode(75);
        TreeNode l11 = new TreeNode(110);
        TreeNode l12 = new TreeNode(119);
        TreeNode l13 = new TreeNode(135);
        TreeNode l14 = new TreeNode(150);
        TreeNode l15 = new TreeNode(200);
        l1.left = l2;
        l1.right = l3;
//        l2.left = l4;
//        l2.right = l5;
//        l3.left = l6;
//        l3.right = l7;
//        l4.left = l8;
//        l4.right = l9;
//        l5.left = l10;
//        l5.right = l11;
//        l6.left = l12;
//        l6.right=l13;
//        l7.left = l14;
//        l7.right = l15;
        System.out.println(solution.isValidBST(l1));
    }


    static class Solution {

        Integer pre = null;
        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (!isValidBST(root.left)) {
                return false;
            }
            if (pre != null && root.val <= pre) {
                return false;
            }
            pre = root.val;
            return isValidBST(root.right);

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
