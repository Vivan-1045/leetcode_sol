package BinaryTree.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_993 {
    class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        return cousins(root,x,y);
    }

    boolean cousins(TreeNode root,int x, int y){

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty()){
            int queSize = que.size();

            boolean n1 = false;
            boolean n2 = false;

            for(int i = 0;i<queSize;i++){
                TreeNode currNode = que.poll();
                if(currNode.val==x){
                    n1 = true;
                }
                if(currNode.val==y){
                    n2 = true;
                }

                if(currNode.left != null && currNode.right != null){
                    if((currNode.left.val==x && currNode.right.val == y) || (currNode.right.val==x && currNode.left.val == y)){
                        return false;
                    }
                }
                if(currNode.left != null){
                    que.offer(currNode.left);
                }
                if(currNode.right != null){
                    que.offer(currNode.right);
                }
            }

            if(n1==true && n2 == true){
                return true;
            }
        }
        return false;
    }
}
