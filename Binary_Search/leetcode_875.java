package Binary_Search;

import java.util.Arrays;

public class leetcode_875 {
    public static void main(String[] args) {
        int [] arr = {3,6,7,11};
        System.out.println(minSpeed(arr,8));
    }

    public static int minSpeed(int[] arr, int h){

        int l = 1;
        int r = Arrays.stream(arr).max().getAsInt();
        while (l<r){
            int m = l + (r-l)/2;

            if (canEatAll(arr,m,h)){
                r = m;
            }else {
                l = m+1;
            }
        }
        return l;
    }

    public static boolean canEatAll(int[] arr, int m , int h){
        int actualTime = 0;
        for(int ele  : arr){
            actualTime += ele/m;
            if (ele%m != 0){
                actualTime++;
            }
        }

        return actualTime<=h;
    }
}
