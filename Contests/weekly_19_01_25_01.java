package Contests;

public class weekly_19_01_25_01 {
    public static void main(String[] args) {
      int[] arr = {3,1,1,2};
        System.out.println(MaxSum(arr));
    }
    public static int MaxSum(int[]num){
        int[] SubArray = new int[num.length];
        for (int i = 0;i<num.length;i++){
            int sum =0;
            for (int j = Math.max(0, i-num[i]);j<=i;j++){
                sum += num[j];
                SubArray[i]=sum;
            }
        }
        int Maxsum = 0;
        for (int j : SubArray) {
            Maxsum += j;
        }
        return Maxsum;
    }
}
