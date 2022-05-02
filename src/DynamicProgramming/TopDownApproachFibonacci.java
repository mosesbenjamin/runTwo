package DynamicProgramming;

// memoization technique
public class TopDownApproachFibonacci {
    public int fib(int[] memo, int n){
        if(memo[n] == 0){
            if(n < 2){
                memo[n] = n;
            } else{
                int left = fib(memo, n-1);
                int right = fib(memo, n-2);
                memo[n] = left + right;
            }
        }
        return memo[n];
    }

    public static void main(String[] args) {
        TopDownApproachFibonacci fib = new TopDownApproachFibonacci();
        System.out.println(fib.fib(new int[6 + 1], 6));
    }
}
