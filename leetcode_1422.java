public class leetcode_1422 {
    public static void main(String[] args) {
        String str = "00111";
        System.out.println(Maximum(str));
    }
    public static int Maximum(String st) {
       int ans = 0;
       int ones = 0;
       int zeros = 0;

       for (int i =0;i<st.length();i++) {
           if (st.charAt(i)=='1'){
               ones++;
           }
       }
       for (int i =0;i<st.length()-1;i++){
           if (st.charAt(i)=='0'){
               zeros++;
           }else{
               ones--;
           }
           ans = Math.max(ans, ones+zeros);
       }
       return ans;
    }
}
