package Two_Pointer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class leetcode_1695 {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,2,2,2};
        System.out.println(maxUniqueSubArraySum(arr));
    }
    public static int maxUniqueSubArraySum(int[] arr){
        int n = arr.length;
        if(n==1){
            return arr[0];
        }
        if(n==2){
            return Math.max(arr[0], arr[1]);
        }
        int ans = Integer.MIN_VALUE;

        for(int i = 0;i<n;i++){
            Map<Integer,Integer> mp = new HashMap<>();
            mp.put(arr[i],i);
            int currSum = arr[i];

            for(int j = i+1;j<n;j++){

                if(!mp.isEmpty() && mp.containsKey(arr[j])){
                    break;
                }else{
                    mp.put(arr[j],j);
                    currSum += arr[j];
                }
            }
            mp.clear();
            ans = Math.max(ans,currSum);
        }

        return ans;
    }


    //USing Sliding Window
    int maxSum(int[] arr){
        int n = arr.length;
        int currSum = 0;
        Set<Integer> st = new HashSet<>();
        int l = 0;
        int ans = Integer.MIN_VALUE;
        int i = 0;
        while (i<n){
            if (!st.contains(arr[i])){
                currSum += arr[i];
                ans = Math.max(ans,currSum);
                st.add(arr[i]);
                i++;
            }else{
                currSum -= arr[l];
                st.remove(arr[l++]);
            }
        }

        return ans;
    }
}
