package unCategorisedCode;

public class leetcode_1528 {
    public static void main(String[] args) {
         String s = "codeleet";
         int []indices = {4,5,6,7,0,2,1,3};
         char [] charArray = new char[s.length()];
         for (int i= 0;i<indices.length;i++){
             charArray[indices[i]] = s.charAt(i);
        }
        System.out.println(charArray);
    }

}
