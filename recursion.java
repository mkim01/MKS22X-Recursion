import java.util.ArrayList;
import java.util.List;

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
      if (n == 0){
        return 0;
      }
      if (check(n, guess, tolerance)){
        return guess;
      }
        return approx(n, (n / guess + guess) / 2, tolerance);
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
      return fibhelper(n, 0, 1);
    }

    public static int fibhelper(int n, int f1, int f2){
      if (n == 0){
        return f1;
      }
      else if (n == 1){
        return f2;
      }
      else {
        int temp = f1 + f2;
        f1 = f2;
        f2 = temp;
        return fibhelper(n - 1, f1, f2);
      }
    }

    // private static int fibIteration(int n){
    //   int f1 = 1;
    //   int f2 = 1;
    //   for (int i = 2; i < n; i++){
    //     int temp = f1 + f2;
    //     f1 = f2;
    //     f2 = temp;
    //   }
    //   return f2;
    // }

    /*As Per classwork*/
     public static ArrayList<Integer> makeAllSums(int n){
       ArrayList<Integer> allsums = new ArrayList<Integer>();
       summation(n, 0, allsums);
       return allsums;
    }

    private static void summation(int index, int sum, ArrayList<Integer> array){
      if (index == 0){
        array.add(sum);
      }
      else {
        summation(index - 1, sum + index, array);
        summation(index - 1, sum, array);
      }
    }

    public static boolean closeEnough(double a, double b){
      if(a==0.0 && b==0.0)return true;
      if(a==0.0)return b < 0.00000000001;
      if(b==0.0)return a < 0.00000000001;
      return Math.abs(a-b)/a < 0.0001;//This is the normal % difference allowed
    }

    public static void testFib(int testcase){
    recursion r = new recursion();
    int[] input = {0,1,2,3,5,30};
    int[] output ={0,1,1,2,5,832040};
    int max = input.length;
    if(testcase < input.length){
      int in = input[testcase];
      try{

        int ans = r.fib(in);
        int correct = output[testcase];
        if(ans == correct){
          System.out.println("PASS test fib "+in+". "+correct);
        }
        else{
          System.out.println("FAIL test fib"+in+". "+ans+" vs "+correct);

        }
      }catch(IllegalArgumentException n){
        if(in < 0){
          System.out.println("PASS test fib"+in+" IllegalArgumentException");
        }else{
          System.out.println(" FAIL IllegalArgumentException in test case:"+in);
        }
      }catch(Exception e){
        System.out.println(" FAIL Some exception in test case:"+in);
    }
  }
}
  public static void testSqrt(int testcase){
    recursion r = new recursion();
    double[] input = {0.0,1.0, 2.0, 4.0, 7.0};
    double[] output = {0.0,1.0,1.4142135623730951,2.0,2.6457513110645907};
    int max = input.length;
    if(testcase < input.length){
    double in = input[testcase];
    try{
    double ans = r.sqrt(in,.00001);
    double correct = Math.sqrt(in);
    if(closeEnough(ans,correct)){
      System.out.println("PASS test sqrt "+in+" "+ans);
      }
    else{
      System.out.println("FAIL test sqrt "+in+" "+ans+" vs "+correct);

      }
    }catch(IllegalArgumentException n){
    if(in < 0){
      System.out.println("PASS test sqrt"+in+" IllegalArgumentException");
    }else{
      System.out.println(" FAIL IllegalArgumentException in test case:"+in);
      }
    }catch(Exception e){
    System.out.println(" FAIL Some exception in test case:"+in);
      }
    }
  }

    public static void main (String args[]){
      for (int i = 0; i < 6; i++){
        testFib(i);
        testSqrt(i);
        }
      // for(int i = 1; i < 10; i++){
      //     System.out.println("fibbonaci number(" + i + "):");
      //     System.out.println(fib(i));
      // }
      //   System.out.println("sqare root of 2: " + Math.sqrt(2));
      //    System.out.println("approximation with tolerance of 0.001%" + "" + ": "+ sqrt(2.0, 1));
      //   System.out.println("sqare root of 3: " + Math.sqrt(3));
      //    System.out.println("sqare root of 3 with tolerance of 0.001%" + "" + ": "+ sqrt(3.0, 1));
      //
      //
      // for (int i = 0; i < 5; i++){
      //     System.out.println("all possible sums from 1 to" + i + makeAllSums(i));
      // }
  }
}
