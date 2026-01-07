package BinaryTree.DFS;

public class leetcode_1339 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(){};
        TreeNode(int val){
            this.val =val;
        };
        TreeNode(int val,TreeNode l, TreeNode r){
            this.val=val;
            this.left= l;
            this.right = r;
        }
    }
    int maxSum = 0;
    int M = 1000000007;
    long res = 0;

    public int maxProduct(TreeNode root) {
        int sum = (int)totalSum(root);
        maxSum = sum;

        maxPro(root);
        return (int)(res%M);

    }

    long totalSum(TreeNode root){

        if(root==null){
            return 0;
        }
        long a = totalSum(root.left);
        long b = totalSum(root.right);

        return a+b+root.val;
    }


    long maxPro(TreeNode root){
        if(root==null){
            return 0;
        }

        long left = maxPro(root.left);
        long right = maxPro(root.right);

        long currSubtreeSum = left+right+root.val;

        long currPro = (maxSum-currSubtreeSum)*currSubtreeSum;
        res = Math.max(res,currPro);

        return currSubtreeSum;
    }
}
