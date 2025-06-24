package Two_Pointer;

public class leetcode_11 {
    public static void main(String[] args) {
        int[] arr = {12,10,11,12};
        System.out.println(maxArea(arr));
    }
    public static int maxArea(int [] arr){
        int n = arr.length;
        int ans = Integer.MIN_VALUE;
        int i = 0;
        int j = n-1;
        while (i<j){
            int area =  (j-i)*(Math.min(arr[i],arr[j]));
            ans= Math.max(ans,area);
            if (arr[i]>arr[j]){
                j--;
            }else if (arr[j]>=arr[i]){
                i++;
            }
        }
        return ans;
    }
}
