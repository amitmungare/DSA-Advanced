package recursion;

public class PrintNumberFromOneToN {

    public static void main(String[] args) {
        int n=1;
        printNumber(n);
    }

    private static void printNumber(int n) {
        if(n>4)return;
        System.out.print(n +" ");
        n++;
        printNumber(n);
    }

}
