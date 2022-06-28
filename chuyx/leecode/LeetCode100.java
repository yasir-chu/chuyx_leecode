package leecode;

/**
 * @author yuxiang.chu
 * @date 2022/6/28 11:25
 **/
public class LeetCode100 {

    public static void main(String[] args) {
        Solution solution = new LeetCode100().new Solution();

    }


    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            // 参数检查
            if (p ==null && q==null) {
                return true;
            }
            if (p == null || q==null){
                return false;
            }
            // 判断中间是否一样
            if (p.val != q.val) {
                return false;
            }
            // 判断左边是否一样
            if (!isSameTree(p.left, q.left)) {
                return false;
            }
            // 判断右边是否一样
            if (!isSameTree(p.right, q.right)) {
                return false;
            }
            return true;

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
