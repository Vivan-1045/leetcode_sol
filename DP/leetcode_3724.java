package DP;

public class leetcode_3724 {
    public long minOperations(int[] nums1, int[] nums2) {
        return minOpr(nums1,nums2);
    }

    long minOpr(int[] arr1, int[] arr2) {
        int n = arr1.length;

        long res = 1;
        int min = Integer.MAX_VALUE;
        int last = arr2[arr2.length-1];

        for(int i = 0;i<n;i++){
            int l = Math.min(arr1[i],arr2[i]);
            int r = Math.max(arr1[i],arr2[i]);

            if(last<l){
                int d = l-last;
                min = Math.min(d,min);
            }else if(last>r){
                int d = last - r;
                min = Math.min(d,min);
            }else{
                min = 0;
            }

            //Just calculate the cost to transform the arr1 to arr2 except last element

            res += Math.abs(arr1[i]-arr2[i]);
        }

        return min!= Integer.MAX_VALUE ? res + min:res; // Add the minimum cost to append the last element
    }
}
