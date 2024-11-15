public class leetcode_168 {
    public static void main(String[] args) {
        int columnNumber = 28;
        StringBuilder st = new StringBuilder();
        String ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        while (columnNumber > 0) {
            columnNumber--;
            int remainder = columnNumber % 26;
            st.append(ch.charAt(remainder));
            columnNumber = columnNumber / 26;
        }
        System.out.println(st.reverse().toString());
    }
}