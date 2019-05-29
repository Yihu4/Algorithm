package Algorithm.LC;
import java.util.Scanner;
public class t {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = numJewelsInStones(sc.next(),sc.next());
        System.out.println(n);
    }
    private static int numJewelsInStones(String J, String S) {
        int[] s= new int[128];
        int count = 0;
        char[] c1 = J.toCharArray();
        char[] c2 = S.toCharArray();
        for(char i:c1) {
            s[i]=1;
        }
        for(char i:c2) {
            if(s[i]==1) {
                count++;
            }
        }
        return count;
    }
}
