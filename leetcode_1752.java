import java.util.Arrays;

public class leetcode_1752 {
    public static void main(String[] args) {
       int [] arr = {2,1,3,4};
        System.out.println(isValid(arr));
    }
    public static boolean isValid(int[] arr){
        //Count the peak in the given array if it is more than one then just return false else return true
        int count = 0;
        for(int i =0;i<arr.length;i++){
            if (arr[i]>arr[(i+1)%arr.length]){
                count += 1;
            }
        }
        return count <= 1;
    }
}
