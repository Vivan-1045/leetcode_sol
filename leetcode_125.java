import java.util.Arrays;

public class leetcode_125 {
    public static void main(String[] args) {
        String name = "race a car";
        String l = name.toLowerCase();
        //remove all the non alphanumeric charactor from string
        String result = l.replaceAll("[^a-zA-Z0-9]", "");
        StringBuilder sb = new StringBuilder();

        for (int i=result.length()-1;i>=0;i--){
            sb.append(result.charAt(i));
        }
        if (result.equals(sb.toString())){
            System.out.println(true);
        }else{
            System.out.println(false);
        }

    }
}
