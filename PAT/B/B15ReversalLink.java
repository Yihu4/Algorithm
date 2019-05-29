//
//题目描述
//        给定一个常数K以及一个单链表L，请编写程序将L中每K个结点反转。例如：给定L为1→2→3→4→5→6，K为3，则输出应该为
//        3→2→1→6→5→4；如果K为4，则输出应该为4→3→2→1→5→6，即最后不到K个元素不反转。
//
//        输入描述:
//        每个输入包含1个测试用例。每个测试用例第1行给出第1个结点的地址、结点总个数正整数N(<= 105)、以及正整数K(<=N)，即要求反转的
//        子链结点的个数。结点的地址是5位非负整数，NULL地址用-1表示。
//
//        接下来有N行，每行格式为：
//
//        Address Data Next
//
//        其中Address是结点地址，Data是该结点保存的整数数据，Next是下一结点的地址。
//
//
//        输出描述:
//        对每个测试用例，顺序输出反转后的链表，其上每个结点占一行，格式与输入相同。
//
//        输入例子:
//        00100 6 4
//        00000 4 99999
//        00100 1 12309
//        68237 6 -1
//        33218 3 00000
//        99999 5 68237
//        12309 2 33218
//
//        输出例子:
//        00000 4 33218
//        33218 3 12309
//        12309 2 00100
//        00100 1 99999
//        99999 5 68237
//        68237 6 -1
package Algorithm.PAT.B;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class B15ReversalLink {
    public static class Node{
        int adress;
        int data;
        int next;
        Node(int adress,int data,int next){
            this.adress = adress;
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int firstNode = in.nextInt();
        int n = in.nextInt();
        int k = in.nextInt();

        HashMap<Integer,Node> hashMap = new HashMap<>();
        for(int i=0;i<n;i++){
            int adress = in.nextInt();
            int data = in.nextInt();
            int next = in.nextInt();
            hashMap.put(adress,new Node(adress,data,next));
        }
        in.close();
        ArrayList<Node> list = new ArrayList<>();

        while(firstNode!=-1){
            Node cur = hashMap.get(firstNode);
            list.add(cur);
            firstNode = cur.next;
        }

        for(int i=0;i+k<list.size();i+=k){
            int left = i;
            int right = i+k-1;
            while (left<right){
                Node temp = list.get(right);
                list.set(right,list.get(left));
                list.set(left,temp);
                int newNext = list.get(left).next;
                list.get(left).next = list.get(right).next;
                list.get(right).next = newNext;
                if(left>0){
                    list.get(left-1).next = list.get(left).adress;
                }
                list.get(right-1).next = list.get(right).adress;

                left++;
                right--;
            }
        }

        for(Node node:list){
            String adressStr = node.adress+"";
            String nextStr = node.next+"";
            while (adressStr.length()<5){
                adressStr = '0'+adressStr;
            }
            while (nextStr.length()<5&&!nextStr.equals("-1")){
                nextStr = '0'+nextStr;
            }

            System.out.println(adressStr+" "+ node.data +" "+nextStr);
        }
    }
}
//
//import java.util.Scanner;
//
//public class B15ReversalLink {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String First = sc.next();
//        int N = sc.nextInt();
//        String[] strings = new String[N];
//        String[] nextstrings = new String[N];
//        int[] Num = new int[N];
//        int K = sc.nextInt();
//        for (int i = 0; i < N; i++) {
//            strings[i] = sc.next();
//            Num[i] = sc.nextInt();
//            nextstrings[i] = sc.next();
//        }
//        for (int i = 0; i < N; i++) {
//            for (int j = i + 1; j < N; j++) {
//                if (Num[i] < Num[j]) {
//                    int tempnum = Num[i];
//                    Num[i] = Num[j];
//                    Num[j] = tempnum;
//                    String tempstrings = strings[i];
//                    strings[i] = strings[j];
//                    strings[j] = tempstrings;
//                    String tempnextstrings = nextstrings[i];
//                    nextstrings[i] = nextstrings[j];
//                    nextstrings[j] = tempnextstrings;
//                }
//            }
//        }
//        int temp = N;
//        while (temp - K >= 0) {
//            for (int i = N - K; i < N; i++) {
//                if (i == N - 1) {
//                    System.out.println(strings[i] + " " + Num[i] + " " + strings[i - K]);
//                } else
//                    System.out.println(strings[i] + " " + Num[i] + " " + strings[i + 1]);
//            }
//            temp -= K;
//        }
//        for (int i = N - K - 1; i >= 0; i--) {
//            System.out.println(strings[i] + " " + Num[i] + " " + nextstrings[i]);
//        }
//    }
//}
