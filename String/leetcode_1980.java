package String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class leetcode_1980 {
    public static void main(String[] args) {
        String [] st = {"001","000","100"};
//        System.out.println(uniqueString(st));
        System.out.println(uniqueString(st));
        System.out.println(uniqueString3(st));
    }

    //Brute force
    public static String uniqueString(String[] st){
        int n = st[0].length();
        int [] arr= new int[1<<n];
        int [] arr1 = new int[1<<n];

        for (int i =0;i<(1<<n);i++){
            arr1[i] = i;
        }

        for(int i = 0;i< st.length;i++){
            arr[i]= Integer.parseInt(st[i],2);
        }

        String ans = Integer.toString(checkFunction(arr,arr1),2);
        if (ans.length() != n){
            StringBuilder sb = new StringBuilder(ans);
            while (ans.length() != n){
                if (ans.equals("1")){
                    return "01";
                }else{
                    sb.append("0");
                }

                n--;
            }
            return sb.toString();
        }

        return ans;
    }
    public static int checkFunction(int[] arr, int[] arr1){
        Arrays.sort(arr);
        for (int i =arr.length-1;i>=0;i--){
            if (arr[i] != arr1[i]){
                return arr1[i];
            }
        }

        return 0;
    }


    //optimal approach
    public static String unique(String[]str){
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i<str.length;i++){
            char ch = str[i].charAt(i);
            ans.append(ch=='1'?'0':'1');
        }
        return ans.toString();
    }


    //Using Set
    public static String uniqueString3(String [] st){
        int n = st[0].length();
        Set<Integer> set = new HashSet<>();
        for (int i= 0;i< st.length;i++){
            set.add(Integer.parseInt(st[i],2));
        }

        int uniqueNum = ans(set, st.length);
        String ans = Integer.toBinaryString(uniqueNum);
        while (ans.length() < n) {
            ans = "0" + ans;
        }

        return ans;
    }
    public static int ans(Set<Integer> set, int n) {
        for (int i = 0; i < n; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return n;
    }




}
