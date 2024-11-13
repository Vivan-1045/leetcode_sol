import java.util.Arrays;

public class leetcode_657 {
    public static void main(String[] args) {
        String moves = "RRDD";
        String[]st = moves.split("");
        int x=0,y=0;
        for (String move : st) {
            switch (move){
                case "U":
                    y++;
                    break;
                case "D":
                    y--;
                    break;
                case "R":
                    x++;
                    break;
                case "L":
                    x--;
                    break;
            }
        }
        if (x!=0 && y!=0){
            System.out.println(false);
        }else {
            System.out.println(true);
        }
    }
}
