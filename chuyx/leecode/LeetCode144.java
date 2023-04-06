package leecode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yuxiang_chu
 * @date 2023/4/6 16:43
 */
public class LeetCode144 {

    public static void main(String[] args) {

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

    class Solution {


        LinkedList<Integer> res = new LinkedList<>();

        // 100 7.57
        public List<Integer> preorderTraversal(TreeNode root) {
            if (root != null) {
                res.add(root.val);
                if (root.left != null) {
                    preorderTraversal(root.left);
                }
                if (root.right != null) {
                    preorderTraversal(root.right);
                }
            }
            return res;
        }


    }
}
