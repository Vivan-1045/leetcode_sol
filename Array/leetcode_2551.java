package Array;

import java.util.Arrays;

public class leetcode_2551 {
    public static void main(String[] args) {
       int []arr= {1,3,5,1};
       int k =2;
        System.out.println(maxMarbleScore(arr,k));
    }
    public static long maxMarbleScore(int []arr ,int k){
        int n = arr.length;
        int []pairSum = new int[n-1];
        for (int i = 0;i<n-1;i++){
            pairSum[i] = arr[i] + arr[i+1];
        }

        Arrays.sort(pairSum);
        long minScore = 0;
        long maxScore = 0;

        for (int i =0;i<k-1;i++){
            minScore += pairSum[i];
            maxScore += pairSum[n-2-i];
        }

        return maxScore-minScore;
    }
}
