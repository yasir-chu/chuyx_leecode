package leetcode1_100;

import auxiliary.TreeNode;

/**
 * @author yuxiang.chu
 * @date 2022/6/28 11:25
 **/
public class LeetCode100 {

    public static void main(String[] args) {
        Solution solution = new LeetCode100.Solution();

    }


    static class Solution {
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

}
