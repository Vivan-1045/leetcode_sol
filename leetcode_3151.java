public class leetcode_3151 {
    public static void main(String[] args) {
       int [] arr = {2,1,4};
        System.out.println(isSpecial(arr));
    }
    public static boolean isSpecial(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (i<arr.length-1 && (arr[i]%2 == arr[i+1]%2)){
                return false;
            }
        }
        return true;
    }
}
