import java.util.*;
import java.io.*;

public class Partition3 {
    private static int partition3(int[] A) {
        int sum = 0; 
        int i,j; 
        for (i = 0; i < A.length; i++) {
            sum += A[i]; 
        }
        if (sum %3 != 0) {
            return 0; 
        }
        int part[][]=new int[sum/3+1][A.length+1]; 
        for (i = 0; i <= A.length; i++) {
            part[0][i] = 1; 
        }
        for (i = 1; i <= sum/3; i++) {
            part[i][0] = 0; 
        }
     for (i = 1; i <= sum/3; i++) 
        { 
            for (j = 1; j <= A.length; j++) 
            { 
                part[i][j] = part[i][j-1]; 
                if (i >= A[j-1]) 
                    part[i][j] = Math.max(part[i][j],part[i - A[j-1]][j-1]); 
            } 
        }
        return part[sum/3][A.length]; 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(partition3(A));
    }
}