package BinaryTree.DFS;

import java.util.Arrays;

public class leetcode_106 {
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return createTree(inorder,postorder);
    }

    TreeNode createTree(int[] inord,int [] post){
        if(post.length==0){
            return null;
        }

        int r = post[post.length-1];
        int idx = 0;

        for(int i = 0;i<inord.length;i++){
            if(inord[i]==r){
                idx = i;
            }
        }

        TreeNode rootNode = new TreeNode(r);

        rootNode.left = createTree(Arrays.copyOfRange(inord,0,idx),Arrays.copyOfRange(post,0,idx));
        rootNode.right = createTree(Arrays.copyOfRange(inord,idx+1,inord.length),Arrays.copyOfRange(post,idx,post.length-1));

        return rootNode;
    }
}
