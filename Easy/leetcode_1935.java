package Easy;

public class leetcode_1935 {
    public static void main(String[] args) {
        System.out.println(canTyped("leet code", "e"));
    }
    public static int canTyped(String text, String bl){
        int cnt = 0;
        for(String s : text.split(" ")){
            if(isContains(s , bl)){
                cnt++;
            }
        }

        return cnt;

    }

    public static boolean isContains(String s,String bl){
        for(char ch : bl.toCharArray()){
            if(s.contains(String.valueOf(ch))){
                return false;
            }
        }
        return true;
    }
}
