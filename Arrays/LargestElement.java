package striverDSA.Arrays;

import com.sun.security.jgss.GSSUtil;

import java.util.Arrays;
import java.util.Scanner;

public class LargestElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ;i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(BruteForce(arr));
        System.out.println(OptimizeSol(arr));

    }
    public static int BruteForce(int[] arr){
        Arrays.sort(arr); // first we need to sort the array and
        // we return last element
        return arr[arr.length-1];
        //time complexity : O(n)
        // space complexity : O(n)
    }
    public static int OptimizeSol(int[] arr){
        int n = arr.length;
        int max = arr[0];
        for(int i = 1;i<n ;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
        // time complexity : O(n)
        // space complextiy : O(1)
    }
}
