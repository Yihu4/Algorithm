//题目描述
//        输入两个非负10进制整数A和B(<=230-1)，输出A+B的D (1 < D <= 10)进制数。
//
//        输入描述:
//        输入在一行中依次给出3个整数A、B和D。
//
//
//        输出描述:
//        输出A+B的D进制数。
//
//        输入例子:
//        123 456 8
//
//        输出例子:
//        1103
package Algorithm.PAT.B;

import java.util.Scanner;

public class B12DDecimal {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int D = sc.nextInt();
        String str="";
        int C = A + B;
        while (C>0){
            int temp = C % D;
            str = temp + str;
            C = C / D;
        }
        System.out.println(str);
    }
}
