public class leetcode_1662 {
    public static void main(String[] args) {
        String[] str1 = {"abc", "d", "defg"};
        String[] str2 = {"abcddefg"};
        String st1 = String.join("", str1);
        String st2 = String.join("", str2);
        System.out.println(st1);
        System.out.println(st2);
        System.out.println(st1.equals(st2));

    }
}
