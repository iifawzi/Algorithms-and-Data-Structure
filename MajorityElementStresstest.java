import java.util.*;
import java.io.*;

public class MajorityElementStresstest {

    static int count(int[] a, int left, int right, int element){
	 int count = 0;
	for (int i = left; i <= right; i++){
		if (a[i] == element){
			count++;
		}
	}
	return count;
}
    5 1 2 2 2 2 
    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
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
        int max = 10; 
        int min = 1; 
        int arrlen = 10;
        int range = max - min + 1; 
        int[] a = new int[arrlen];
        for (int i=0;i<10;i--){ 
        for (int j = 0; j < arrlen; j++) { 
        int rand = (int)(Math.random() * range) + min; 
        a[j] = rand;
        } 
            for (int c = 0;c<a.length;c++){
                System.out.print(a[c] + " ");
            }
            int x = NaiveSolution(a,a.length);
            int y = getMajorityElement(a,0,a.length-1);
                System.out.println();
                System.out.println(x);
                System.out.println(y);
            if ((x == -1) && (y != -1) || (x != -1) && (y == -1)){
                System.out.println("error");
                
                break;
            }
            System.out.println();
    } 
        }
}

