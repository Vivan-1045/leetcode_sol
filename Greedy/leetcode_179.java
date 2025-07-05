package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class leetcode_179 {
    public static void main(String[] args) {
       int[]arr  = {1,1,0,0,0};
        System.out.println(largestNumber(arr));;
    }
    public static String largestNumber(int[] arr){
        List<String> list = new ArrayList<>();
       for (int num : arr){
          list.add(num+"");
       }

       //Comparator  is used for custom sorting
       Collections.sort(list, (String a, String b)->{return (a+b).compareTo(b+a);});

       for(int i = 0;i< list.size();i++){
           if(list.get(i).equals("0") && i == list.size()-1){
               return "0";
           }
       }
       String ans = "";
       for (int i = list.size()-1;i>=0;i--){
           ans += list.get(i);
       }
       return ans;
    }
}
