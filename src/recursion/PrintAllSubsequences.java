package recursion;

import java.util.ArrayList;

public class PrintAllSubsequences {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        printAllSubsequences(0, new ArrayList<Integer>(), arr);
    }

    private static void printAllSubsequences(int i, ArrayList<Integer> ds, int[] arr) {

        if(i==arr.length){
            for(int k:ds) System.out.print(k+" ");
            System.out.println();
            return;
        }

        ds.add(arr[i]);
        printAllSubsequences(i+1, ds, arr);
        ds.remove(ds.size()-1);
        printAllSubsequences(i+1, ds, arr);
    }

    private static int countTheNumberOfSubsequenceEqualToSum(int i, int sumCount, int sum, int[] arr) {

        if(i==arr.length){
            if(sum==sumCount)return 1;
            else return 0;
        }

        sumCount+=arr[i];
        int l = countTheNumberOfSubsequenceEqualToSum(i+1, sumCount, sum, arr);

        sumCount-=arr[i];
        int r = countTheNumberOfSubsequenceEqualToSum(i+1, sumCount, sum, arr);

        return l+r;
    }

    private static void printAllSubsequencesEqualToSum(int i, int sumCount, int sum, ArrayList<Integer> list, int[] arr) {

        if(i==arr.length){
            if(sum==sumCount){
                for(int k:list) System.out.print(k+" ");
                System.out.println();
            }
            return;
        }

        sumCount+=arr[i];
        list.add(arr[i]);
        printAllSubsequencesEqualToSum(i+1, sumCount, sum, list, arr);

        sumCount-=arr[i];
        list.remove(list.size()-1);
        printAllSubsequencesEqualToSum(i+1, sumCount, sum, list, arr);

    }

    private static boolean printOneSubsequenceEqualToSum(int i, int sumCount, int sum, ArrayList<Integer> list, int[] arr) {

        if(i==arr.length){
            if(sum==sumCount){
                for(int k:list) System.out.print(k+" ");
                System.out.println();
                return true;
            }
            else return false;
        }

        sumCount+=arr[i];
        list.add(arr[i]);
        if(printOneSubsequenceEqualToSum(i+1, sumCount, sum, list, arr))return true;

        sumCount-=arr[i];
        list.remove(list.size()-1);
        if(printOneSubsequenceEqualToSum(i+1, sumCount, sum, list, arr))return true;

        return false;
    }


}
