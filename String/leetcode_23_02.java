package String;

public class leetcode_23_02 {
    public static void main(String[] args) {
        String s = "34789";
        System.out.println(helper(s));
        System.out.println(isEqualOrNot(s));

    }
    public static boolean helper(String s){
        if(s.length()==2){
            return s.charAt(0)==s.charAt(1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i<s.length()-1;i++){
            sb.append((s.charAt(i)+s.charAt(i+1))%10);
        }
        return helper(sb.toString());
    }

    // optimal approach
    public static boolean isEqualOrNot(String s){
        int n = s.length();
        int [] st = new int[n];

        for (int i = 0;i<s.length();i++){
            st[i] = s.charAt(i)-'0';
        }
        while (n>2){
           int [] tempst = new int[n-1];

           for (int i =0;i<n-1;i++){
               tempst[i] = (st[i]-'0' + st[i+1]-'0')%10;
           }
            n--;
        }
        return st[0]==st[1];
    }
}
