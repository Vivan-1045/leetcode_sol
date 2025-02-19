package Matrix;

import java.util.Arrays;

public class leetcode_73 {
    public static void main(String[] args) {
        int [][] arr = {{1,1,1,0},{1,0,1,1},{0,1,1,1}};
        setZeros(arr);
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
}
