package BinaryTree.DFS;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class leetcode_109 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val= val;
            this.left= left;
            this.right = right;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
        }

        return constructBST(list,0,list.size()-1);
    }

    TreeNode constructBST(List<Integer> list, int l,int r){
        if(l>r){
            return null;
        }
        int m = l + (r-l)/2;
        TreeNode node = new TreeNode(list.get(m));
        node.left = constructBST(list,l,m-1);
        node.right = constructBST(list,m+1,r);

        return node;
    }

}
