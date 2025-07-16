package Array;

public class leetcode_3201 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(maxLength(arr));
    }
    public static int maxLength(int[]arr){
        int even=0,odd=0;
        int ans = 0;
        for(int num : arr){
            if(num%2==0){
                even++;
            }else{
                odd++;
            }
        }

        ans = Math.max(even,odd);
        int pairity = arr[0]%2;
        int oddEven = 1;

        for(int i =1;i<arr.length;i++){
            if(arr[i]%2 != pairity){
                oddEven++;
                pairity = arr[i]%2;
            }
        }
        return Math.max(ans,oddEven);
    }
}
