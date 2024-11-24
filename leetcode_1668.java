public class leetcode_1668 {
    public static void main(String[] args) {
        String sequence = "aaa";
        String word = "a";
        System.out.println(Count(sequence,word));
    }
    public static int Count(String sequence, String word){
        StringBuilder sb1 = new StringBuilder(sequence);
        StringBuilder sb = new StringBuilder(word);
        int count = 0;
        if(sb.length() == sb1.length() && sb1.toString().contains(sb.toString())){
            return 1;
        }
        while (sb.length()<=sb1.length()){
            if(sb1.toString().contains(sb.toString())){
                count++;
                sb.append(word);
            }else{
                return count;
            }
        }
        return count;
    }
}
