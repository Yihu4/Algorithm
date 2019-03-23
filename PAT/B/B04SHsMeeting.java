/*
题目描述
大侦探福尔摩斯接到一张奇怪的字条：“我们约会吧！ 3485djDkxh4hhGE 2984akDfkkkkggEdsb s&hgsfdk d&Hyscvnm”。大侦探很

 快就明白了，字条上奇怪的乱码实际上就是约会的时间“星期四 14:04”，
 因为前面两字符串中第1对相同的大写英文字母（大小写有区分）是

 第4个字母'D'，代表星期四；第2对相同的字符是'E'，那是第5个英文字母，
 代表一天里的第14个钟头（于是一天的0点到23点由数字0到9、

 以及大写字母A到N表示）；后面两字符串第1对相同的英文字母's'出现在第4个位置（从0开始计数）上，
 代表第4分钟。现给定两对字符串，

 请帮助福尔摩斯解码得到约会的时间。

输入描述:
输入在4行中分别给出4个非空、不包含空格、且长度不超过60的字符串。


输出描述:
在一行中输出约会的时间，格式为“DAY HH:MM”，其中“DAY”是某星期的3字符缩写，
即MON表示星期一，TUE表示星期二，WED表示星期三，THU表示星期
四，FRI表示星期五，SAT表示星期六，SUN表示星期日。题目输入保证每个测试存在唯一解。

输入例子:
3485djDkxh4hhGE
2984akDfkkkkggEdsb
s&hgsfdk
d&Hyscvnm

输出例子:
THU 14:04
 */

package Algorithm.PAT.B;

import java.util.Scanner;

public class B04SHsMeeting {
    private final static String[] DAY = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String l1 = sc.nextLine();
        String l2 = sc.nextLine();
        String l3 = sc.nextLine();
        String l4 = sc.nextLine();
        int len1 = Math.min(l1.length(), l2.length());//确定对比范围
        int len2 = Math.min(l3.length(), l4.length());
        boolean flag1 = true;//用于避免出现相同数字出现在相同大写字母前的情况
        for (int i = 0; i < len1; i++) {
            char c = l1.charAt(i);//检索字符串的第i个字符
            if (flag1 && c >= 'A' && c <= 'G') {
                if (c == l2.charAt(i)) {
                    flag1 = !flag1;//只要确定了星期就不会再出现
                    System.out.print(DAY[c - 65] + " ");//D的ascii码是68,68-65=3因此为THU
                }
            } else if (!flag1 && c == l2.charAt(i)) {
                if (c >= '0' && c <= '9') {
                    System.out.print("0" + c + ":");
                    break;
                } else if (c >= 'A' && c <= 'N') {
                    System.out.print((c - 55) + ":");
                    break;
                }
            }
        }
        for (int i = 0; i < len2; i++) {
            char c = l3.charAt(i);
            if (c >= 'a' && c <= 'z' && c == l4.charAt(i)) {
                if (i < 10)
                    System.out.print("0" + i);
                else System.out.print(i);
                break;//一旦成功一次退出循环
            }
        }
    }
}
