import java.util.*;

public class LCS2 {

    private static int lcs2(int[] a, int[] b) {
        int[][] answers = new int[a.length+1][b.length+1];
        int max = 0;
        for (int i = 0; i < a.length+1; i++) {
            answers[i][0] = 0;
        }

        for (int j = 0; j < b.length+1 ; j++) {
            answers[0][j] = 0;
        }

        for (int i = 1; i < a.length+1; i++ ) {
            for (int j = 1; j < b.length + 1; j++) {
                if (a[i-1] == b[j-1]) {
                    answers[i][j] = 1 + answers[i-1][j-1];
                } else {
                    answers[i][j] = Math.max(answers[i-1][j], answers[i][j-1]);
                }

                max = Math.max(max, answers[i][j]);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b));
    }
}

