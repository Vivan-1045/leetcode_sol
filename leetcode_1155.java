import java.util.ArrayList;
import java.util.List;

public class leetcode_1155 {
    public static void main(String[] args) {
//        dice("", 2);
//        System.out.println(dice1("", 4));
//        System.out.println(dicecount("", 4,0));

        System.out.println(diceWithFace("",15, 6, 4));
    }
    public static void dice(String p,int target){
        if (target==0){
            System.out.println(p);
            return;
        }
        for (int i = 1;i<=6 && i<=target;i++){
            dice(p+i, target-i);
        }
    }
//Return list
    public static List<String> dice1(String p,int target){
        if (target==0){
            List<String > list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String > list = new ArrayList<>();
        for (int i = 1;i<=6 && i<=target;i++){

            list.addAll(dice1(i+p, target-i));
        }
        return list;
    }

    public static int dicecount(String p,int target,int count){
        if (target==0){
            return count;
        }
        for (int i = 1;i<=6 && i<=target;i++){
           count += 1;
          dicecount(i+p, target-i,count+=1);
        }
        return  count;
    }

    public static List<String> diceWithFace(String p ,int n,int face,int target){
        if (target==0 || n==0){
            List<String > list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String > list = new ArrayList<>();
        for (int i = 1;i<=face && i<=target;i++){

            list.addAll(diceWithFace(i+p,n -i, face,target-i));
        }
        return list;
    }
}
