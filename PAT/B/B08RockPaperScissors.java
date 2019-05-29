package Algorithm.PAT.B;

import java.util.HashMap;
import java.util.Arrays;
import java.util.Scanner;

public class B08RockPaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int win = 0;
        int tie = 0;
        int lose = 0;
        int AC = 0;
        int AJ = 0;
        int AB = 0;
        int BC = 0;
        int BJ = 0;
        int BB = 0;
        int N = sc.nextInt();
        int[] Condition = new int[N];
        for (int i = 0; i < N; i++) {
            String A = sc.next();
            String B = sc.next();
            Condition[i] = winner(A, B);
            if (Condition[i] == 1) {
                switch (A) {
                    case "C":
                        AC++;
                        break;
                    case "J":
                        AJ++;
                        break;
                    default:
                        AB++;
                        break;
                }
            }
            if (Condition[i] == -1) {
                switch (B) {
                    case "C":
                        BC++;
                        break;
                    case "J":
                        BJ++;
                        break;
                    default:
                        BB++;
                        break;
                }
            }
        }

        //System.out.println(Arrays.toString(Condition));
        for (int c : Condition) {
            if (c == 1)
                win++;
            else if (c == 0)
                tie++;
            else
                lose++;
        }
        System.out.println(win + " " + tie + " " + lose);
        System.out.println(lose + " " + tie + " " + win);
        //System.out.println(AC + " " + AJ + " " + AB + " " + BC + " " + BJ + " " + BB);
        System.out.println(ACJB(AC, AJ, AB) + " " + ACJB(BC, BJ, BB));
    }

    private static int winner(String A, String B) {
        switch (A) {
            case "C":
                switch (B) {
                    case "J":
                        return 1;
                    case "C":
                        return 0;
                    default:
                        return -1;
                }
            case "J":
                switch (B) {
                    case "B":
                        return 1;
                    case "J":
                        return 0;
                    default:
                        return -1;
                }
            default:
                switch (B) {
                    case "C":
                        return 1;
                    case "B":
                        return 0;
                    default:
                        return -1;
                }
        }

    }

    private static String ACJB(int C, int J, int B) {
        if (B > C) {
            if (B > J)
                return "B";
            else if (B < J)
                return "J";
            else
                return "B";
        } else if (B < C) {
            if (C > J)
                return "C";
            else if (C < J)
                return "J";
            else
                return "C";
        } else {
            if (B < J)
                return "J";
            else
                return "B";
        }
    }
}
//public class Main {
//    public static void  main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        String A = null;
//        String B = null;
//        int aWin = 0;
//        int aLose = 0;
//        HashMap<String,Integer> Acjb = new HashMap<String, Integer>();
//        HashMap<String,Integer> Bcjb = new HashMap<String, Integer>();
//        Acjb.put("J",0);
//        Acjb.put("C",0);
//        Acjb.put("B",0);
//        Bcjb.put("J",0);
//        Bcjb.put("B",0);
//        Bcjb.put("C",0);
//        for (int i = 0; i < num; i++) {
//            A = sc.next();
//            B = sc.next();
//            int res = whoWin(A,B);
//            if (res == 1) {
//                aWin++;
//                Acjb.put(A,Acjb.get(A)+1);
//            }
//            if (res == -1) {
//                aLose++;
//                Bcjb.put(B,Bcjb.get(B)+1);
//            }
//        }
//        String aMx ;
//        aMx = Acjb.get("J") > Acjb.get("C")? "J" : "C";
//        aMx = Acjb.get(aMx) > Acjb.get("B")? aMx : "B";
//        String bMx ;
//        bMx = Bcjb.get("J") > Bcjb.get("C")? "J" : "C";
//        bMx = Bcjb.get(bMx) > Bcjb.get("B")? bMx : "B";
//        System.out.println(aWin+" "+(num-aLose-aWin)+" "+aLose);
//        System.out.println(aLose+" "+(num-aLose-aWin)+" "+aWin);
//        System.out.println(aMx+" "+bMx);
//
//    }
//    static int  whoWin(String A,String B){
//        if (A.equals("C")) {
//            if (B.equals("J"))
//                return 1;
//            else if (B.equals("B"))
//                return -1;
//            else
//                return 0;
//        }
//        if (A.equals("J")){
//            if (B.equals("C"))
//                return -1;
//            else if (B.equals("B"))
//                return 1;
//            else
//                return 0;
//        }
//        if (A.equals("B")){
//            if (B.equals("C"))
//                return 1;
//            else if (B.equals("J"))
//                return -1;
//            else
//                return 0;
//        }
//        return -2;
//    }
//
//
//}

