package Algorithm.LC.Easy;
import java.util.Scanner;
public class CountPrime {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = countPrime(sc.nextInt());
        System.out.println(N);
    }
    private static int countPrime(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }

        return count;
    }
}
