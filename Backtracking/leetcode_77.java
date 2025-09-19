package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class leetcode_77 {
    public List<List<Integer>> combine(int n, int k) {
        int[]arr = new int[n];
        for(int i=1;i<=n;i++){
            arr[i-1] = i;
        }
        getSubSeq(arr,0,k,new ArrayList<>());
        return ans;
    }

    List<List<Integer>> ans = new ArrayList<>();
    void getSubSeq(int[] arr, int idx,int k,List<Integer> ls){
        if(ls.size()==k){
            ans.add(new ArrayList<>(ls));
            return;
        }

        if(idx>=arr.length){
            return;
        }

        ls.add(arr[idx]);
        getSubSeq(arr,idx+1,k,ls);
        ls.remove(ls.size()-1);
        getSubSeq(arr,idx+1,k,ls);

    }
}
