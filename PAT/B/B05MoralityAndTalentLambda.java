//package Algorithm.PAT.B;
//
//import java.util.Scanner;
//import java.util.ArrayList;
//import java.util.TreeSet;
//
//public class B05MoralityAndTalentLambda {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int L = sc.nextInt();
//        int H = sc.nextInt();
//
//        ArrayList both = new ArrayList();
//        ArrayList dc1 = new ArrayList();
//        ArrayList dc2 = new ArrayList();
//        ArrayList dc3 = new ArrayList();
//
//        while (n != 0) {
//            stu stu = new stu(sc.nextInt(), sc.nextInt(), sc.nextInt());
//            if (stu.d < L || stu.c < L) {
//                n--;
//                continue;
//            }
//            if (stu.d >= H && stu.c >= H)
//                both.add(stu);
//            else if (stu.d >= H)
//                dc1.add(stu);
//            else if (stu.d >= stu.c)
//                dc2.add(stu);
//            else
//                dc3.add(stu);
//            n--;
//        }
//        System.out.println(both.size() + dc1.size() + dc2.size() + dc3.size());
//        print(both);
//        print(dc1);
//        print(dc2);
//        print(dc3);
//        sc.close();
//
//    }
//    private static void print(TreeSet<Main.Stu> set) {
//        for(Main.Stu s : set)
//            System.out.println(s.id + " " + s.d + " " + s.c);
//    }
//
//
//         ArryList.sort((stu1,stu2)->
//
//    {
//        stu2.d + stu2.c - stu1.d - stu1.c
//    })
//}
//
//
