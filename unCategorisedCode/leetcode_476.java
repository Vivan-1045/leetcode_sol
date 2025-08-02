package unCategorisedCode;

public class leetcode_476 {
    public static void main(String[] args) {
        int n = 47;
        System.out.println(newInt(n));
    }
    public static int newInt(int n){
        String st = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder();
        for (char ch: st.toCharArray()) {
            if((ch & 1) == 1){
                sb.append('0');
            }else {
                sb.append('1');
            }
        }
        String st1 = sb.toString();
        int ans = Integer.parseInt(st1, 2);
        return ans;
    }
}
