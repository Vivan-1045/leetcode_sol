package Contests;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class weekly_454 {
    public static void main(String[] args) {
        int [] arr = {0,1,0,0};
        System.out.println(triplet(arr));
    }
    public static String cap(String caption){
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("[^a-zA-Z]+");
        String[] words = pattern.split(caption);

        boolean fw = true;

        for (String word : words) {

            String et = "";
            for (char c : word.toCharArray()) {
                if (Character.isLetter(c)) {
                    et += c;
                }
            }

            if (et.isEmpty()) {
                continue;
            }

            if (fw) {
                sb.append(et.toLowerCase());
                fw = false;
            } else {
                sb.append(Character.toUpperCase(et.charAt(0)));
                sb.append(et.substring(1).toLowerCase());
            }
        }

        StringBuilder finalTag = new StringBuilder("#");
        finalTag.append(sb.toString());


        String ft = finalTag.toString();
        if (finalTag.length() > 100) {
            return ft.substring(0, 100);
        } else {
            return ft;
        }
    }

    static int MOD = 1_000_000_07;
    public static int tripletCount(int[] arr){
        int count = 0;
        for (int i = 0;i<arr.length;i++){
            for (int j = i+1;j<arr.length;j++){
                if (arr[i]==2*arr[j]){
                    for (int k = j+1;k<arr.length;k++){
                        if (arr[k] == 2*arr[j]){
                            count += 1;
                        }
                    }
                }
            }
        }
        return count%MOD;
    }

    public static int triplet(int[] arr) {
        int count = 0;
        Map<Integer, Integer> RfreqMap = new HashMap<>();
        Map<Integer, Integer> LfreqMap = new HashMap<>();


        for (int i = 0; i < arr.length; i++) {
            RfreqMap.put(arr[i], RfreqMap.getOrDefault(arr[i], 0) + 1);
        }

        for (int j = 0; j < arr.length; j++) {
            int val = arr[j];
            long target = 2L * val;

            if (target > Integer.MAX_VALUE) {
                RfreqMap.put(val, RfreqMap.get(val) - 1);
                if (RfreqMap.get(val) == 0) {
                    RfreqMap.remove(val);
                }
                LfreqMap.put(val, LfreqMap.getOrDefault(val, 0) + 1);
                continue;
            }

            RfreqMap.put(val, RfreqMap.get(val) - 1);
            if (RfreqMap.get(val) == 0) {
                RfreqMap.remove(val);
            }

            int ca = RfreqMap.getOrDefault((int) target, 0);
            int cb = LfreqMap.getOrDefault((int) target, 0);
            count = (int) ((count + (long) cb * ca) % MOD);

            LfreqMap.put(val, LfreqMap.getOrDefault(val, 0) + 1);
        }
        return count;
    }

    public static int code(){
        return 0;
    }
}
