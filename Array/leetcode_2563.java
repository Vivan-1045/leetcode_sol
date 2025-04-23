package Array;

public class leetcode_2563 {
    public static void main(String[] args) {
        int [] arr= {1};
        int l = 1;
        int h = 1;
        System.out.println(countfairPair(arr,l,h));
    }
    public static int countfairPair(int[] arr,int l,int h){
        int n = arr.length;
        int count = 0;

        for (int i =0;i<n;i++){
            for (int j = i+1;j<n;j++){
                int sum = arr[i] +arr[j];
                if (sum>= l && sum<= h){
                    count +=1;
                }
            }

        }
        return count;
    }
}
