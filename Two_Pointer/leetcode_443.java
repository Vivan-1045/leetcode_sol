package Two_Pointer;


public class leetcode_443 {
    public static void main(String[] args) {
        char[] arr = {'a','a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(compressedLength(arr));
    }
    public static int compressedLength(char [] arr){

        int write = 0;
        int i = 0;

        while (i < arr.length) {
            char currentChar = arr[i];
            int count = 0;
            int j = i;

            while (j < arr.length && arr[j] == currentChar) {
                count++;
                j++;
            }

            arr[write++] = currentChar;

            if (count > 1) {
                String countStr = Integer.toString(count);
                for (int k = 0; k < countStr.length(); k++) {
                    arr[write++] = countStr.charAt(k);
                }
            }

            i = j;
        }

        return write;
    }
}
