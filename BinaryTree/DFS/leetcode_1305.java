package BinaryTree.DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class leetcode_1305 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<Integer> ans = new ArrayList<>();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        allElement1(root1);
        allElement2(root2);
        Collections.sort(ans);
        return ans;
    }

    void allElement1(TreeNode r1){
        if(r1==null){
            return;
        }
        allElement1(r1.left);
        ans.add(r1.val);
        allElement1(r1.right);
    }

    void allElement2(TreeNode r2){
        if(r2==null){
            return;
        }
        allElement2(r2.left);
        ans.add(r2.val);
        allElement2(r2.right);
    }
}
