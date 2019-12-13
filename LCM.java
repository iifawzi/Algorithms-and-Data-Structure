import java.util.*;

public class LCM {
  private static long lcm_naive(int a, int b) {
    int large,small;
    if (a >= b){
      large = a;
      small = b;
    }else {
      large = b;
      small = a;
    }
    if ( (a == 0) || (b == 0)){
      return 0;
    }
    long i = large;
  while(i % small != 0){
    i += large;
  }
  return i;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm_naive(a, b));
  }
}

