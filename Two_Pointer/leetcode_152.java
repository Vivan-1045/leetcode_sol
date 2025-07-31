package Two_Pointer;

public class leetcode_152 {
    public static void main(String[] args) {
         int arr[] = {-1,3,-4};
        System.out.println(maxPro(arr));
    }
    public static int maxPro(int[] arr){
        int ans = Integer.MIN_VALUE;

        int n = arr.length;
        if(n==1){
            return arr[0];
        }

        for(int i = 0;i<n;i++){
            int currPro = arr[i];
            for(int j = i;j<n;j++){
                ans = Math.max(ans,currPro);
                if (j+1<n){
                    currPro *= arr[j+1];
                }
            }
        }

        return ans;
    }
}
