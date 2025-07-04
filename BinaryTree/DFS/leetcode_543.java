package BinaryTree.DFS;

public class leetcode_543 {
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

    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter-1;
    }

    int height(TreeNode root){
        if(root==null){
            return 0;
        }

        int leftH = height(root.left);
        int rightH = height(root.right);

        int dia = leftH + rightH + 1;
        diameter = Math.max(dia,diameter);

        return Math.max(leftH,rightH)+1;
    }

}
