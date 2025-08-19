package Maths;

public class leetcode_2348 {
    public static void main(String[] args) {
       int [] arr= {1,3,0,0,2,0,0,4,0};
        System.out.println(zeroSubArrays(arr));
    }

    public static long zeroSubArrays(int []arr){
        long count =0;
        long zero = 0;

        for(int ele : arr){
            if (ele==0){
                zero++;
            }else {
                count += zero *(zero+1)/2;
                zero=0;
            }

        }
        if (zero!=0){
            count += zero *(zero+1)/2;
        }

        return count;
    }

}
