package Contests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class weekly_465 {
    public int[] minDifference(int n, int k) {
        List<Integer> allSplit = new ArrayList<>();
        back(n,1,k,new ArrayList<>(),allSplit);
        int [] arr = new int[list.size()];
        int m = 0;
        for(int ele : list){
            arr[m++] = ele;
        }
        return arr;
    }
    int minDiff = Integer.MAX_VALUE;
    List<Integer> list = new ArrayList<>();

    void back(int remain,int s, int k, List<Integer> curr,List<Integer> allSplit){
        if(k==0){
            if(remain==1){
                allSplit = new ArrayList<>(curr);
                int max = Collections.max(allSplit);
                int min = Collections.min(allSplit);
                int diff = max-min;

                if(diff<minDiff){
                    minDiff = diff;
                    list = new ArrayList<>(allSplit);
                }
            }

            return;
        }

        for(int i = s;i<= remain;i++){
            if(remain %i == 0){
                curr.add(i);
                back(remain/i,i,k-1,curr,allSplit);
                curr.remove(curr.size()-1);
            }
        }

    }

    List<Integer> getAllFact(int n,int k ){
        List<Integer> ans = new ArrayList<>();
        for(int i = 1;i<=n;i++){
            if(n%i==0){
                ans.add(i);
            }
        }
        return ans;
    }
}
