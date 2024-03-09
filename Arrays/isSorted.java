package striverDSA.Arrays;

import java.util.Scanner;

public class isSorted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ;i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(BruteForce(arr));
//        System.out.println(BetterSol(arr));
        System.out.println(OptimizeSol(arr));
    }
    public static boolean BruteForce(int[] arr){
        int n = arr.length;
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                if(arr[1]>arr[0]){
                    if(arr[j]<arr[i]){
                        return false;
                    }
                }
                else{
                    if(arr[j]>arr[i]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static boolean OptimizeSol(int[] arr){
        int n = arr.length;
//        boolean flag = true;
        for(int i=1;i<n;i++){
            if(arr[1]>arr[0]){
                if(arr[i]<arr[i-1]){
                    return false;
                }
            }
            else{
                if(arr[i]>arr[i-1]){
                    return false;
                }
            }

        }
        return true;
    }
}
