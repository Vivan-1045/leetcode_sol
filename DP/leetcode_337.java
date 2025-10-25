package DP;

import java.util.HashMap;
import java.util.Map;

public class leetcode_337 {
    class TreeNode{
        int val;
        TreeNode left,right;

        TreeNode(int val,TreeNode l, TreeNode r){
            this.val = val;
            this.left = l;
            this.right = r;
        }
    }

    Map<TreeNode,Integer> memo;
    public int rob(TreeNode root) {
        memo = new HashMap<>();
        return getSum(root);
    }

    int getSum(TreeNode root){
        if(root==null){
            return 0;
        }

        if(memo.containsKey(root)){
            return memo.get(root);
        }

        int add = root.val
                + (root.left == null ? 0 : getSum(root.left.left) + getSum(root.left.right))
                + (root.right == null ? 0 : getSum(root.right.left) + getSum(root.right.right));

        int skip = getSum(root.left) + getSum(root.right);

        memo.put(root,Math.max(add,skip));
        return memo.get(root);
    }
}
