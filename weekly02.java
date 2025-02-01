import java.util.HashMap;

public class weekly02 {
    public static void main(String[] args) {
     String s = "zadavyayobbgqsexaabk";
        System.out.println(maxScore(s));
    }
    public static char getMirror(char ch1){
        return (char)('a' + ('z' - ch1)) ;
    }
    public static int maxScore(String s){
        int score = 0;
        boolean []mark = new boolean[s.length()];
        HashMap<Character,Integer> lasdIdx = new HashMap<>();
        for (int i = 0;i<s.length();i++){
            if (mark[i])continue;
           char firstchar = s.charAt(i);
           char mirrorChar = getMirror(firstchar);
           if (lasdIdx.containsKey(mirrorChar)){
               int j = lasdIdx.get(mirrorChar);
               if (!mark[j]){
                   score += i-j;
                   mark[j]= true;
                   mark[i] = true;
               }
           }
           lasdIdx.put(firstchar, i);
        }
        return score;
    }
}



