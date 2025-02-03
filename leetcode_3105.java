public class leetcode_3105 {
    public static void main(String[] args) {
        int [] arr = {1,5,2};
        System.out.println(subArraylength(arr));
    }
    public static int subArraylength(int[] arr){
        int inc = 1,dec=1,ans = 1;

        for (int i = 1;i<arr.length;i++){
            if (arr[i]>arr[i-1]){
                inc++;
                dec =1;
            } else if (arr[i]<arr[i-1]) {
                dec++;
                inc =1;
            }else{
                inc = 1;
                dec =1;
            }
            ans = Math.max(ans,Math.max(inc,dec));
        }
        return ans;
    }
}
