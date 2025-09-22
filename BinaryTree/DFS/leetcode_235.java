package BinaryTree.DFS;


public class leetcode_235 {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findAnces(root,p,q);
    }
    TreeNode findAnces(TreeNode root,TreeNode p, TreeNode q){
        if(root==null){
            return null;
        }

        if(root == p || root == q){
            return root;
        }
        //Check left side
        TreeNode leftNode = findAnces(root.left,p,q);
        //Check right side
        TreeNode rightNode = findAnces(root.right,p,q);

        if(leftNode != null && rightNode != null){
            return root;
        }

        if(leftNode != null){
            return leftNode;
        }

        return rightNode;
    }
}
