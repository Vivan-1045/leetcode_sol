package unCategorisedCode;//public class unCategorisedCode.leetcode_1014 {
//    public static void main(String[] args) {
//        int arr[] = {8,1,5,2,6};
//        System.out.println(Maxdis(arr));
//
//    }
//    static int [] memo;
//    public static int Maxdis(int arr[]){
//        int maxDis = 0;
//        int n = arr.length;
//        if (memo == null){
//            memo = new int[n*n/2];
//        }
//        for (int i = 0;i<n-1;i++){
//            for (int j =i+1;j<n;j++){
//               int m = i*n+j;
//               if (memo[m]==0){
//                   memo[m] = arr[i]+arr[j] +(i-j);
//               }
//
//                maxDis = Math.max(maxDis, memo[m]);
//            }
//        }
//        return maxDis;
//    }
//}


public class leetcode_1014 {
    public static void main(String[] args) {
        int arr[] = {9, 9, 9, 9};
        System.out.println(MaxDis(arr));
    }

    public static int MaxDis(int[] arr) {
        int n = arr.length;
        int maxDis = Integer.MIN_VALUE;


        int[] max2 = new int[n];
        max2[n - 1] = arr[n - 1] - (n - 1);

        for (int j = n - 2; j >= 0; j--) {
            max2[j] = Math.max(arr[j] - j, max2[j + 1]);
        }


        for (int i = 0; i < n - 1; i++) {
            int res = (arr[i] + i) + max2[i + 1];
            maxDis = Math.max(maxDis, res);
        }

        return maxDis;
    }
}

