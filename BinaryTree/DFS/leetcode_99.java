package BinaryTree.DFS;

public class leetcode_99 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val = val;
            this.left= left;
            this.right = right;
        }

        TreeNode first=null;
        TreeNode second=null;
        TreeNode prev=null;
        public void recoverTree(TreeNode root) {
            iot(root);

            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }

        void iot(TreeNode root){
            if(root==null){
                return;
            }

            iot(root.left);

            if(prev != null && prev.val>root.val){
                if(first==null){
                    first = prev;
                }
                second = root;
            }
            prev = root;
            iot(root.right);
        }
    }
}
