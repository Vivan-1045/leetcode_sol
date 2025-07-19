package BinaryTree.DFS;

public class leetcode_124 {
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

    public int maxPathSum(TreeNode root) {
        maxPathSum1(root);
        return ans;
    }

    int ans = Integer.MIN_VALUE;
    int maxPathSum1(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftSum = maxPathSum1(root.left);
        int rightSum = maxPathSum1(root.right);

        leftSum = Math.max(0,leftSum);
        rightSum = Math.max(0,rightSum);


        int pathSum = leftSum + rightSum + root.val;
        ans = Math.max(ans,pathSum);

        return Math.max(leftSum,rightSum) + root.val;
    }
}
