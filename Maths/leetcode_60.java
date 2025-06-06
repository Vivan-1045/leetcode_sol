package Maths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class leetcode_60 {
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) {
//        System.out.println(getPerm(4,17));
        System.out.println(getPermutation(4,17));
    }

    //Brute force 127/200 TLE
    public static String getPerm(int n,int k){
        StringBuilder sb = new StringBuilder();
        for(int i = 1;i<=n;i++){
            sb.append(i);
        }
        String s = sb.toString();
        listOfPerm("",s);
        Collections.sort(list);
        return list.get(k-1);
    }

    public static void listOfPerm(String p,String up){
        if(up.isEmpty()){
            list.add(p);
            return;
        }
        char ch = up.charAt(0);
        for(int i = 0;i<=p.length();i++){
            String f = p.substring(0,i);
            String s = p.substring(i,p.length());
            listOfPerm(f+ch+s,up.substring(1));
        }
    }

    //Optimal
    public static String getPermutation(int n,int k){
        List<Integer> list1 =  new ArrayList<>();
        int fact = 1;
        for (int i = 1;i<n;i++){
            fact *= i;
            list1.add(i);
        }
        list1.add(n);
        k -= 1; // for 0-based indexing
        String ans = "";
        while (true){
            ans = ans + list1.get(k/fact);
            list1.remove(k/fact);
            if (list1.isEmpty()){
                break;
            }
            k = k%fact;
            fact = fact/list1.size();
        }
        return ans;
    }
}
