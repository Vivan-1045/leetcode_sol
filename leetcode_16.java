import java.util.Arrays;

public class leetcode_16 {
    public static void main(String[] args) {
        int[] arr = {-1,2,1,-4};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        int target = 1;
        int closestSum = Integer.MAX_VALUE;

//        System.out.println(e);
        for(int i =0;i<arr.length-2;i++){
            int s = i+1;
            int e = arr.length-1;
            while (s<e){
                int sum = arr[i] + arr[e]+ arr[s];
                if (Math.abs(target-sum)<Math.abs(target-closestSum)){
                    closestSum = sum;
                }
                if(sum >target){
                   e--;
                }if(sum<target){
                    s++;
                }else{
                    System.out.println("Sum: " + sum);
                }
            }
        }
        System.out.println("Sum : "+closestSum);
    }
}
