package BinaryTree.DFS;

public class leetcode_129 {
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


    int sum = 0;
    public int sumNumbers(TreeNode root) {
        sumAllNumbers(root,0);
        return sum;
    }
    void sumAllNumbers(TreeNode root, int s){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            s = s*10 + root.val;
            sum += s;
            return;
        }

        sumAllNumbers(root.left,s*10+root.val);
        sumAllNumbers(root.right,s*10+root.val);

    }
}
