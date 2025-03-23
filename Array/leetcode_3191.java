package Array;

public class leetcode_3191 {
    public static void main(String[] args) {
        int[] binaryArray = {0,1,1,1,0,0};
        System.out.println(minOpr1(binaryArray));
    }
    public static int minOpr(int[] arr){
        int n = arr.length;
        int count = 0;
        for (int i = 0;i<n-2;i++){
            if (arr[i]==0) {
                count++;
               for (int j = i;j<i+3;j++){
                   arr[j] = (arr[j]==0)?1:0;
               }
            }

        }

        boolean allOne = true;
        for (int num: arr){
            if (num !=1){
                allOne = false;
                break;
            }
        }

        return allOne ?count:-1;
    }


    //Another Approach
    public static int minOpr1(int[] arr){
        int n = arr.length;
        int count = 0;
        for (int i = 0;i<n-2;i++){
            if (arr[i]==0){
                count++;
                flip(arr,i);
                flip(arr,i+1);
                flip(arr,i+2);
            }
        }
        return (arr[n-1]!=1 || arr[n-2]!=1)?-1:count;
    }
    public static void flip(int[]arr,int i ){
        arr[i] = (arr[i]==0)?1:0;
    }
}
