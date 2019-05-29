//题目描述
//        月饼是中国人在中秋佳节时吃的一种传统食品，不同地区有许多不同风味的月饼。现给定所有种类月饼的库存量、总售价、以及市场的最大需
//        求量，请你计算可以获得的最大收益是多少。
//
//        注意：销售时允许取出一部分库存。样例给出的情形是这样的：假如我们有3种月饼，其库存量分别为18、15、10万吨，总售价分别为75、
//        72、45亿元。如果市场的最大需求量只有20万吨，那么我们最大收益策略应该是卖出全部15万吨第2种月饼、以及5万吨第3种月饼，获得
//        72 + 45/2 = 94.5（亿元）。
//
//        输入描述:
//        每个输入包含1个测试用例。每个测试用例先给出一个不超过1000的正整数N表示月饼的种类数、以及不超过500（以万吨为单位）的正整数
//        D表示市场最大需求量。随后一行给出N个正数表示每种月饼的库存量（以万吨为单位）；最后一行给出N个正数表示每种月饼的总售价（以亿
//        元为单位）。数字间以空格分隔。
//
//
//        输出描述:
//        对每组测试用例，在一行中输出最大收益，以亿元为单位并精确到小数点后2位。
//
//        输入例子:
//        3 20
//        18 15 10
//        75 72 45
//
//        输出例子:
//        94.50

        package Algorithm.PAT.B;

import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Arrays;

public class B10MoonCake {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int D = sc.nextInt();
        int[] stock = new int[N];
        int[] price = new int[N];
        double[] ratio = new double[N];
        for (int i = 0; i < N; i++) {
            stock[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            price[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            ratio[i] = (double) price[i] / (double) stock[i];
        }

        if (N > 1) {
            for (int i = 0; i < N; i++) {
                for (int j = i+1; j < N; j++) {
                    if (ratio[i] < ratio[j]) {
                        double tempratio = ratio[i];
                        ratio[i] = ratio[j];
                        ratio[j] = tempratio;
                        int tempstock = stock[i];
                        stock[i] = stock[j];
                        stock[j] = tempstock;
                        int tempprice = price[i];
                        price[i] = price[j];
                        price[j] = tempprice;
                    }
                }
            }
        }
        boolean flag = false;
        int count = 0;
        double profit = 0;
        for (int i = 0; D > 0 && i < N; i++) {
            if (stock[i] > D) {
                flag = true;
                break;
            }
            D -= stock[i];
            profit += price[i];
            count++;
        }
        //System.out.println(profit);
        if (flag) {
            profit += D * ratio[count];
        }
        System.out.println(new DecimalFormat("#.00").format(profit));
        //System.out.println(Arrays.toString(stock) + "\n" + Arrays.toString(price) + "\n" + Arrays.toString(ratio));
    }
}
