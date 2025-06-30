package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }


    public Node connect(Node root) {
        return nullConnect(root);
    }
    Node nullConnect(Node root){
        if(root== null){
            return root;
        }
        Queue<Node> que = new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty()){
            int queSize = que.size();

            for(int i = 0;i<queSize;i++){
                Node currNode = que.poll();

                if(i<queSize-1){
                    currNode.next = que.peek();
                }else{
                    currNode.next = null;
                }

                if(currNode.left != null){
                    que.offer(currNode.left);
                }
                if(currNode.right != null){
                    que.offer(currNode.right);
                }

            }
        }
        return root;
    }
}
