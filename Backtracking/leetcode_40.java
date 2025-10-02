package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum3(candidates,target,new ArrayList<>(),0);
        return res;
    }


    List<List<Integer>> res = new ArrayList<>();

    void combinationSum3(int[] cand,int tar,List<Integer> curr,int idx){
        if(tar==0){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i = idx;i<cand.length;i++){

            //Remove duplicate
            if(i>idx && cand[i]==cand[i-1]){
                continue;
            }

            if(cand[i]>tar){
                break;
            }


            curr.add(cand[i]);
            combinationSum3(cand,tar-cand[i],curr,i+1);
            curr.remove(curr.size()-1);
        }
    }
}
