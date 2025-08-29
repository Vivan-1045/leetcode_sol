package Two_Pointer;

import java.util.Arrays;

public class leetcode_581 {
    public static void main(String[] args) {
        int[] arr = {2,6,4,8,10,9,15};
        System.out.println(UnsortedSubarrayLength(arr));
    }
    public static int UnsortedSubarrayLength(int[] arr){
        int n = arr.length;
        int [] copyArr = Arrays.copyOf(arr,n);
        Arrays.sort(copyArr);
        int firstMisMatch = 0;
        int secondMisMatch = 0;

        int i = 0,j=n-1;
        while(i<n){
            if(copyArr[i]!= arr[i]){
                firstMisMatch  = i;
                break;
            }
            i++;
        }

        while(j>=0){
            if(copyArr[j]!= arr[j]){
                secondMisMatch = j;
                break;
            }
            j--;
        }

        return firstMisMatch==secondMisMatch?0:secondMisMatch-firstMisMatch+1;
    }
}
