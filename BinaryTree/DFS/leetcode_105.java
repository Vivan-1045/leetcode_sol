package BinaryTree.DFS;

import java.util.Arrays;

public class leetcode_105 {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return createTree(preorder,inorder);
    }

    TreeNode createTree(int[] pre, int [] inord){
        if(pre.length==0){
            return null;
        }

        int r = pre[0];
        int idx =0;

        for(int i =0;i<inord.length;i++){
            if(inord[i]==r){
                idx = i;
            }
        }
        TreeNode rootNode = new TreeNode(r);
        rootNode.left = createTree(Arrays.copyOfRange(pre,1,idx+1),Arrays.copyOfRange(inord,0,idx));
        rootNode.right = createTree(Arrays.copyOfRange(pre,idx+1,pre.length),Arrays.copyOfRange(inord,idx+1,inord.length));

        return rootNode;

    }
}
