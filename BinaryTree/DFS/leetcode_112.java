package BinaryTree.DFS;

public class leetcode_112 {
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

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return pathSum(root,targetSum);
    }
    boolean pathSum(TreeNode root,int reqSum){
        if(root==null){
            return false;
        }
        if(reqSum==root.val && root.left==null && root.right==null){
            return true;
        }
        return pathSum(root.left,reqSum-root.val)||pathSum(root.right,reqSum-root.val);
    }
}
