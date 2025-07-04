package BinaryTree.BFS;

import java.util.*;

public class leetcode_103 {
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {this.val = val;
           this.left = left;
           this.right = right;
       }
    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        return zigzagLevel(root);
    }
    List<List<Integer>> zigzagLevel(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        int k = 0;
        while(!que.isEmpty()){
            int size = que.size();
            List<Integer> currList = new ArrayList<>();

            for(int i = 0;i<size;i++){
                TreeNode currNode = que.poll();
                currList.add(currNode.val);

                if(currNode.left!= null){
                    que.offer(currNode.left);
                }
                if(currNode.right != null){
                    que.offer(currNode.right);
                }
            }
            if((k++)%2 !=0){
                Collections.reverse(currList);
            }
            ans.add(currList);

        }
        return ans;
    }
}
