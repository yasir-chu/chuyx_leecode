package practice;

/**
 * 二叉树遍历
 *
 * @author yuxiang_chu
 * @date 2023/4/3 10:28
 */
public class TreeErgodicPractice {




    static class TreeNode{
        public int data;
        public TreeNode leftChild;
        public TreeNode rightChild;

        /**
         * 中序遍历
         * @param node
         */
        public static void inOrderTraversal(TreeNode node){
            if(node == null){
                return;
            }else{
                inOrderTraversal(node.leftChild);
                System.out.println(node.data);
                inOrderTraversal(node.rightChild);
            }
        }

    }

}
