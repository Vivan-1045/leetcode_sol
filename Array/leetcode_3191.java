package Array;

public class leetcode_3191 {
    public static void main(String[] args) {
        int[] binaryArray = {1,1,1,0,0,0};
        System.out.println(minOpr(binaryArray));
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
}
