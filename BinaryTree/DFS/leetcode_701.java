package BinaryTree.DFS;

public class leetcode_701 {
    class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val,TreeNode l, TreeNode r){
            this.val = val;
            this.left = l;
            this.right = r;
        }
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }
        solve(root,val);
        return root;
    }

    void solve(TreeNode root, int val){
        if(root==null){
            return;
        }
        if(root.left == null && root.right==null){
            if(root.val>val){
                root.left = new TreeNode(val);
                return;
            }else{
                root.right = new TreeNode(val);
                return;
            }
        }

        if(root.right==null){
            if(root.val<val){
                root.right = new TreeNode(val);
                return;
            }
        }

        if(root.left==null){
            if(root.val>val){
                root.left = new TreeNode(val);
                return;
            }
        }

        if(root.val<val){
            solve(root.right,val);
        }else{
            solve(root.left,val);
        }
    }
}
