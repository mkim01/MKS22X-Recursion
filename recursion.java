public class recursion{
    /*You may write additional private methods */

    /*Recursively find the sqrt using Newton's approximation
     *tolerance is the allowed percent error the squared answer is away from n.
     *precondition: n is non-negative

    */

    private static boolean check(double n, double guess, double tolerance){
      double root = Math.sqrt(n);
      if (Math.abs(guess - root) / root * 100 <= tolerance){
        return true;
      }
      return false;
    }

    private static double approx(double n, double guess, double tolerance){
      if (check(n, guess, tolerance)){
        return guess;
      }
      else{
        return approx(n, (n / guess + guess) / 2, tolerance);
      }
    }

    public static double sqrt(double n, double tolerance){
        return approx(n, 1, tolerance);
    }

    /*Recursively find the n'th fibbonaci number in linear time
     *fib(0) = 1; fib(1) = 1; fib(5) = 5
     *precondition: n is non-negative
     */
     // 1 1 2 3 5 8 13 21 34
    public static int fib(int n){
      if (n == 0){
        return 1;
      }
      else if (n == 1){
        return 1;
      }
      else {
        return fibIteration(n);
      }
    }

    private static int fibIteration(int n){
      int f1 = 1;
      int f2 = 1;
      for (int i = 2; i < n; i++){
        int temp = f1 + f2;
        f1 = f2;
        f2 = temp;
      }
      return f2;
    }

    /*As Per classwork*/
    // public static ArrayList<Integer> makeAllSums(){
    //   ArrayList<Integer> a = new ArrayList<Integer>();
    //   return a;
    // }

    public static void main (String args[]){
       for(int i = 1; i < 10; i++){
         System.out.println(fib(i));
       }
      //System.out.println(sqrt(2.0, 0.001));
    }

}
