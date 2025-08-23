package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class leetcode_1382 {
    public class TreeNode{
        int val ;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
        TreeNode(int val,TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }

        List<Integer> list = new ArrayList<>();
        public TreeNode balanceBST(TreeNode root) {
            if(root==null){
                return null;
            }
            inorder(root);
            return balanceBST(0,list.size()-1);
        }

        void inorder(TreeNode root){
            if(root==null){
                return;
            }
            inorder(root.left);
            list.add(root.val);
            inorder(root.right);
        }

        TreeNode balanceBST(int l,int r){
            if(l>r){
                return null;
            }
            int m = l+(r-l)/2;
            TreeNode root = new TreeNode(list.get(m));
            root.left = balanceBST(l,m-1);
            root.right = balanceBST(m+1,r);

            return root;
        }
    }
}
