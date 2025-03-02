package Contests;

public class Biweekly_15_02_25 {
    public static void main(String[] args) {
        int [] arr1 = {2,1};;
        int k = 1;
        System.out.println(goodSum(arr1,k));
    }
    public static int goodSum(int [] arr1,int k){
        int GoodSum = 0;
        for (int i =0;i<arr1.length;i++){
            if (i+k< arr1.length && i-k>=0){
                if (arr1[i]>arr1[i+k] && arr1[i]>arr1[i-k]){
                    GoodSum += arr1[i];
                }
            } else if (i+k< arr1.length && i-k<0) {
                if (arr1[i]>arr1[i+k]){
                    GoodSum += arr1[i];
                }
            }else if (i+k> arr1.length-1 && i-k >= 0){
                if (arr1[i]>arr1[i-k]){
                    GoodSum +=arr1[i];
                }
            }
        }
        return GoodSum;
    }
}
