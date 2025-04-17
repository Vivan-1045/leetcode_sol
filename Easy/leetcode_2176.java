package Easy;

public class leetcode_2176 {
    public static void main(String[] args) {
        int [] arr = {3,1,2,2,2,1,3};
        int k = 2;
        System.out.println(divisiblePairs(arr,k));
    }
    public static int divisiblePairs(int [] arr, int k){
        int count = 0;
        int n = arr.length;

        for (int i = 0;i<n;i++){
            for (int j = i+1;j<n;j++){
                if ((i*j)%k==0){
                    if (arr[i]==arr[j]){
                        count += 1;
                    }
                }
            }
        }

        return count;
    }
}
