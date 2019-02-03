public class recursion{
    /*You may write additional private methods */

    /*Recursively find the sqrt using Newton's approximation
     *tolerance is the allowed percent error the squared answer is away from n.
     *precondition: n is non-negative

    */

    private static boolean check(double actual, double guess, double tolerance){
      if (Math.abs(guess - actual) / actual * 100 <= tolerance){
        return true;
      }
      return false;
    }


    public static double sqrt(double n, double tolerance){
      return 0.0;
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
        return fib(n - 2) + fib(n - 1);
      }
    }

    /*As Per classwork*/
    // public static ArrayList<Integer> makeAllSums(){
    //   ArrayList<Integer> a = new ArrayList<Integer>();
    //   return a;
    // }


    public static void main (String args[]){
      for(int i = 0; i < 10; i++){
        System.out.println(fib(i));
      }
    }

}
