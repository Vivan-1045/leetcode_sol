public class leetcode_686 {
    public static void main(String[] args) {
        String a = "a";
        String b = "aa";
        System.out.println(repetdeString(a, b));
    }
    public static int repetdeString(String a , String b){
        StringBuilder sb = new StringBuilder(a);
        int count = 1;
        int minRep = (b.length() + sb.length()-1)/sb.length();
        while (sb.length()<b.length() || !sb.toString().contains(b)){
            if (!sb.toString().contains(b) && count > minRep+1){
                return -1;
            }
            sb.append(a);
            count++;
        }
        return count;
    }
}
