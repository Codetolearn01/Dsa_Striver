package striverDSA.Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class removeDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }


        /*List<Integer> temp = BetterSol(arr);
        int m = temp.size();
        for (Integer integer : temp) {
            System.out.print(integer + " ");
        }
        for (int i = 0; i<m; i++) {
            System.out.print(temp.get(i) + " ");
        } */

            //Brute Force approch
//        int k = BruteForce(arr);
//        for(int i =0;i<k;i++){
//            System.out.print(arr[i]+" ");
//        }

            //Better approch
//        System.out.println(BetterSol(arr));

//            //Optimize solution
        int p = OptimizeSol(arr);
        for(int i =0;i<p;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static int BruteForce(int[] arr){
        HashSet < Integer > set = new HashSet< >();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int k = set.size();
        int j = 0;
        for (int x: set) {
            arr[j++] = x;
        }
        return k;
        //time complexity : O(Nlog(N)+N)
        //space complexity : O(n)
    }
    public static List<Integer> BetterSol(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> temp = new ArrayList<>();
        int i = 0;
        int j = 1;
        int count = 1;
        temp.add(arr[0]);

        while (i < n && j < n) {
            if (arr[i] != arr[j]) {
                i = j;
                temp.add(arr[i]);
                count++;
            }
            j++;
        }
        System.out.println(count);
        return temp;
        //time complexity : O(n)
        //space complexity : O(n) [ due to temp array to store a new array ]
    }
    public static int OptimizeSol(int[] arr){
        int n = arr.length;
        int i = 0;
        for(int j = 1;j<n;j++){
            if(arr[j]!=arr[i]){
                i++;
                arr[i]=arr[j];
            }
        }
        return i+1;
    }
    //time complexity : O(n)
    //space complexity : O(1)

}

