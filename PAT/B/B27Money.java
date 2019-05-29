//题目描述
//        如果你是哈利·波特迷，你会知道魔法世界有它自己的货币系统 —— 就如海格告诉哈利的：“十七个银西可(Sickle)兑一个加隆(Galleon)，二
//        十九个纳特(Knut)兑一个西可，很容易。”现在，给定哈利应付的价钱P和他实付的钱A，你的任务是写一个程序来计算他应该被找的零钱。
//
//        输入描述:
//        输入在1行中分别给出P和A，格式为“Galleon.Sickle.Knut”，其间用1个空格分隔。这里Galleon是[0, 107]]区间内的整数，Sickle是[0,
//        17)区间内的整数，Knut是[0, 29)区间内的整数。
//
//
//        输出描述:
//        在一行中用与输入同样的格式输出哈利应该被找的零钱。如果他没带够钱，那么输出的应该是负数。
//
//        输入例子:
//        10.16.27 14.1.28
//
//        输出例子:
//        3.2.1

        package Algorithm.PAT.B;

import java.util.Scanner;

public class B27Money {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String price = sc.next();
        String give = sc.next();
        String[] splitPrice = price.split("\\.");
        String[] splitGive = give.split("\\.");
        boolean flag =false;
        int differentKnut = toKnut(splitGive) - toKnut(splitPrice);
        if (differentKnut<0){
            differentKnut = -differentKnut;
            flag = true;
        }
        String differentGalleon = toGalleon(differentKnut);
        if (flag){
            System.out.print("-");
        }
        System.out.println(differentGalleon);
    }
    private static int toKnut(String[] s){
        int knutPrice = 0;
        knutPrice += Integer.parseInt(s[0])*17*29;
        knutPrice += Integer.parseInt(s[1])*29;
        knutPrice += Integer.parseInt(s[2]);
        return knutPrice;
    }
    private static String toGalleon(int knut){
        StringBuilder sb = new StringBuilder();
        int Galleon = knut/(29*17);
        sb.append(Galleon);
        knut-=Galleon*29*17;
        sb.append(".");
        int Sickle = knut/29;
        sb.append(Sickle);
        knut-=Sickle*29;
        sb.append(".");
        sb.append(knut);
        return sb.toString();
    }
}
