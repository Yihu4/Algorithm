//题目描述
//        本题要求计算A/B，其中A是不超过1000位的正整数，B是1位正整数。你需要输出商数Q和余数R，使得A = B * Q + R成立。
//
//        输入描述:
//        输入在1行中依次给出A和B，中间以1空格分隔。
//
//
//        输出描述:
//        在1行中依次输出Q和R，中间以1空格分隔。
//
//        输入例子:
//        123456789050987654321 7
//
//        输出例子:
//        17636684150141093474 3

package Algorithm.PAT.B;

import java.math.BigInteger;
import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class B07AdivideB {
    int R = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        int B = sc.nextInt();
        bigDiv(A, B);
    }

    private static void bigDiv(String A, int B) {
        StringBuilder Q = new StringBuilder();

        char[] cA = A.toCharArray();
        int r = 0;
        int a;
        for (char l : cA) {
            a = r * 10 + Integer.parseInt(String.valueOf(l));//返回用十进制参数表示的整数值 返回指定数组中表示该字符序列的 String。
            System.out.println(a);
            Q.append(a / B);
            System.out.println(Q);
            r = a % B;
        }
        while (Q.charAt(0) == '0')
            Q.delete(0, 1);//public delete(int start, int end)
        System.out.println(Q.toString() + " " + r);
    }

}
