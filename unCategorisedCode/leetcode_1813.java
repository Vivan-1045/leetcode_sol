package unCategorisedCode;

public class leetcode_1813 {
    public static void main(String[] args) {
        String a =  "Eating in the room";
        String b = "Eating";
        System.out.println(SameString(a, b));
    }
    public static  boolean SameString(String a, String b){
        String[] s1 = a.split(" ");
        String[] s2 = b.split(" ");
        int i = 0;
        int j = 0;
        while (i < s1.length && i < s2.length && s1[i].equals(s2[i])) {
            i++;
        }
         while (j < s1.length - i && j < s2.length - i && s1[s1.length - 1 - j].equals(s2[s2.length - 1 - j])) {
             j++;
         }
         return i + j >= Math.min(s1.length, s2.length);
    }
}
