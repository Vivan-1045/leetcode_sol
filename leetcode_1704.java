public class leetcode_1704 {
    public static void main(String[] args) {
        String s = "textbook";
        String st1 = s.substring(0, (s.length())/2);
        String st2 = s.substring((s.length()+1)/2,s.length());
        int count1 =0,count2 =0;
       

        if(count1 == count2){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
}
