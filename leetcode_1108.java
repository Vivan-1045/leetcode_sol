public class leetcode_1108 {
    public static void main(String[] args) {
        String address = ".";
        String DefangIpadd = DefangIP(address);
        System.out.println(DefangIpadd);
    }
    public static String DefangIP(String address){
        return address.replace(".", "[.]");
    }
}
