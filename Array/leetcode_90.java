package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_90 {
    public static void main(String[] args) {
        int[] arr = {1,2,2,1};
        System.out.println(UniqueSubset(arr));

    }
    public static List<List<Integer>> UniqueSubset(int[] arr){
        //Sort the array so that duplicates get line up
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int e =0;
        for (int i =0;i<arr.length;i++){
               //initialise start pointer with zero for new duplicates
            int s =0;
                //check for duplicates
            if (i>0&&arr[i]==arr[i-1]){
                //set the start pointer at correct position
                s = e+1;
            }
            e = outer.size()-1;
            int n = outer.size();
            for (int j = s;j<n;j++){
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }
        return outer;
    }
}
