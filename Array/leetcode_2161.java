package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_2161 {
    public static void main(String[] args) {
        int[]arr = {9,12,5,10,14,3,10};
        int pivot = 10;
//        System.out.println(Arrays.toString(ans(arr,pivot)));
        System.out.println(Arrays.toString(solve(arr,pivot)));
    }
    public static int[] ans(int[] arr,int pivot){
        List<Integer> lowPivot = new ArrayList<>();
        List<Integer> equalPivot = new ArrayList<>();
        List<Integer> greaterPivot = new ArrayList<>();

        int[] res = new int[arr.length];
        for (int i =0;i<arr.length;i++){
            if (arr[i]<pivot){
                lowPivot.add(arr[i]);
            } else if (arr[i]>pivot) {
                greaterPivot.add(arr[i]);
            }else {
                equalPivot.add(arr[i]);
            }
        }

        int k = 0;
        for (int num : lowPivot){
            res[k++] = num;
        }
        for (int num: equalPivot){
            res[k++] = num;
        }
        for (int num : greaterPivot){
            res[k++] = num;
        }
        return res;
    }

    // approach 2
    public static int[] solve(int[]arr,int pivot){
        int[] res = new int[arr.length];
        int k = 0;
        for (int num : arr){
            if (num<pivot){
                res[k++] = num;
            }
        }
        for (int num : arr){
            if (num==pivot){
                res[k++]= num;
            }
        }
        for (int num : arr){
            if (num>pivot){
                res[k++] = num;
            }
        }
        return res;
    }
}
