package PracticeArrays.Medium;

import java.util.ArrayList;
import java.util.List;

public class PrintMatrix {
    public static void main(String[] args){
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printMatrixInSpiralOrder(int[][] matrix){
        int rowStart = 0;
        int rowEnd = matrix.length-1;

        int colStart = 0;
        int colEnd = matrix[0].length-1;
        

        List<Integer> list = new ArrayList<>();

        while(rowStart <= rowEnd && colStart <= colEnd){
            int i = rowStart;
            int j = colStart;
            while(j <= colEnd){
                list.add(matrix[i][j]);
                j++;
            }
            rowStart++;
            
            while(i <= rowEnd){
                list.add(matrix[i][j]);
                i++;
            }
            colEnd--;

            while(j >= colStart){
                list.add(matrix[i][j]);
                j--;
            }
            rowEnd--;

            while(i >= rowStart){
                list.add(matrix[i][j]);
                i--;
            }
            colStart++;
        }

        System.out.println(list);
    }
}
