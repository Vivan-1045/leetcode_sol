import java.util.Arrays;
import java.util.PriorityQueue;

public class leetcode_3066 {
    public static void main(String[] args) {
        int []arr = {1000000000,999999999,1000000000,999999999,1000000000,999999999};
        int element = 1000000000;
//        System.out.println(numberOfOpr(arr,element,0));
        System.out.println(maxOperation(arr,element));
    }

    //gives TLE (671/67)
    public static int numberOfOpr(int[]arr,int k,int count){
        if (arr.length==1){
            return count;
        }
        Arrays.sort(arr);
        int a = arr[0];
        int b = arr[1];
        if (Math.min(a,b)>=k){
           return count;
        }else {
            long add = (long)Math.min(a, b) * 2 + Math.max(a, b);
            if (add > Integer.MAX_VALUE) {
                add = Integer.MAX_VALUE;
            } else if (add < Integer.MIN_VALUE) {
                add = Integer.MIN_VALUE;
            }
            arr = updateArray(arr,(int)add);
            return numberOfOpr(arr, k, count +1);
        }
    }
    public static int[] updateArray(int[] arr,int element){
        int [] arr1 = new int[arr.length-1];
        for (int i =2;i<arr.length;i++){
            arr1[i-2] = arr[i];
        }
        arr1[arr1.length-1]= element;
        return arr1;
    }


    //Using Heap
    public static int maxOperation(int [] arr,int k){
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num: arr){
            pq.add(num);
        }

        while (pq.size()>1){
            int a = pq.poll();
            int b = pq.poll();
            if (Math.min(a,b)>=k){
                return count;
            }

            long add = (long)Math.min(a,b)*2+ Math.max(a,b);
            if (add>Integer.MAX_VALUE){
                add = Integer.MAX_VALUE;
            } else if (add<Integer.MIN_VALUE) {
                add = Integer.MIN_VALUE;
            }
            pq.add((int)add);
            count +=1;
        }
        return count;
    }
}
