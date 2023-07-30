package recursion;

public class PrintNumberFromOneToNBackTracking {

    public static void main(String[] args) {
        int n=4;
        printNumber(n);
    }

    private static void printNumber(int n) {
        if(n<1)return;
        printNumber(n-1);
        System.out.print(n +" ");
    }

}
