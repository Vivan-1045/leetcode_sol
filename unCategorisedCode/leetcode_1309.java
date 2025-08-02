package unCategorisedCode;

public class leetcode_1309 {
    public static void main(String[] args) {
        String  s = "10#11#12";
        String s1 = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i<=s.length()-1;i++){
            if(i<s.length()-2 && s.charAt(i+2) == '#') {
                int ch1 = Integer.parseInt(s.substring(i, i+2));
                sb.append(s1.charAt(ch1-1));
                i +=2;
            }else{
                int ch2 = Character.getNumericValue(s.charAt(i));
                sb.append(s1.charAt(ch2-1));
            }
        }
        System.out.println(sb);
    }
}
