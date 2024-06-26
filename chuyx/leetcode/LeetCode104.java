package leetcode;

/**
 * <p>给定一个二叉树，找出其最大深度。</p>
 * <p>二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。</p>
 * <p><strong>说明:</strong>&nbsp;叶子节点是指没有子节点的节点。</p>
 * <p><strong>示例：</strong><br>
 * 给定二叉树 <code>[3,9,20,null,null,15,7]</code>，</p>
 * <pre>    3
 *    / \
 *   9  20
 *     /  \
 *    15   7</pre>
 * <p>返回它的最大深度&nbsp;3 。</p>
 * <div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>广度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 1113</li><li>👎 0</li></div>
 * @author yuxiang.chu
 * @date 2022/2/18 10:47
 **/
public class LeetCode104 {

    public static void main(String[] args) {
        Solution solution = new LeetCode104.Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     */
    static class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null){
                return 1;
            }
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
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
