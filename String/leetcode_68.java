package String;

import java.util.ArrayList;
import java.util.List;

public class leetcode_68 {
    public static void main(String[] args) {
      String [] s = {"My","momma","always","said,","Life","was","like","a","box","of","chocolates.","You","never","know","what","you're","gonna","get."};
      getRes(s,20);
        System.out.println(res);
    }

    public static List<String> res = new ArrayList<>();
    public static void getRes(String[] arr,int k){
        int n = arr.length;
        String s = "";
        int cnt = 0;

        for(int i = 0;i<n;i++){
            s += arr[i];
            if(i+1<n && (s.length() + arr[i+1].length()<k)){
                s+=" ";
                cnt++;
            }else{
                if(i==n-1){
                    int space = k-s.length();
                    while(space-->0){
                        s+=" ";
                    }
                    res.add(s);
                }else{
                    String s2 = getString(s,cnt,k);
                    res.add(s2);
                    s = "";
                    cnt = 0;
                }
                // String s2 = getString(s,cnt,k);
                // res.add(s2);
                // s = "";
                // cnt = 0;
            }
        }
    }

    public static String getString(String s, int cnt, int k){
        int n = s.length();
        int space = k-n;
        if(space<cnt){
            String s1 = solve(s,space);
            return s1;
        }

        String s2 = solve1(s,space,cnt);
        if(cnt !=0 && space%cnt !=0){
            String s3 = solve(s2,space%cnt);
            return s3;
        }
        return s2;
    }

    public static String solve(String s, int space){
        String s1 = "";
        boolean first = false;

        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)==' '&& space>0 && first==false){
                s1 += " "+" ";
                first = true;
                space--;
            }else{
                s1 += s.charAt(i);
                first = false;
            }
        }

        return s1;
    }

    public static String solve1(String s, int space,int cnt){
        String s1 = "";
        if(cnt==0){
            while(space-->0){
                s+=" ";
            }

            return s;
        }


        int each = space/cnt;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)==' '){
                s1 += " ";
                while(each-->0){
                    s1 += " ";
                }
            }else{
                s1 += s.charAt(i);
                each = space/cnt;
            }
        }

        return s1;
    }
}
