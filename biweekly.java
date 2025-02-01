public class biweekly {
    public static void main(String[] args) {
        String s = "tokk";
        String p = "t*t";

        System.out.println(isMatch(s,p));
    }
    public static boolean isMatch(String s, String p){
        if (s.length()==0||p.length()==0){
            return false;
        }
        StringBuilder st = new StringBuilder(s);
        String sp = p.replace("*","");
        for (int i =0;i<sp.length();i++){
            if (sp.charAt(0) == sp.charAt(sp.length()-1)){
                return false;
            }
            if (st.indexOf(String.valueOf(sp.charAt(i)))==-1){
                return false;
            }
        }
        return true;
    }
}
