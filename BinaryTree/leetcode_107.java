package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode_107 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val,TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        return level(root);
    }
    List<List<Integer>> level(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();
        if(root== null){
            return ans;
        }
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);

        while(!qu.isEmpty()){
            int queSize = qu.size();
            List<Integer> currVal = new ArrayList<>();
            for(int i = 0;i<queSize;i++){

                TreeNode currNode = qu.poll();
                currVal.add(currNode.val);

                if(currNode.left != null){
                    qu.offer(currNode.left);
                }

                if(currNode.right != null){
                    qu.offer(currNode.right);
                }
            }
            ans.add(currVal);
        }


        int n = ans.size();
        for (int i = 0; i < n / 2; i++) {
            List<Integer> temp = ans.get(i);
            ans.set(i, ans.get(n - 1 - i));
            ans.set(n - 1 - i, temp);
        }


        return ans;
    }
}
