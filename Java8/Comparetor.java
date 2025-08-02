package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class customComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1,Integer o2){
        return o1-o2;
    }
}

class User{
    private String name;
    private int acNumber;
    private int cash;

    public User(String name , int acNumber,int cash){
        this.name = name;
        this.acNumber = acNumber;
        this.cash = cash;
    }
    public int getAcNumber(){
        return acNumber;
    }
    public int getCash(){
        return cash;
    }
    public String getName(){
        return name;
    }
}
public class Comparetor {
    public static <Student> void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<String> list1 = Arrays.asList("Rahul", "Rome", "Monk", "Vaishu", "Anuj");
        List<User> atm = new ArrayList<>();
        atm.add(new User("Mohit",2635,1200000));
        atm.add(new User("Rohit",8965,1840000));
        atm.add(new User("Rahul",8349,5960000));
        atm.add(new User("Anuj",7391,9800000));

        atm.sort((o1,o2)-> o1.getCash()-o2.getCash());

        for (User user : atm){
            System.out.println("User "+user.getName()+" having account number "+user.getAcNumber()+" have available balance "+user.getCash());
        }

        list.add(14);
        list.add(2);
        list.add(3);
        list.add(8);
//        list.sort(new customComparator());
        list.sort((a,b)-> b-a);
        list1.sort((o1,o2)->o1.length()-o2.length());
//        System.out.println(list1);
//        System.out.println(list);
    }
}

