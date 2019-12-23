import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {
        int[] myCoins = {1,3,4}; 
        int values[] = new int[m + 1]; 
        values[0] = 0; 
        for (int i = 1; i <= m; i++) 
        values[i] = Integer.MAX_VALUE; 
        for (int i = 1; i <= m; i++) 
        { 
            for (int j = 0; j < myCoins.length; j++) 
            if (myCoins[j] <= i) 
            { 
                int subr = values[i - myCoins[j]]; 
                if (subr != Integer.MAX_VALUE  
                       && subr + 1 < values[i]) 
                       values[i] = subr + 1;    
            } 
              
        } 
        return values[m]; 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

