//题目描述
//        本题要求你写个程序把给定的符号打印成沙漏的形状。例如给定17个“*”，要求按下列格式打印
//
//        *****
//        ***
//        *
//        ***
//        *****
//        所谓“沙漏形状”，是指每行输出奇数个符号；各行符号中心对齐；相邻两行符号数差2；符号数先从大到小顺序递减到1，再从小到大顺序递
//        增；首尾符号数相等。
//
//        给定任意N个符号，不一定能正好组成一个沙漏。要求打印出的沙漏能用掉尽可能多的符号。
//
//        输入描述:
//        输入在一行给出1个正整数N（<=1000）和一个符号，中间以空格分隔。
//
//
//        输出描述:
//        首先打印出由给定符号组成的最大的沙漏形状，最后在一行中输出剩下没用掉的符号数。
//
//        输入例子:
//        19 *
//
//        输出例子:
//        *****
//        ***
//        *
//        ***
//        *****
//        2
package Algorithm.PAT.B;

import java.util.Scanner;

public class B17PrintSandGlass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String str = sc.next();
        int count = -1;
        int remian;
        int T = N;
        if (T==1)
                count=1;
        else{
            for (int i = 1; T > 0; i = i + 2) {
                if (i == 1) {
                    T -= i;
                    count++;
                } else {
                    T -= i * 2;
                    count++;
                }
            }

        }
        remian = N - (count * 2 * count / 2) * 2 + 1;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < (count-i) * 2 - 1; k++) {
                System.out.print(str);
            }
            System.out.println();
        }
        for (int i = 1; i < count; i++) {
            for (int j = 0; j < count-i-1; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < (i+1) * 2 - 1; k++) {
                System.out.print(str);
            }
            System.out.println();
        }
        System.out.println(remian);
    }
}
