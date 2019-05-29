package Algorithm.LC.Easy;

import java.util.Scanner;

public class JewelsAndStones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = numJewelsInStones(sc.next(), sc.next());
        System.out.println(n);
    }

    private static int numJewelsInStones(String J, String S) {
        int[] s = new int[58];//利用哈希思想
        int count = 0;
        char[] c1 = J.toCharArray();
        char[] c2 = S.toCharArray();
        for (char i : c1) {
            s[i - 65] = 1;
        }
        for (char i : c2) {
            if (s[i - 65] == 1) {
                count++;
            }
        }
        return count;
    }
}

//最好不要用嵌套循环,嵌套循环太贵了,会把M+N变成MN
//class Solution {
////    public int numJewelsInStones(String J, String S) {
////        char[] jch = J.toCharArray();
////        char[] sch = S.toCharArray();
////        int count = 0;
////        for (int i = 0; i < sch.length; i++) {
////            for (int j = 0; j < jch.length; j++) {
////                if (jch[j] == sch[i])
////                    count++;
////            }
////        }
////        return count;
////    }
////}