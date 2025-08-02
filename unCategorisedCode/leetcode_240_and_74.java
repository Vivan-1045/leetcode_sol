package unCategorisedCode;

public class leetcode_240_and_74 {
    public static void main(String[] args) {
        int arr[][] = {{-5}};
        System.out.println(searchIn2D(arr, -5));
    }
    public static boolean searchIn2D(int[][] arr,int target){
        int i =0;
        int j = arr[0].length-1;
        while (i<=arr.length-1 && j>=0){
            if (arr[i][j] == target){
                return true;
            } else if (arr[i][j]>target) {
                j--;
            }
            else {
                i++;
            }
        }
        return false;
    }
}
