package recursion;

public class PrintNumberNToOne {

    public static void main(String[] args) {
        int n=1;
        printNumber(n);
    }

    private static void printNumber(int n) {
        if(n>4)return;
        printNumber(n+1);
        System.out.print(n +" ");

    }

}
