package BinaryTree.SegmentTree;

import java.util.HashMap;
import java.util.Map;

public class leetcode_3721 {
    class Seg{
        int n;
        int[]segMin;
        int[] segMax;
        int[]lazy;

        Seg(int n){
            this.n = n;
            segMin = new int[4*n];
            segMax = new int[4*n];
            lazy = new int[4*n];
        }

        void push(int node,int l,int r){
            if(lazy[node] != 0){
                segMin[node] += lazy[node];
                segMax[node] += lazy[node];

                if(l != r){
                    lazy[2*node] += lazy[node];
                    lazy[2*node+1] += lazy[node];
                }
                lazy[node]=0;
            }
        }

        void update(int node , int l, int r,int ql, int qr,int val){
            push(node,l,r);

            if(r<ql||l>qr){
                return;
            }

            if(ql<=l && r<= qr){
                lazy[node] += val;
                push(node,l,r);
                return;
            }

            int m = l + (r-l)/2;
            update(2*node,l,m,ql,qr,val);
            update(2*node+1,m+1,r,ql,qr,val);

            segMin[node] = Math.min(segMin[2*node],segMin[2*node+1]);
            segMax[node] = Math.max(segMax[2*node],segMax[2*node+1]);
        }

        int findFirstZero(int node, int l, int r){
            push(node,l,r);

            if(segMin[node] > 0 || segMax[node]<0){
                return -1;
            }

            if(l==r){
                return l;
            }

            int m = l + (r-l)/2;
            push(2*node,l,m);
            push(2*node+1,m+1,r);

            int left = findFirstZero(2*node,l,m);
            if(left != -1){
                return left;
            }
            return findFirstZero(2*node+1,m+1,r);
        }
    }



    public int longestBalanced(int[] nums) {
        return solve(nums);
    }

    int solve(int[]arr){
        int n = arr.length;

        Seg sg = new Seg(n);

        int res = 0;

        Map<Integer,Integer> mp = new HashMap<>();

        for(int i = 0;i<n;i++){
            int val = (arr[i]%2==0)?1:-1;

            int pIdx = -1;
            if(mp.containsKey(arr[i])){
                pIdx = mp.get(arr[i]);
            }

            if(pIdx != -1){
                sg.update(1,0,n-1,0,pIdx,-val);
            }

            sg.update(1,0,n-1,0,i,val);

            int k = sg.findFirstZero(1,0,n-1);

            if(k != -1 && k<=i){
                res = Math.max(res,i-k+1);
            }

            mp.put(arr[i],i);

        }
        return res;
    }
}
