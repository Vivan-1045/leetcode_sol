package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_101 {
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

    public boolean isSymmetric(TreeNode root) {
        return symmetric(root);
    }

    boolean symmetric(TreeNode root){
        if(root==null){
            return false;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root.left);
        que.offer(root.right);

        while(!que.isEmpty()){
            TreeNode LHS = que.poll();
            TreeNode RHS = que.poll();
            if(LHS == null && RHS == null){
                continue;
            }
            if(RHS==null||LHS==null){
                return false;
            }
            if((LHS.val != RHS.val) || (LHS.val != RHS.val)){
                return false;
            }

            que.offer(LHS.left);
            que.offer(RHS.right);
            que.offer(LHS.right);
            que.offer(RHS.left);
        }

        return true;
    }

}
