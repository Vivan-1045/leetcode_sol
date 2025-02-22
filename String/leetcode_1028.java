package String;

import javax.swing.tree.TreeNode;

public class leetcode_1028 {

    private static int n;
    public static TreeNode helper(String s, int idx , int depth){
        if (idx>=n){
            return null;
        }

        int j = idx;
        while (j<n && s.charAt(j)=='-'){
            j++;
        }
        int dashCount = j-idx;

        if (depth != dashCount){
            return null;
        }
        idx += dashCount;
        int value = 0;

        while (idx<n && Character.isDigit(s.charAt(idx))){
            value = value * 10 + s.charAt(idx)-'0';
            idx++;
        }

        TreeNode root = new TreeNode(value);
        root.left = helper(s,idx,depth+1);
        root.right = helper(s,idx,depth+1);

        return root;

    }
    public TreeNode recoverTree(String s){
        n = s.length();
        int i = 0;
        helper(s,i,0);
    }
}
