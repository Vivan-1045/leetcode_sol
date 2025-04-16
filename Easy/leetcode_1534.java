package Easy;

public class leetcode_1534 {
    public static void main(String[] args) {
        int []arr = {1,1,2,2,3};
        int a = 0,b=0,c=1;
        System.out.println(tripletCount(arr,a,b,c));
    }
    public static int tripletCount(int[] arr,int a,int b, int c){
        int n = arr.length;
        int count = 0;

        for (int i =0;i<n;i++){
            for (int j = i+1;j<n;j++){
                for(int k = j+1;k<n;k++){
                    int val1 = Math.abs(arr[i]-arr[j]);
                    int val2 = Math.abs(arr[j]-arr[k]);
                    int val3 = Math.abs(arr[i]-arr[k]);

                    if (val1 <= a && val2<=b && val3<=c){
                        count += 1;
                    }
                }
            }
        }

        return count;
    }
}
