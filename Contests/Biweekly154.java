package Contests;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Biweekly154 {
    public static void main(String[] args) {
       int [] arr = {3,9,7};
       int k = 5;
       int []arr1 = {3,1,2};
//        System.out.println(minOp(arr,k));
        System.out.println(tripletXor(arr1));
    }
    public static int minOp(int[] arr, int k){
        int  sum =0;
        int count = 0;
        for(int num : arr){
            sum += num;
        }

        if(sum<k){
            return sum;
        }
        if (sum==k){
            return 0;
        }
        while (sum>k && sum %k !=0){
            sum -=1;
            count += 1;
        }

        return count;
    }
    public static int tripletXor(int[] arr){
        Set<Integer> res = new HashSet<>();

        int n = arr.length;
        int[] glarnetivo = arr;
        for(int i =0;i<n;i++){
            for(int j =i;j<n;j++){
                for(int k =j;k<n;k++){
                   int  xorTrip =glarnetivo[i]^glarnetivo[j]^glarnetivo[k];
                   res.add(xorTrip);
                }
            }
        }
        return res.size();
    }
}
