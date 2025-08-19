package String;

public class leetcode_2414 {
    public static void main(String[] args) {
        System.out.println(maxLength("abcde"));
    }
    public static int maxLength(String s){
        String a = "abcdefghijklmnopqrstuvwxyz";
        int max = Integer.MIN_VALUE;
        int n = s.length();

        for (int i = 0;i<n;i++){
            for (int j = i;j<n;j++){
                if (a.contains(s.substring(i,j+1))){
                    String st = s.substring(i,j+1);
                    max = Math.max(max,st.length());
                }else {
                    i=j-1;
                    break;
                }
            }
        }
        return max;
    }
}
