package Bit_Manipulation;

public class leetcode_319 {
    public int bulbSwitch(int n) {
        return totalOn(n);
    }

    public int totalOn(int n){
        return (int)Math.sqrt(n);
    }
}
