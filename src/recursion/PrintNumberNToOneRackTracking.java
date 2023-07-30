package recursion;

public class PrintNumberNToOneRackTracking {

    public static void main(String[] args) {
        int n=4;
        printNumber(n);
    }

    private static void printNumber(int n) {
        if(n<1)return;
        System.out.print(n +" ");
        printNumber(n-1);

    }

}
