package unCategorisedCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leetcode_2342 {
    public static void main(String[] args) {
        int [] arr = {10,12,19,14};
        System.out.println(maxSumAfterOpr(arr));
    }
    public static int digitSum(int n){
        if (n<10){
            return n;
        }
        else {
            return n%10 + digitSum(n/10);
        }
    }

    //Using HashMap
    public static int getMaxSum(int []arr){
        int sum = 0;
        int ans = -1;
        Map<Integer,Integer> mp = new HashMap<>();
        for (int i =0;i<arr.length;i++){
            int digit = digitSum(arr[i]);
            if (mp.containsKey(digit)){
                ans = Math.max(ans,arr[i]+mp.get(digit));
                mp.put(digit,Math.max(arr[i],mp.get(digit)));
            }
            mp.put(digit, arr[i]);
        }
        return ans;
    }



    //Using Array
    public static int maxSumAfterOpr(int [] arr){
        int ans = -1;
        int [] arr1 = new int[82];
        Arrays.fill(arr1,0);

        for (int i =0;i<arr.length;i++){
            int idx = digitSum(arr[i]);
            if (arr1[idx]>0){
                ans = Math.max(ans,arr[i]+arr1[idx]);
            }
            arr1[idx] = Math.max(arr[i],arr1[idx]);
        }
       return ans;
    }
}
