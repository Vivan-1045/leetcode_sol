package Two_Pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_167 {
    public static void main(String[] args) {
        int[]arr = {2,7,11,15};
        System.out.println(Arrays.toString(getIndices(arr,9)));
    }
    public static int[] getIndices(int[] arr,int target){
        int[] ans = new int[2];
        int k =0 ;
        for (int i = 0;i<arr.length;i++){
            for (int j = i+1;j<arr.length;j++){
                if (arr[i]+arr[j]==target){
                    ans[k] = i+1;
                    ans[k+1] = j+1;
                    break;
                }
            }
        }

        return ans;
    }

    //optimal
    public static int[] getSumIndices(int[] arr,int target){
        int s = 0;
        int e = arr.length;

        while (s<e){
            int currSum = arr[s]+arr[e];

            if (currSum==target){
                return new int[]{s+1,e+1};
            }
            if (currSum>target){
                e--;
            }else{
                s++;
            }
        }
        return new int[]{0,0};
    }
}
