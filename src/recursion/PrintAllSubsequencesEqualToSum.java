package recursion;

import java.util.ArrayList;

public class PrintAllSubsequencesEqualToSum {

    public static void main(String[] args) {
        int[] arr = {1,2,1};
        int sum=2;
        sub(0, 0, sum, new ArrayList<Integer>(), arr);
    }

    private static void sub(int i, int sumCount, int sum, ArrayList<Integer> list, int[] arr) {

        if(i==arr.length){
            if(sum==sumCount){
                for(int k:list) System.out.print(k+" ");
                System.out.println();
            }
            return;
        }

        sumCount+=arr[i];
        list.add(arr[i]);
        sub(i+1, sumCount, sum, list, arr);

        sumCount-=arr[i];
        list.remove(list.size()-1);
        sub(i+1, sumCount, sum, list, arr);

    }

}
