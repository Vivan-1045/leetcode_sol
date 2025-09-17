package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class leetcode_46 {
    public List<List<Integer>> permute(int[] nums) {
        getPerm(nums,0);
        return ans;
    }

    List<List<Integer>> ans = new ArrayList<>();
    void getPerm(int[] arr, int idx){
        if(idx>=arr.length){
            List<Integer> curr = new ArrayList<>();
            for(int ele : arr){
                curr.add(ele);
            }
            ans.add(curr);
            return;
        }

        for(int i = idx;i<arr.length;i++){
            swap(arr,i,idx);
            getPerm(arr,idx+1);
            swap(arr,idx,i);
        }
    }

    void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
