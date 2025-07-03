package Sliding_window;

import java.util.TreeSet;

public class leetcode_220 {
    public static void main(String[] args) {

        int[]arr = {8,7,15,1,6,1,9,15};
        System.out.println(containsDup(arr,1,3));
    }
    public static boolean contains(int[] arr, int idxDiff,int valDiff){

        int j = 0;
        for (int i = 0;i<arr.length;i++){
            j = i+1;
            if (j>arr.length){
                return false;
            }
            while (Math.abs(i-j)<=idxDiff && j<arr.length){
                if (Math.abs(arr[i]-arr[j])<=valDiff){
                    return true;
                }
                j++;
            }
        }
        return false;
    }

    public static boolean containsDup(int[] arr,int idxDiff,int valDiff){
        if (arr.length==0|| idxDiff==0){
            return false;
        }
        TreeSet<Long> st = new TreeSet();
        for(int i = 0;i<arr.length;i++){
            Long floor = st.floor((long) (arr[i]+valDiff));
            Long ceil = st.ceiling((long) (arr[i]-valDiff));

            if (floor != null && floor>=arr[i] || ceil != null && ceil<= arr[i]){
                return true;
            }
            st.add((long) arr[i]);

            if (i>=idxDiff){
                st.remove(arr[i-idxDiff]);
            }
        }
        return false;
    }
}
