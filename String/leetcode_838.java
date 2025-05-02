package String;
public class leetcode_838 {
    public static void main(String[] args) {
        String s = "RR.L";
        System.out.println(pushDomino(s));
    }
    public static String pushDomino(String s) {
        int n = s.length();
        int[] R = new int[n + 1];
        int[] L = new int[n + 1];


        char prev = '.';
        int count = 1;
        for (int i = 0; i < n; i++) {
            if (prev == 'R' && s.charAt(i) == '.') { //if prev == 'R' and current is '.' it means R will exert force on currrnt domino
                R[i] = count;  // Store the force in R arr
                count++;   // force = count
            } else {
                R[i] = 0;  // Otherwise store force = 0
                prev = s.charAt(i); // But update the previous element by current element
                count = 1; // also reset the count = 1
            }
        }
        prev = '.';
        count = 1;

        //For Left array do the similor as Right array i.e above
        for (int i = n - 1; i >= 0; i--) {
            if (prev == 'L' && s.charAt(i) == '.') {
                L[i] = count;
                count++;
            } else {
                L[i] = 0;
                prev = s.charAt(i);
                count = 1;
            }
        }

        StringBuilder ans = new StringBuilder();

        //Compare both array
        //Append 'L' if R[i] == 0 && L[i] != 0 or L[i] < R[i] && L[i] != 0
        //Append 'R' if L[i] == 0 && R[i] != 0 or R[i] < L[i] && R[i] != 0
        //Append current Character if L[i] == R[i]

        for (int i = 0; i < n; i++) {
            if ((R[i] == 0 && L[i] != 0) || (L[i] < R[i] && L[i] != 0)) {
                ans.append('L');
            } else if ((L[i] == 0 && R[i] != 0) || (R[i] < L[i] && R[i] != 0)) {
                ans.append('R');
            } else if (L[i] == R[i]) {
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();
    }
}
