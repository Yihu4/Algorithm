package Algorithm.PAT.B;

import java.util.Scanner;

public class AplusBandC {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();// 如果是int的,必须是nextInt,long亦然
        //n为比较大小的次数
        boolean[] result = new boolean[n];//建立一个boolean类型的result[]数组
        for (int i = 0; i < n; i++) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long c = sc.nextLong();
            result[i] = (a + b) > c;
        }
        for (int i = 0; i < n; i++) {
            System.out.println("Case #" + (i + 1) + ":" + result[i]);
        }
    }
}
