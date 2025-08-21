package BinaryTree.BFS;

import java.util.*;

//Data Stored in Map
// col : [(row,node.val)]
// {
//   -1: [(1, 9)],
//    0: [(0, 3)],
//    1: [(1, 20)]
// }
public class leetcode_987 {
    public class TreeNode{
        int val;
        TreeNode node;
        TreeNode left;
        TreeNode right;

        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val,TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public class CustomPair{
        TreeNode node;
        int row;
        int col;

        public CustomPair(TreeNode node,int row, int col){
            this.node = node;
            this.row= row;
            this.col = col;
        }
    }


    public List<List<Integer>> verticalTraversal(TreeNode root) {
        return verticalOrder(root);
    }

    List<List<Integer>> verticalOrder(TreeNode root){
        if(root==null){
            return null;
        }

        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer,List<int[]>> mp = new TreeMap<>();

        Queue<CustomPair> queue = new LinkedList<>();
        queue.offer(new CustomPair(root,0,0));

        while(!queue.isEmpty()){
            CustomPair curr = queue.poll();
            TreeNode node = curr.node;
            int col = curr.col;
            int row = curr.row;

            if(node != null){
                mp.putIfAbsent(col,new ArrayList<>());
                mp.get(col).add(new int[]{row,node.val});

                queue.offer(new CustomPair(node.left,row+1,col-1));
                queue.offer(new CustomPair(node.right,row+1,col+1));
            }
        }

        for(List<int[]> group : mp.values()){
            group.sort((a,b) ->{
                if(a[0]!= b[0]) return Integer.compare(a[0],b[0]);
                return Integer.compare(a[1],b[1]);
            });

            List<Integer> colElement = new ArrayList<>();
            for(int[] entry : group){
                colElement.add(entry[1]);
            }
            ans.add(colElement);
        }

        return ans;

    }
}
