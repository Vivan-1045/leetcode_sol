package BinaryTree.DFS;

public class leetcode_1038 {
    class TreeNode{
        int val;
        leetcode_538.TreeNode left,right;

        TreeNode(int val, leetcode_538.TreeNode l, leetcode_538.TreeNode r){
            this.val = val;
            this.left = l;
            this.right = r;
        }
    }

    public leetcode_538.TreeNode convertBST(leetcode_538.TreeNode root) {
        solve(root);
        return root;
    }
    int sum = 0;

    void solve(leetcode_538.TreeNode root){
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
