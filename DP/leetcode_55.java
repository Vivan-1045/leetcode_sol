package DP;


public class leetcode_55 {
    static Boolean []t ;
    public static void main(String[] args) {
        int []arr = {3,2,1,0,4};
        t = new Boolean[arr.length+1];
        System.out.println(solve(arr,0));
    }
    public static boolean solve(int[] arr, int idx){
        if (idx>=arr.length){
            return false;
        }
        if (idx==arr.length-1){
            return true;
        }
        if (t[idx] != null){
            return t[idx];
        }
        for (int j = 1;j<=arr[idx];j++){
            if (solve(arr,idx+j)){
                return t[idx] = true;
            }
        }

        return t[idx] = false;
    }
}
