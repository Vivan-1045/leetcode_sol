package String;

public class leetcode_8 {
    public static void main(String[] args) {
        String s = "      -13";
        System.out.println(GetInt(s));
    }
    public static int GetInt(String s){
        String b = s.replaceAll("   ", "");
        int a = Integer.parseInt(b);
        return a;
    }
}
