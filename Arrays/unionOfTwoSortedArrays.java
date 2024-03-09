package striverDSA.Arrays;
import java.util.*;

public class unionOfTwoSortedArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for(int i =0;i<n;i++){
            arr1[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for(int j =0;j<m;j++){
            arr2[j] = sc.nextInt();
        }
        List<Integer> res = OptimalSol(arr1,arr2);
        //List<Integer> res = BruteForce(arr1,arr2);
        System.out.println(res);
    }
    public static List<Integer> BruteForce(int[] arr1, int[] arr2){
        int n = arr1.length;
        int m = arr2.length;
        HashSet<Integer> set = new HashSet<>();
        List<Integer> union = new ArrayList<>();
        for (int j : arr1) {
            set.add(j);
        }
        for (int i : arr2) {
            set.add(i);
        }
//        for(int it : set){
//            union.add(it);
//        }
        union.addAll(set);//we can use instead of above itereation
        return union;
    }
    public static List<Integer> OptimalSol(int[] arr1 , int[] arr2){
        int n = arr1.length;
        int m = arr2.length;
        List<Integer> union = new ArrayList<>();
        int i =0;
        int j =0;
        while(i<n && j<m){
            if(arr1[i]<=arr2[j]){
                if(union.isEmpty() || union.getLast()!=arr1[i]){
                    union.add(arr1[i]);
                }
                i++;
            }

            else{
                if(union.isEmpty() || union.getLast()!=arr2[j]){
                    union.add(arr2[j]);

                }
                j++;
            }
        }
        while(i<n){
            if(union.isEmpty() || union.getLast()!=arr1[i]){
                union.add(arr1[i]);

            }
            i++;
        }
        while(j<m){
            if(union.isEmpty() || union.getLast()!=arr2[j]){
                union.add(arr2[j]);

            }
            j++;
        }
        return union;
        //Time complexity : O(n+m)
        //Space complexity : O(1)
    }
}
