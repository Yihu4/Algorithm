//题目描述
//        旧键盘上坏了几个键，于是在敲一段文字的时候，对应的字符就不会出现。现在给出应该输入的一段文字、以及实际被输入的文字，请你列出
//        肯定坏掉的那些键。
//
//        输入描述:
//        输入在2行中分别给出应该输入的文字、以及实际被输入的文字。每段文字是不超过80个字符的串，由字母A-Z（包括大、小写）、数字0-9、
//        以及下划线“_”（代表空格）组成。题目保证2个字符串均非空。
//
//
//        输出描述:
//        按照发现顺序，在一行中输出坏掉的键。其中英文字母只输出大写，每个坏键只输出一次。题目保证至少有1个坏键。
//
//        输入例子:
//        7_This_is_a_test
//        _hs_s_a_es
//
//        输出例子:
//        7TI

        package Algorithm.PAT.B;

import java.util.Scanner;
public class B19OldKeyboard {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String origin = sc.next().toUpperCase();
        String bad = sc.next().toUpperCase();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < origin.length(); i++){
            if (bad.indexOf(origin.charAt(i)) == -1&& result.toString().indexOf(origin.charAt(i))== -1){
                result.append(origin.charAt(i));
            }
        }
        System.out.println(result);
    }
}
