//题目描述
//        给定任一个各位数字不完全相同的4位正整数，如果我们先把4个数字按非递增排序，再按非递减排序，然后用第1个数字减第2个数字，将得到
//        一个新的数字。一直重复这样做，我们很快会停在有“数字黑洞”之称的6174，这个神奇的数字也叫Kaprekar常数。
//
//        例如，我们从6767开始，将得到
//
//        7766 - 6677 = 1089
//        9810 - 0189 = 9621
//        9621 - 1269 = 8352
//        8532 - 2358 = 6174
//        7641 - 1467 = 6174
//        ... ...
//
//        现给定任意4位正整数，请编写程序演示到达黑洞的过程。
//
//        输入描述:
//        输入给出一个(0, 10000)区间内的正整数N。
//
//
//        输出描述:
//        如果N的4位数字全相等，则在一行内输出“N - N = 0000”；否则将计算的每一步在一行内输出，直到6174作为差出现，输出格式见样例,每行中间没有空行。注意每个数字按4位数格
//        式输出。
//
//        输入例子:
//        6767
//
//        输出例子:
//        7766 - 6677 = 1089
//        9810 - 0189 = 9621
//        9621 - 1269 = 8352
//        8532 - 2358 = 6174
package Algorithm.PAT.B;

import java.util.Scanner;
import java.util.Arrays;

public class B09Kaprekar6174 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int res = 0;
        while (res != 6174) {
            twoValue t = sort(num);
            int left = t.val1;
            int right = t.val2;
            if (left == right) {
                System.out.printf("%04d - %04d = 0000\n", left, right);
                break;
            }
            res = left - right;
            System.out.printf("%04d - %04d = %04d\n", left, right, res);
            num = res;
        }

    }

    private static twoValue sort(int num) {
        int[] digit = new int[4];
        int left = 0;
        int right = 0;
        for (int i = 0; i < 4; i++) {
            digit[i] = num % 10;
            num /= 10;
        }
        Arrays.sort(digit);
        for (int i = 0; i < 4; i++) {
            left = left * 10 + digit[3 - i];
        }
        for (int i = 0; i < 4; i++) {
            right = right * 10 + digit[i];
        }
        return new twoValue(left, right);
    }

    //    private static int right(int num){
//        int[] digit = new int[4];
//        int res = 0;
//        for (int i = 0; i < 4; i++){
//            digit[i] = num % 10;
//            num /= 10;
//        }
//        Arrays.sort(digit);
//        for (int i = 0; i < 4; i++){
//            res = res*10 + digit[i];
//        }
//        return res;
//    }
    static class twoValue {
        int val1;
        int val2;

        twoValue(int val1, int val2) {
            this.val1 = val1;
            this.val2 = val2;
        }
    }
}

//public class B09Kaprekar6174 {
////    public static void main(String[] args) {
////        Scanner sc = new Scanner(System.in);
////        String num = sc.next();
////        num = String.format("%4s",num);
////        int res = 0;
////        while (res != 6174) {
////
////            char[] everynum = num.toCharArray();
////            Arrays.sort(everynum);
////            int left = 0;
////            int right = 0;
////            for (int i = 0; i < 4; i++) {
////                left = left * 10 + everynum[3 - i] - '0';//如果没有-'0'显示的就是ascii表里的
////                right = right * 10 + everynum[i] - '0';
////                //System.out.println(right);
////            }
////            if (left == right) {
////                System.out.printf("%04d - %04d = 0000\n", left, right);
////                break;
////            }
////            res = left - right;
////            System.out.printf("%04d - %04d = %04d\n", left, right, res);
////            num = String.valueOf(res);//可以使res变成字符串
////        }
////    }
////}