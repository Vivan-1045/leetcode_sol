package Greedy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class leetcode_3397 {
    public int maxDistinctElements(int[] nums, int k) {
        return maxDisCnt(nums,k);
    }

    //Brute force
    int maxDist(int[] arr, int k){
        int n= arr.length;

        Set<Integer> st = new HashSet<>();
        Arrays.sort(arr);

        for(int i = 0;i<n;i++){
            int j = -k;
            while(j++<=k){
                if(!st.isEmpty() && st.contains(arr[i]+j)){
                    continue;
                }else{
                    st.add(arr[i]+j);
                    if(i+1<n && arr[i]==arr[i+1]){
                        i++;
                        continue;
                    }
                    break;
                }
            }
        }

        return st.size();
    }

    //Optimal
    int maxDisCnt(int[] arr, int k){
        Arrays.sort(arr);
        int PreMax = Integer.MIN_VALUE;
        int cnt=0;

        for(int ele : arr){
            int lb = ele-k;
            int ub = ele +k;

            if(PreMax<lb){
                PreMax = lb;
                cnt++;
            }else if(PreMax<ub){
                PreMax++;
                cnt++;
            }
        }

        return cnt;
    }
}
