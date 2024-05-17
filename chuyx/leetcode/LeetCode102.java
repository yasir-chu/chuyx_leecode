package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 执行耗时:0 ms,击败了100.00% 的Java用户
 * 内存消耗:38.7 MB,击败了71.82% 的Java用户
 * @author yuxiang.chu
 * @date 2022/3/7 14:44
 **/
public class LeetCode102 {

    public static void main(String[] args) {
        Solution solution = new LeetCode102.Solution();
        // 3,9,20,null,null,15,7
//        TreeNode treeNode = new TreeNode(3, new TreeNode(9, null, null), new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)));
        TreeNode treeNode = new TreeNode();
        List<List<Integer>> lists = solution.levelOrder(treeNode);

    }


    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null){
                return result;
            }
            LinkedList<TreeNode> treeNodes = new LinkedList<>();
            treeNodes.add(root);
            while (!treeNodes.isEmpty()){
                List<Integer> item = new ArrayList<>();
                LinkedList<TreeNode> treeItem = new LinkedList<>();
                int size = treeNodes.size();
                for (int i = 0; i <size; i++) {
                    TreeNode pop = treeNodes.pop();
                    if (pop == null){
                        continue;
                    }else{
                        item.add(pop.val);
                    }
                    if (pop.left != null){
                        treeItem.add(pop.left);
                    }
                    if (pop.right != null){
                        treeItem.add(pop.right);
                    }
                }
                result.add(item);
                treeNodes = treeItem;
            }
            return result;
        }
    }

    public static class TreeNode {
        Integer val;
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
