public class leetcode_2381 {
//    public static void main(String[] args) {
//        String s = "dztz";
//        int[][] arr = {{0,0,0},{1,1,1}};
//        System.out.println(letterShifting(s, arr));
//    }
//    public static String letterShifting(String s,int[][] arr){
//        StringBuffer sb = new StringBuffer(s);
//        for (int[] num: arr) {
//            int b = num[0];
//            int e = num[1];
//            int d = num[2];
//            for (int i = b;i<=e;i++){
//                char ch = sb.charAt(i);
//                if (d==1){
//                    if (ch=='z'){
//                        sb.setCharAt(i,'a');
//                    }else {
//                        sb.setCharAt(i,(char)(ch+1));
//                    }
//                }else{
//                    if (ch=='a'){
//                        sb.setCharAt(i,'z');
//                    }
//                     else {
//                        sb.setCharAt(i,(char)(ch - 1));
//                    }
//                }
//            }
//        }
//        return sb.toString();
//    }

    public static void main(String[] args) {
        String s = "abc";
        int[][] arr = {{0,1,0}, {1, 2, 1},{0,2,1}};
        System.out.println(letterShifting(s, arr));
    }

    public static String letterShifting(String s, int[][] shifts) {
        int n = s.length();
        int[] shift = new int[n + 1];

        for (int[] shiftOp : shifts) {
            int start = shiftOp[0];
            int end = shiftOp[1];
            int direction = shiftOp[2];

            if (direction == 1) {
                shift[start]++;
                if (end + 1 < n) shift[end + 1]--;
            } else {
                shift[start]--;
                if (end + 1 < n) shift[end + 1]++;
            }
        }

        StringBuilder sb = new StringBuilder(s);
        int cumulativeShift = 0;
        for (int i = 0; i < n; i++) {
            cumulativeShift += shift[i];
            char ch = sb.charAt(i);

            int totalShift = cumulativeShift % 26;
            if (totalShift != 0) {
                ch = (char) ((ch - 'a' + totalShift + 26) % 26 + 'a');
            }
            sb.setCharAt(i, ch);
        }

        return sb.toString();
    }
    }


