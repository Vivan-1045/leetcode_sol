package String;

import java.util.Arrays;

public class leetcode_151 {
    public static void main(String[] args) {
        reveresSt("Hello                  world");
    }
    public static String reveresSt(String s){
        String[] st = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = st.length-1;i>=0;i--){
            if (st[i] != ""){
                sb.append(st[i]+" ");
            }
        }
        
        return sb.toString().substring(0,sb.length()-1);
    }
}
