import java.util.*;
import java.io.*;

public class MajorityElement {

    static int count(int[] a, int left, int right, int element){
	 int count = 0;
	for (int i = left; i <= right; i++){
		if (a[i] == element){
			count++;
		}
	}
	return count;
}
    private static int getMajorityElement(int[] a, int left, int right) {
	if (left > right) {
        return -1;
        };
	if (left == right){
        return a[left];
    } 
        int mid = left + (right - left) / 2;
        int leftCount = getMajorityElement(a, left, mid);
	    int rightCount = getMajorityElement(a, mid + 1, right); 
        if (leftCount == -1 && rightCount != -1){
            int num = count(a,left,right,rightCount);
            if (num > (right-left +1) / 2){
                return rightCount;
            }else {
                return -1;
            }
        }else if (rightCount == -1 && leftCount != -1){
            int num = count(a,left,right,leftCount);
            if (num > (right-left +1) / 2){
                return leftCount;
            }else {
                return -1;
            }
        }else if (leftCount != -1 && rightCount != -1){
            int leftNum = count(a,left,right,leftCount);
            int RighttNum = count(a,left,right,rightCount);
            if (leftNum > (right-left +1) / 2){
                return leftCount;
            }else if (RighttNum > (right-left +1) /2){
                return rightCount;
            }else {
                return -1;
            }
        }else {
            return -1;
        }
    }

    private static int NaiveSolution( int[] a,int n){

        for (int i=0;i<n;i++){
            int count = 0;
            for (int j=0;j<n;j++){
                if (a[i] == a[j]){
                    count++;
                }
            }
            if (count > n/2){
                return 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        // if (NaiveSolution(a,a.length) != -1) {
        //     System.out.println(1);
        // } else {
        //     System.out.println(0);
        // }
          if (getMajorityElement(a,0,a.length-1) == -1) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

