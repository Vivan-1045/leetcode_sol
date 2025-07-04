package BinaryTree.DFS;

public class leetcode_226 {
    class TreeNode {
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

    public TreeNode invertTree(TreeNode root) {
        return invert(root);
    }

    TreeNode invert(TreeNode root){
        if(root==null){
            return null;
        }

        TreeNode leftNode = invert(root.left);
        TreeNode rightNode = invert(root.right);

        root.left = rightNode;
        root.right = leftNode;

        return root;
    }
}
