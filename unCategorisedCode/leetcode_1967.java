package unCategorisedCode;

public class leetcode_1967 {
    public static void main(String[] args) {
        String word = "abc";
        String[] patterns = {"a","abc","bc","d"};
        int count = 0;
        for (String st : patterns) {
            //if the character exist in word
            if (word.indexOf(st) != -1){
                count++;
            }
        }
        System.out.println(count);
    }
}
