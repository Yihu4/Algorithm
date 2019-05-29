//题目描述
//        科学计数法是科学家用来表示很大或很小的数字的一种方便的方法，其满足正则表达式[+-][1-9]"."[0-9]+E[+-][0-9]+，即数字的整数部分
//        只有1位，小数部分至少有1位，该数字及其指数部分的正负号即使对正数也必定明确给出。
//
//        现以科学计数法的格式给出实数A，请编写程序按普通数字表示法输出A，并保证所有有效位都被保留。
//
//        输入描述:
//        每个输入包含1个测试用例，即一个以科学计数法表示的实数A。该数字的存储长度不超过9999字节，且其指数的绝对值不超过9999。
//
//
//        输出描述:
//        对每个测试用例，在一行中按普通数字表示法输出A，并保证所有有效位都被保留，包括末尾的0。
//
//        输入例子:
//        +1.23400E-03
//
//        输出例子:
//        0.00123400
package Algorithm.PAT.B;

import java.util.Scanner;
import java.text.DecimalFormat;

public class B14ScientificNotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        if (chars[0] == '-') {
            sb.append("-");
        }
        int e = str.indexOf('E');
        String z = str.substring(e + 2);//指数
        String s = str.substring(3, e);
        int zeroCount = Integer.parseInt(z);
        if (chars[e + 1] == '-') {
            sb.append("0.");
            for (int i = 0; i < zeroCount - 1; i++) {
                sb.append("0");
            }
            sb.append(chars[1]);
            sb.append(s);
        } else {
            sb.append(chars[1]);
            if (zeroCount >= s.length()) {
                sb.append(s);
                for (int i = 0; i < zeroCount - s.length(); i++) {
                    sb.append("0");
                }
            } else {//-1.23456E+4
                String temp = s.substring(0, zeroCount);//2345
                String temp2 = s.substring(zeroCount);//6
                sb.append(temp);
                sb.append(".");
                sb.append(temp2);
            }
        }
        System.out.println(sb.toString());
    }
}
//public class B14ScientificNotation {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String A = sc.next();
//        char[] everye = A.toCharArray();
//        double res;
//        int count = 0;
//        int flag1 = 1;
//        int flag2 = 1;
//        double bemul = 0;
//        double trans;
//        int mul = 0;
//        int afterpoint = 0;
//        if (everye[0] == '-')
//            flag1 = -1;
//        int temp = 0;
//        for (int i = 2; i < everye.length; i++) {
//            if (everye[i] != 'E') {
//                afterpoint++;
//                count++;
//            } else {
//                temp = i;
//                break;
//            }
//        }
//        for (int i =temp-1;i>2;i--){
//            trans = everye[i]-'0';
//            bemul = (bemul +trans)/10;
//        }
//        if (everye[temp + 1] == '-')
//            flag2 = -1;
//        for (int i = temp + 2; i < everye.length; i++) {
//            mul = mul * 10 + everye[i];
//        }
//        if (flag2 == 1) {
//
//        }
//        System.out.println(bemul);
//    }
//}
