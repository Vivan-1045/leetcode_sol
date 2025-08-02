package unCategorisedCode;

public class leetcode_1678 {
    public static void main(String[] args) {
       String s = "G()(al)";
       String FinalAns = Final(s);
        System.out.println(FinalAns);
    }
    public static String Final(String s){
       String sp =  s.replace("()", "o");
       return sp.replace("(al)", "al");
    }
}
