package Array;

public class leetcode_2529 {
    public static void main(String[] args) {
        int []arr = {-4,-2,-1,1,2,3};
        System.out.println(maxCount(arr));
    }
    public static int maxCount(int []arr){
        int neg=0,pos=0;
        for(int i = 0;i< arr.length;i++){
            if(arr[i]<0){
                neg=i;
            }else if(arr[i]>0){
                pos = arr.length-i;
                break;
            }
        }
        return Math.max(pos,neg);
    }
}
