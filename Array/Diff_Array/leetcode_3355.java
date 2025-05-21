package Array.Diff_Array;

public class leetcode_3355 {
    public static void main(String[] args) {
        int [] arr = {1,0,1};
        int [][] query = {{0,2}};
        System.out.println(sol(arr,query));
    }

    // TLE :- 666/668
    public static boolean isTrue(int[]arr,int[][] query){
        for (int[] row : query){
            int l = row[0];
            int r = row[1];
            for (int i = l;i<=r;i++){
                arr[i] = arr[i]-1;
            }
        }

        for (int ele : arr){
            if (ele>0){
                return false;
            }
        }
        return true;
    }

    public static boolean sol(int[] arr,int [][]queries){
        int n = arr.length;
        int[] diff =  new int[n];
        int[] cummSum = new int[n];

        for (int[] query : queries){
            int l = query[0];
            int r = query[1];
            int x = 1;
            diff[l] += x;
            if (r+1<n){
                diff[r+1] -= x;
            }

        }

        int sum = 0;
        for (int i = 0;i<n;i++){
            sum += diff[i];
            cummSum[i]= sum;
        }

        for (int i =0;i<n;i++){
            if (cummSum[i]<arr[i]){
                return false;
            }
        }
        return true;


    }
}
