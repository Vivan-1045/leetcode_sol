package BinaryTree.DFS;

public class leetcode_1038 {
    class TreeNode{
        int val;
        TreeNode left,right;

        TreeNode(int val, TreeNode l, TreeNode r){
            this.val = val;
            this.left = l;
            this.right = r;
        }
    }

    public TreeNode convertBST(TreeNode root) {
        solve(root);
        return root;
    }
    int sum = 0;

    void solve(TreeNode root){
        if(root==null){
            return;
        }

        if(root.left==null && root.right == null){
            sum += root.val;
            root.val = sum;
            return;
        }

        solve(root.right);
        sum += root.val;
        root.val = sum;
        solve(root.left);
    }
}
