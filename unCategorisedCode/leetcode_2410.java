package unCategorisedCode;

import java.util.Arrays;

public class leetcode_2410 {
    public static void main(String[] args) {
        int pl[] = {1,1000000000};
        int tr[] = {1000000000,1};
        System.out.println(Matchplayer(pl, tr));
    }
    public static int Matchplayer(int[]arr1,int[]arr2){

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int count = 0;
        int i =0;
        int j =0;
        while (i<arr1.length && j<arr2.length){
            if (arr1[i]<=arr2[j]){
                count++;
                i++;
                j++;
            }else{
                j++;
            }
        }
        return count;
    }
}
