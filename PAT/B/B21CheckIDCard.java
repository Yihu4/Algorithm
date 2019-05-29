//题目描述
//        一个合法的身份证号码由17位地区、日期编号和顺序编号加1位校验码组成。校验码的计算规则如下：
//        首先对前17位数字加权求和，权重分配为：{7，9，10，5，8，4，2，1，6，3，7，9，10，5，8，4，2}；然后将计算的和对11取模得
//        到值Z；最后按照以下关系对应Z值与校验码M的值：
//        Z：0 1 2 3 4 5 6 7 8 9 10
//        M：1 0 X 9 8 7 6 5 4 3 2
//        现在给定一些身份证号码，请你验证校验码的有效性，并输出有问题的号码。
//
//        输入描述:
//        输入第一行给出正整数N（<= 100）是输入的身份证号码的个数。随后N行，每行给出1个18位身份证号码。
//
//
//        输出描述:
//        按照输入的顺序每行输出1个有问题的身份证号码。这里并不检验前17位是否合理，只检查前17位是否全为数字且最后1位校验码计算准确。如果所有号码都正常，
//
//        则输出“All passed”。
//
//        输入例子:
//        4
//        320124198808240056
//        12010X198901011234
//        110108196711301866
//        37070419881216001X
//
//        输出例子:
//        12010X198901011234
//        110108196711301866
//        37070419881216001X
package Algorithm.PAT.B;

import java.util.Scanner;
public class B21CheckIDCard {
    private static final char[] M = {'1','0','X','9','8','7','6','5','4','3','2'};
    private static final int[] W = {7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] errors = new String[N];
        int count = 0;
        for (int i  = 0; i < N; i++){
            String id = sc.next();
            if (!check(id))
                errors[count++] = id;
        }
        if (count ==0)
            System.out.println("All passed");
        else
            for (int i = 0; i < count; i++)
                System.out.println(errors[i]);

    }
    private static boolean check(String id){
        int w = 0;
        for (int i = 0; i < 17; i++){
            char c  = id.charAt(i);
            if (c >= '0' && c<='9')
                w += W[i] * (c - '0');
            else
                return false;
        }
        return M[w%11] == id.charAt(17);
    }
}
