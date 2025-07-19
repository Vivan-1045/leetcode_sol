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
        sumAllNumbers(root,"");
        return sum;
    }
    void sumAllNumbers(TreeNode root, String s){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            s += root.val;
            sum += Integer.parseInt(s);
            return;
        }

        sumAllNumbers(root.left,s+root.val);
        sumAllNumbers(root.right,s+root.val);

    }
}
