import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
int[][] table = new int[w.length][W+1];
        for(int r=0;r< w.length;r++){
          for (int c = 0; c<= (W);c++){
           if (w[r] > c){
             if (r == 0){
             table[r][c] = table[r][c];
             }else {
             table[r][c] = table[r-1][c];
             }
           }else if(w[r] <= c){
             if (r == 0){
                table[r][c] = w[r];
             }else {
             table[r][c] = Math.max((w[r]+table[r-1][c-w[r]]),table[r-1][c]);
             }
           }

          }
        } 
        //  System.out.print("0 1 2 3 4 5 6 7 8 9 10");
        //  System.out.println();

        //  for(int r=0;r< w.length;r++){
        //   for (int c = 0; c<= W;c++){
        //     System.out.print(table[r][c] + " ");
        //    }
        //     System.out.println();

        //  }
        return table[w.length-1][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

