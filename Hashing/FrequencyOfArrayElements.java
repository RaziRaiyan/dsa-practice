package Hashing;

import java.util.HashMap;
import java.util.Scanner;

public class FrequencyOfArrayElements {
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

        for(int i = 0; i < n; i++){
            if(frequency[arr[i]] > 0){
                System.out.println("Frequency of " + arr[i] + " is " + frequency[arr[i]]);
                frequency[arr[i]] = 0;
            }
        }

        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for(int i = 0; i < n; i++){
            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
        }

        for(int i = 0; i < n; i++){
            if(frequencyMap.containsKey(arr[i])){
                System.out.println("Frequency of " + arr[i] + " is " + frequencyMap.get(arr[i]));
                frequencyMap.remove(arr[i]);
            }
        }
    }
}