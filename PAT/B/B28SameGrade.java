//题目描述
//        本题要求读入N名学生的成绩，将获得某一给定分数的学生人数输出。
//
//        输入描述:
//        输入在第1行给出不超过105的正整数N，即学生总人数。随后1行给出N名学生的百分制整数成绩，中间以空格分隔。最后1行给出要查询的分
//        数个数K（不超过N的正整数），随后是K个分数，中间以空格分隔。
//
//
//        输出描述:
//        在一行中按查询顺序给出得分等于指定分数的学生人数，中间以空格分隔，但行末不得有多余空格。
//
//        输入例子:
//        10
//        60 75 90 55 75 99 82 90 75 50
//        3 75 90 88
//
//        输出例子:
//        3 2 0

        package Algorithm.PAT.B;

import java.util.Scanner;
public class B28SameGrade {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] grade = new int[N];
        for (int i = 0; i < N; i++){
            grade[i] = sc.nextInt();
        }
        int M = sc.nextInt();
        int[] needGrade = new int[M];
        for (int i = 0; i < M; i++){
            needGrade[i] = sc.nextInt();
        }
        for (int i = 0; i < M-1; i++){
            System.out.print(Same(N,needGrade[i],grade)+" ");
        }
        System.out.print(Same(N,needGrade[M-1],grade));

    }
    private static int Same(int N,int l, int[] grade){
        int count = 0;
        for (int i = 0; i < N; i++){
            if (grade[i]==l){
                count++;
            }
        }
        return count;
    }
}
