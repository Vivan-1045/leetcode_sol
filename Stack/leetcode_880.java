package Stack;

public class leetcode_880 {
    String kthChar(String s, int k){
        long len = 0;
        int i = 0;

        while(len < k){
            if(s.charAt(i)-'0'>=0 && s.charAt(i)-'0'<=9){
                len *= s.charAt(i)-'0';
            }else{
                len++;
            }
            i++;
        }


        for(int j = i-1;j>=0;j--){
            if(s.charAt(j)-'0'>=0 && s.charAt(j)-'0'<=9){
                len /= s.charAt(j)-'0';
                k %= len;
            }else{
                if(k==0||k==len){
                    return s.charAt(j)+"";
                }
                len--;
            }
        }

        return "";
    }
}
