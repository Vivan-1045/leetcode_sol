package Array;

public class leetcode_2302 {
    public static void main(String[] args) {
        int[]arr= {2,1,4,3,5};
        int k = 10;
        System.out.println(countSubArrayWithScore(arr,k));
    }
    public static long countSubArrayWithScore(int[] arr , int k){
        int n = arr.length;
        long ans = 0;
        int i =0,j=0;

        long currSum = 0;
        while (j<n){
            currSum += arr[j];

            while (i<=j && currSum*(j-i+1)>=k){
                currSum -= arr[i];
                i++;
            }

            ans += (j-i+1);
            j++;
        }
        return ans;
    }
}
