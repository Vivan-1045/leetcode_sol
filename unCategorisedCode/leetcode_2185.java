package unCategorisedCode;

public class leetcode_2185 {
    public static void main(String[] args) {
        String []st = {"leetcode","win","loops","success"};
        String pref = "code";
        System.out.println(CountPerfix(st,pref));
    }
    public static int CountPerfix(String[] s, String p){

        int i = 0;
        int count = 0;
        for (String word : s) {
            if (word.startsWith(p)){
                count++;
            }
        }
        return count;
    }
}
