package PracticeArrays.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

// You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

// Example 1:
// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [[7,4,1],[8,5,2],[9,6,3]]
// Example 2:


// Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
// Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

public class RotateMatrix {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N;
        System.out.println("Enter the size of square matrix: ");
        N = scanner.nextInt();

        int[][] matrix = new int[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                matrix[i][j] = scanner.nextInt();
            }
        }

        scanner.close();

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                list.add(matrix[i][j]);
            }
        }
        
    }

    public static void rotateMatrix90Degree(int[][] matrix, int N){
        for(int i=0; i<N/2; i++){
            for(int j=i; j<N-1-i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[N-1-j][i];
                matrix[N-1-j][i] = matrix[N-1-i][N-1-j];
                matrix[N-1-i][N-1-j] = matrix[j][N-1-i];
                matrix[j][N-1-i] = temp;
            }
        }
    }

    public static void rotateMatrix180Degree(int[][] matrix, int N){
        for(int i=0; i<N/2; i++){
            for(int j=i; j<N-1-i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[N-1-i][N-1-j];    
                matrix[N-1-i][N-1-j] = temp;

                temp = matrix[j][N-1-i];
                matrix[j][N-1-i] = matrix[N-1-j][i];
                matrix[N-1-j][i] = temp;
            }
        }
    }
}
