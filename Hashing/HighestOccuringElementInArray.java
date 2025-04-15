package Hashing;

import java.util.Scanner;

public class HighestOccuringElementInArray {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        scanner.close();


        int[] frequency = new int[100001];
        for(int i = 0; i < n; i++){
            frequency[arr[i]]++;
        }

        int maxFrequency = 0;
        int maxFrequencyElement = 0;
        for(int i = 0; i < n; i++){
            if(frequency[arr[i]] > maxFrequency){
                maxFrequency = frequency[arr[i]];
                maxFrequencyElement = arr[i];
            }
        }

        System.out.println("Highest occurring element in the array is " + maxFrequencyElement + " with a frequency of " + maxFrequency);
        
    }
}
