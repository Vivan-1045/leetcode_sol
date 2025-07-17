package BinaryTree.DFS;

public class leetcode_230 {
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;

         TreeNode() {
         }

         TreeNode(int val) {
             this.val = val;
         }

         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

    static int[] arr = new int[10001];
    static int i =0;
    public int kthSmallest(TreeNode root, int k) {
        i=0;
        if(root==null){
            return 0;
        }
        inorder(root);
        return arr[k-1];
    }

    void inorder(TreeNode root){
        if(root==null){
            return;
        }

        inorder(root.left);
        arr[i++] = root.val;
        inorder(root.right);
    }
}
