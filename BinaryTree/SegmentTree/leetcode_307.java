package BinaryTree.SegmentTree;

public class leetcode_307 {
    int[] tree;
    int n;

    public void buildTree(int idx,int l,int r,int [] arr){
        if(l==r){
            tree[idx] = arr[l];
            return;
        }
        int m = l + (r-l)/2;
        buildTree(2*idx+1,l,m,arr);
        buildTree(2*idx+2,m+1,r,arr);
        tree[idx] = tree[2*idx+1]+tree[2*idx+2];
    }

    public leetcode_307(int[] nums) {
        n = nums.length;
        tree = new int[4*n];
        buildTree(0,0,n-1,nums);
    }

    public void update(int index, int val) {
        updateTree(index,val,0,0,n-1);
    }

    void updateTree(int idx, int val,int i,int l,int r){
        if(l==r){
            tree[i]=val;
            return;
        }
        int m = l + (r-l)/2;
        if(idx<=m){
            updateTree(idx,val,2*i+1,l,m);
        }else{
            updateTree(idx,val,2*i+2,m+1,r);
        }
        tree[i] = tree[2*i+2]+tree[2*i+1];
    }

    public int sumRange(int s, int e) {
        return query(s,e,0,0,n-1);
    }

    int query(int s , int e, int i,int l,int r){
        if(r<s || e<l){
            return 0;
        }else if(l>=s && r<=e){
            return tree[i];
        }else{
            int m = l + (r-l)/2;
            return query(s,e,2*i+1,l,m)+query(s,e,2*i+2,m+1,r);
        }
    }
}
