package striverDSA.Arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class moveZerosToEnd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int[] ptr = BruteForce(arr);
//        int[] ptr = BetterSol(arr);
//        int[] ptr = OptimalSol(arr);
        for(int i =0;i<n;i++){
            System.out.print(ptr[i]+" ");
        }
    }
    public static int[] BruteForce(int[] arr){
        int n = arr.length;
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i =0;i<n;i++){
            if(arr[i]!=0){
                temp.add(arr[i]);
            }
        }
        int nz = temp.size();
        for(int i =0;i<nz ;i++){
            arr[i] = temp.get(i);
        }
        for(int i =nz;i<n;i++){
            arr[i]=0;
        }
        return arr;
        //Time complexity : O(2n)
        //Space complexity : O(n)
    }
    public static int[] BetterSol(int[] arr){
        int n = arr.length;
        for(int i =0;i<n;i++){
            int j = i;
            while(j>0 && arr[j-1]==0 && arr[j]!=0){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
        return arr;
        //Time complexity : O(n^2)
        //Space complexity : O(1)
    }
    public static int[] OptimalSol(int[] arr){
        int n = arr.length;
        int j = -1;
        for(int i =0;i<n;i++){
            if(arr[i]==0){
                j = i;
                break;
            }
        }
        if(j == -1) return arr;

        for(int i = j+1 ;i<n;i++){
            if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        return arr;
        //Time complexity : O(n)
        //Space complexity : O(1)
    }

}
