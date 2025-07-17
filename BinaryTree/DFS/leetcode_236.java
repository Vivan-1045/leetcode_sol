package BinaryTree.DFS;

public class leetcode_236 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lowestCommonAnce(root,p,q);
    }

    TreeNode lowestCommonAnce(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return null;
        }

        if(root==p || root ==q){
            return root;
        }

        TreeNode left = lowestCommonAnce(root.left,p,q);
        TreeNode right = lowestCommonAnce(root.right,p,q);

        if(left != null && right != null){
            return root;
        }

        return left==null?right:left;
    }
}
