public class leetcode_1422 {
    public static void main(String[] args) {
        String str = "00111";
        System.out.println(Maximum(str));
    }
    public static int Maximum(String st) {
       int ans = 0;
       for (int i =0;i<st.length()-1;i++){
           int curr = 0;
           for (int j = 0;j<i+1;j++){
               if (st.charAt(j)=='0'){
                   curr++;
               }
           }
           for (int j = i+1;j<st.length();j++){
               if (st.charAt(j)=='1'){
                   curr++;
               }
           }
           ans = Math.max(ans, curr);
       }
        return ans;
    }
}
