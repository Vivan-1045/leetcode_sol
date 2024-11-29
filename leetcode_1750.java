public class leetcode_1750 {
    public static void main(String[] args) {
        String a = "aabccabba";
        System.out.println(Distinct(a));
    }
    public static int Distinct(String a){
        int i  =0;
        int j = a.length()-1;
        while (i<j){
            if (a.charAt(i) == a.charAt(j)){
                char charPosition = a.charAt(i);
                while (i<=j && a.charAt(i) == charPosition){
                        i++;
                }
                while (i<=j && a.charAt(j)==charPosition){
                        j--;
                }
            }else {
                break;
            }
        }
        return j-i+1;
    }

}


