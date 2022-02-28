package leecode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chuyx
 */
public class LeeCode94 {

    public static void main(String[] args) {
        Solution solution = new LeeCode94().new Solution();

    }

    class Solution {

        public List<Integer> result = new ArrayList<>();

        /**
         * 递归
         * @param root
         * @return
         */
        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null){
                return result;
            }
            inorderTraversal(root.left);
            result.add(root.val);
            inorderTraversal(root.right);
            return result;
        }


        /**
         * 迭代
         * 借助栈先进后出的特性来完成
         * @param root
         * @return
         */
        public List<Integer> inorderTraversal2(TreeNode root) {
            Deque<TreeNode> integers = new LinkedList<>();
            while (root != null || !integers.isEmpty()){
                while (root != null){
                    integers.push(root);
                    root = root.left;
                }
                root = integers.pop();
                result.add(root.val);
                root = root.right;
            }
            return result;

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
