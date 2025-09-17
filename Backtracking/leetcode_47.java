package Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leetcode_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        getPerm(nums,0);
        List<List<Integer>> res = new ArrayList<>(ans);
        return res;
    }

    Set<List<Integer>> ans = new HashSet<>();
    void getPerm(int[] arr, int idx){
        if(idx>=arr.length){
            List<Integer> curr = new ArrayList<>();
            for(int ele:arr){
                curr.add(ele);
            }
            ans.add(curr);
        }

        for(int i = idx;i<arr.length;i++){
            swap(arr,i,idx);
            getPerm(arr,idx+1);
            swap(arr,idx,i);
        }
    }

    void swap(int[]arr, int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
