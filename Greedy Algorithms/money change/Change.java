import java.util.Scanner;
import java.util.ArrayList;
public class Change {
    private static int getChange(int m) {
        int[] chan = new int[] {10,5,1};
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < chan.length; i++) {
            if (m >= chan[i]){
            int divv = m / chan[i];
            for (int n = 0;n<divv;n++){
                ans.add(chan[i]);
                m = m - chan[i];
                            }
            }  
}
return ans.size();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

