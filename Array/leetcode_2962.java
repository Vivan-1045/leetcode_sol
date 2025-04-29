package Array;

public class leetcode_2962 {
    public static void main(String[] args) {
        int [] arr = {28,5,58,91,24,91,53,9,48,85,16,70,91,91,47,91,61,4,54,61,49};
        int k = 1;
        System.out.println(subArrayCountWithMaxEle(arr,k));
    }
    public static long subArrayCountWithMaxEle(int[] arr,int k){
        int maxEle = 0;
        int n = arr.length;
        for(int num : arr){
            maxEle = Math.max(maxEle,num);
        }

        int j = 0;
        long ans =0;
        int maxEleCount =0;
        for (int i = 0;i<n;i++){

            if (arr[i] == maxEle){
                maxEleCount += 1;
            }
            while (maxEleCount>=k){
                ans += n-i;
                if (arr[j]==maxEle){
                    maxEleCount -= 1;
                }
                j++;
            }
        }
        return ans;
    }
}
