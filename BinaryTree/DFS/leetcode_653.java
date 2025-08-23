package BinaryTree.DFS;
import java.util.ArrayList;
import java.util.List;

public class leetcode_653 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val= val;
            this.left= left;
            this.right= right;
        }

        public boolean findTarget(TreeNode root, int k) {
            if(root==null){
                return false;
            }
            inorder(root);
            return twoSum(list,k);
        }

        List<Integer> list = new ArrayList<>();

        void inorder(TreeNode root){
            if(root==null){
                return;
            }

            inorder(root.left);
            list.add(root.val);
            inorder(root.right);
        }

        boolean twoSum(List<Integer> list,int k){
            for(int i = 0;i<list.size();i++){
                for(int j = i+1;j<list.size();j++){
                    if(list.get(i)+list.get(j)==k){
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
