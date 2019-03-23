/*数素数 (20)
题目描述
令Pi表示第i个素数。现任给两个正整数M <= N <= 10000，请输出PM到PN的所有素数。
输入描述:
输入在一行中给出M和N，其间以空格分隔。
输出描述:
输出从PM到PN的所有素数，每10个数字占1行，其间以空格分隔，但行末不得有多余空格。
输入例子:
5 27
输出例子:
11 13 17 19 23 29 31 37 41 43
47 53 59 61 67 71 73 79 83 89
97 101 103
 */

package Algorithm.PAT.B;

import java.util.Scanner;

public class B03CountPrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int begin = sc.nextInt();
        int end = sc.nextInt();
        int[] array = new int[end];
        int index = 0;
        int i = 2;
        while (index < end) {
            if (Isprime(i)) {
                array[index] = i;
                index++;
            }
            i++;
        }
        int ten = 0;
        for (int j = (begin - 1); j < end; j++) {
            System.out.print(array[j]);
            ten++;
            if (ten % 10 == 0) {
                System.out.println();
                continue;
            }
            if (j != end - 1) {
                System.out.print(" ");
            }
        }


    }

    public static boolean Isprime(int n) {
        if (n == 1) {
            return false;
        } else if (n == 2) {
            return true;
        } else if (n % 2 == 0) {
            return false;
        } else {
            for (int i = 3; i <= (int) Math.sqrt(n); i += 2) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
