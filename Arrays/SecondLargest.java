package striverDSA.Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class SecondLargest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ;i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(BruteForce(arr));
        System.out.println(BetterSol(arr));
        System.out.println(OptimizeSol(arr));

    }
    public static int BruteForce(int[] arr){
        Arrays.sort(arr);
        return arr[arr.length-2];
        //time complexity : O(n)
        // space complexity : O(n)
    }
    public static int BetterSol(int[] arr){
        int n = arr.length;
        int firstL = 0;
        int secondL = 0;
        //we need to find first Largest and
        for(int i = 1 ;i<n;i++){
            if(arr[i] > arr[firstL]){
                secondL = firstL;
                firstL = i;
            }
        }
        //next we need to find second largest
        for(int j =0;j<n;j++){
            if(j!=firstL && arr[j]>arr[secondL]){
                secondL = j;
            }
        }
        return arr[secondL];
        //time complexity : O(n)+O(n)
        // space complexity : O(1)
    }

    public static int OptimizeSol(int[] arr){
        int n = arr.length;
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for(int i =0 ;i<n;i++){
            if(arr[i]>largest){
                secondLargest = largest;
                largest = arr[i];
            }
            else if(arr[i]!=largest && arr[i]>secondLargest){
                secondLargest = arr[i];
            }
        }
        return secondLargest;
        //time complexity : O(n)
        // space complexity : O(1)
    }
}
