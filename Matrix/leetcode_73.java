package Matrix;

import java.util.Arrays;

public class leetcode_73 {
    public static void main(String[] args) {
        int [][] arr = {{1,1,1},{1,0,1},{1,1,1}};
        setZeros(arr);

        System.out.println(Arrays.deepToString(solve(arr)));

    }
    public static void setZeros(int[][] mat){
        int x = 0,y=0;

        //make a copy of mat arr
        int [][]copy = new int[mat.length][];
        for (int i = 0;i<mat.length;i++){
            copy[i] = Arrays.copyOf(mat[i],mat[i].length);
        }


        //find Zero's coordinates in mat array
        for(int i = 0 ;i<mat.length;i++){
            for (int j = 0;j<mat[i].length;j++){
                if (mat[i][j]==0){
                    //if in mat array zero found then make the entire row zero in copy array
                    for (int a = 0;a<copy[x].length;a++) {
                        copy[i][a]=0;
                    }
                    //if in mat array zero found then make the entire col zero in copy array
                    for (int b = 0;b<copy.length;b++) {
                        copy[b][j]=0;
                    }
                }
            }
        }

        //Now copy the content in mat array back from copy array
        for (int i = 0; i < mat.length; i++) {
            System.arraycopy(copy[i], 0, mat[i], 0, mat[i].length);
        }

        //print the array
        for(int[] row : mat){
            for (int element : row){
                System.out.print(element+ " ");
            }
            System.out.println();
        }
    }

    //In place constant space O(1)
    public static void ans(int[][] arr){
        int m = arr.length;
        int n = arr[0].length;

        boolean row1 = false;
        boolean col1 = false;

        for (int i = 0;i<m;i++) {
            if (arr[i][0] == 0) {
                col1 = true;
            }
        }

        for (int j = 0;j<n;j++){
            if (arr[0][j]==0){
                row1 = true;
            }
        }

        for (int i =1;i<m;i++){
            for (int j = 1;j<n;j++){
                if (arr[i][j] == 0){
                    arr[i][0] = 0;
                    arr[0][j] = 0;
                }
            }
        }

        for (int i = 1;i<m;i++){
            for (int j =1;j<n;j++){
                if (arr[i][0]==0||arr[0][j]==0){
                    arr[i][j] = 0;
                }
            }
        }
        if (col1) {
            for (int i =0;i<m;i++){
                    arr[i][0] = 0;
            }
        }
        if (row1){
            for (int j = 0;j<n;j++){
                arr[0][j] = 0;
            }
        }

        for(int[] row : arr){
            for (int element : row){
                System.out.print(element+ " ");
            }
            System.out.println();
        }

    }


    //Approach 3 O(m+n);

    public static int[][] solve(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;

        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    arr[i][j] = 0;
                }
            }
        }

        return arr;
    }

    public static void display(int[][]mat){
        for(int[] row : mat){
            for (int element : row){
                System.out.print(element+ " ");
            }
            System.out.println();
        }
    }
}
