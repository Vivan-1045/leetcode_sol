package Prefix_Sum;

import java.util.HashMap;
import java.util.Map;

public class leetcode_525 {
    public static void main(String[] args) {
         int[]arr = {0,1,1,1,1,1,0,0,0};
        System.out.println(maxlength(arr));
    }
    public static int maxlength(int[] arr){
        int n = 0;
        if(n==1){
            return 0;
        }
        int ans = 0;
        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0,-1);

        int currSum=0;
        for(int i = 0;i<n;i++){
            if(arr[i]==0){
                currSum--;
            }else{
                currSum++;
            }

            if(mp.containsKey(currSum)){
                ans = Math.max(ans,i-mp.get(currSum));
            }else{
                mp.put(currSum,i);
            }
        }

        return ans;
    }
}
