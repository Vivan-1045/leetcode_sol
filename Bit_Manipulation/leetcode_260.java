package Bit_Manipulation;

import java.util.HashMap;
import java.util.Map;

public class leetcode_260 {
    public static void main(String[] args) {

    }

    //O(n) and O(n)
    public static int [] single0(int[] arr){
        Map<Integer,Integer> mp = new HashMap<>();

        int[] res= new int[2];
        int k = 0;
        for(int num : arr){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry : mp.entrySet()){
            if(entry.getValue()%2 != 0){
                res[k++]= entry.getKey();
            }
        }

        return res;
    }

    //O(n) and O(1)
    public static int [] single1(int[] arr){
        int xor = 0;

        for(int i = 0;i<arr.length;i++){
            xor^=arr[i];
        }
        int xor1 = 0;
        for(int i = 0;i<arr.length;i++){
            xor1^= arr[i];

            if(xor1 != 0 && xor1!=arr[i]){
                break;
            }
        }

        return new int[]{xor1,xor-xor1};
    }

    //Optimal O(n) and O(1)
    public static int[] single2(int []arr){
        int xor = 0;
        for(int ele:arr){
            xor^=ele;
        }

        int mask = (xor) & (-xor);
        int num1 = 0;
        int num2 = 0;

        for(int ele : arr){
            if((mask & ele)==0){
                num1 ^= ele;
            }else{num2 ^= ele;}
        }

        return new int[]{num1,num2};
    }
}
