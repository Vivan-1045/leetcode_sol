package Array;

public class leetcode_2873 {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(maxVal(arr));
    }
    public static long maxVal(int[] arr){
        int n = arr.length;
        long ans = 0;

        for (int i = 0;i<n-2;i++){
            for (int j = i+1;j<n-1;j++){
                for (int k = j+1;k<n;k++){
                    if (arr[i]<0&&arr[j]<0&&arr[k]<0){
                        return 0;
                    }
                    ans = Math.max(ans, (long) (arr[i] - arr[j]) *arr[k]);
                }
            }
        }
        return ans;
    }
}
