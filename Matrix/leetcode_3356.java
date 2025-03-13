package Matrix;

public class leetcode_3356 {
    public static void main(String[] args) {
        int [][] arr = {{0,0,2},{0,0,4},{0,0,4},{0,0,3},{0,0,5}};
        int [] num = {0};
        System.out.println(k(arr,num));
    }
    //Brute force gives TLE 624/627
    public static int k(int[][] grid , int[] num){
        int count = 0;


        boolean isZeroArray = true;
        for (int n : num) {
            if (n != 0) {
                isZeroArray = false;
                break;
            }
        }

        if (isZeroArray) {
            return 0;
        }

        for(int[] arr: grid){
            count += 1;

            for(int i = arr[0];i<=arr[1];i++){
                num[i] = Math.max(0,num[i]-arr[2]);
            }

            boolean allZero = true;
            for( int n : num){
                if(n!=0){
                    allZero = false;
                    break;
                }
            }

            if(allZero){
                return count;
            }
        }
        return -1;
    }

    //Another Approach using Binary Search
    public static int optimal(int[][] queries, int [] num){
        int l = 0;
        int r = queries.length-1;
        int res = -1;

        boolean allZero = true;
        for(int m : num){
            if(m!=0){
                allZero = false;
                break;
            }
        }
        if(allZero){
            return 0;
        }


        while(l<=r){
            int m = l+(r-l)/2;
            if(checkUsingDiff(queries,num,m)==true){
                res = m+1;
                r = m-1;
            }else{
                l = m+1;
            }
        }
        return res;
    }

   public static boolean checkUsingDiff(int [][] queries,int [] num,int j){
        int []diff= new int[num.length];
        for( int i = 0;i<=j;i++){
            int s = queries[i][0];
            int e = queries[i][1];
            int val = queries[i][2];

            diff[s] += val;
            if(e+1<diff.length){
                diff[e+1] -= val;
            }
        }

        int sum =0;
        for(int i =0;i<diff.length;i++){
            sum += diff[i];
            diff[i] = sum;

            if(num[i]>diff[i]){
                return false;
            }
        }
        return true;
    }
}
