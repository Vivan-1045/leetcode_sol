package unCategorisedCode;

public class leetcode_1859 {
    public static void main(String[] args) {
        String s = "is2 sentence4 This1 a3";
        String[]str = s.split(" ");
        String[] str1 = new String[str.length];

        for (String wd:str) {
            //Getting the correct index of that particular word
           int correctIndex = Character.getNumericValue(wd.charAt(wd.length()-1));
            System.out.println(correctIndex);
            //Store the word in the str1 array at their correct position
           str1[correctIndex-1] = wd.substring(0, wd.length()-1);
        }
        System.out.println(String.join(" ",str1));
    }
}
