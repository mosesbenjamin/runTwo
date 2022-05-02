package DynamicProgramming;

public class ClassicFibonacciNumber {
    // Using recursion
    public int fibonacci(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        int left = fibonacci(n-1);
        int right = fibonacci(n-2);
        return left + right;
    }

    public static void main(String[] args) {
        ClassicFibonacciNumber fib = new ClassicFibonacciNumber();
        System.out.println(fib.fibonacci(7));
    }
}
