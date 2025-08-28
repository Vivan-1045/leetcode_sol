package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_334 {
    public static void main(String[] args) {
       int[]arr = {1,5,0,4,1,3};
        System.out.println(trip(arr));
    }

    //TLE 77/85
    public static boolean increasingTrip(int[] arr){
        int n = arr.length;
        if(n<3){
            return false;
        }

        for(int i = 0;i<n;i++){
            List<Integer> list = new ArrayList<>(Arrays.asList(arr[i]));
            int k = 0;
            for(int j = i+1;j<n;j++){
                if(list.size()!=2 && arr[j]>list.get(k)){
                    list.add(arr[j]);
                    k++;
                }else if(list.size()==2 && arr[j]<list.get(k) && arr[j]>list.get(k-1)){
                    list.set(k,arr[j]);
                }else if(arr[j]>list.get(k)){
                    list.add(arr[j]);
                    k++;
                }

                if(list.size()==3){
                    return true;
                }
            }
        }

        return false;
    }
    
    //Optimal
    public static boolean trip(int[] arr){
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;

        int n = arr.length;

        for (int j : arr) {
            if (j <= a) {
                a = j;
            } else if (j <= b) {
                b = j;
            } else {
                return true;
            }
        }

        return false;
    }
}
