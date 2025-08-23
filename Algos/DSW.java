package Algos;

public class DSW {
    public class TreeNode{
        int val ;
        TreeNode left;
        TreeNode right;
         TreeNode(int val){
             this.val= val;
         }

         TreeNode(int val, TreeNode left ,TreeNode right){
             this.val= val;
             this.left = left;
             this.right = right;
         }


        public TreeNode balanceBST(TreeNode root) {
            TreeNode vine = vine(root);
            int n = countNode(vine.right);
            int m = (int)Math.pow(2,Math.floor(Math.log(n+1)/Math.log(2)))-1;

            reCreateBST(vine,n-m);
            while(m>1){
                m /= 2;
                reCreateBST(vine,m);
            }

            return vine.right;
        }

        // Right rotation
        TreeNode rightRotate(TreeNode parent){
            TreeNode child = parent.left;
            parent.left = child.right;
            child.right = parent;
            return child;
        }

        //left rotation
        TreeNode leftRotate(TreeNode parent){
            TreeNode child = parent.right;
            parent.right = child.left;
            child.left = parent;
            return child;
        }

        //Create a backbone (vine) of DSW
        TreeNode vine(TreeNode root){
            TreeNode vineRoot = new TreeNode(0);
            vineRoot.right = root;
            TreeNode tail = vineRoot;
            TreeNode rest = root;

            while(rest != null){
                if(rest.left != null){
                    TreeNode rotated = rightRotate(rest);
                    tail.right = rotated;
                    rest = rotated;
                }else{
                    tail = rest;
                    rest = rest.right;
                }
            }

            return vineRoot;
        }

        //Node Count
        int countNode(TreeNode root){
            int nodeCount = 0;

            while(root!= null){
                nodeCount++;
                root = root.right;
            }

            return nodeCount;
        }

        //Finally create a Balanced BST
        void reCreateBST(TreeNode root, int count){
            TreeNode parent = root;
            for(int i = 0;i<count;i++){
                TreeNode child = parent.right;
                if(child==null || child.right==null) break;

                TreeNode rotated = leftRotate(child);

                parent.right = rotated;
                parent = rotated;
            }
        }

    }
}
