package String;

public class leetcode_38 {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(countAndSay(n));
    }
    public static String countAndSay(int n){
        if (n==1){
            return "1";
        }
        String m = countAndSay(n-1);
        StringBuilder ans = new StringBuilder();

        int count = 1;
        for (int i = 1;i<m.length();i++){
            if (m.charAt(i)==m.charAt(i-1)){
                count++;
            }
            else{
                ans.append(count).append(m.charAt(i-1));
                count = 1;
            }
        }
        ans.append(count).append(m.charAt(m.length()-1));
        return ans.toString();
    }
}
