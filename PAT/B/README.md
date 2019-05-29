#算法学习记录
##PAT(B)
- B01AplusBandC

在检测过程中出错是因为

```
for (int i = 0; i < n; i++) {
            System.out.println("Case #" + (i + 1) + ": " + result[i]);
}
```
中`": "`的`:`后面没有加空格

- B02NumberSort数字分类

这个题目引入了java.text.DecimalFormat.

来达到他精确到小数点后一位的要求

```
import java.text.DecimalFormat;

public class Test{
    public static void main(String[] args){
        double pi=3.1415927;//圆周率
        //取一位整数 
        System.out.println(new DecimalFormat("0").format(pi));//3
        //取一位整数和两位小数  
        System.out.println(new DecimalFormat("0.00").format(pi));//3.14
        //取两位整数和三位小数，整数不足部分以0填补。  
        System.out.println(new DecimalFormat("00.000").format(pi));//03.142  
        //取所有整数部分  
        System.out.println(new DecimalFormat("#").format(pi));//3  
        //以百分比方式计数，并取两位小数  
        System.out.println(new DecimalFormat("#.##%").format(pi));//314.16%  
        
        long c=299792458;//光速  
        //显示为科学计数法，并取五位小数  
        System.out.println(new DecimalFormat("#.#####E0").format(c));//2.99792E8  
        //显示为两位整数的科学计数法，并取四位小数  
        System.out.println(new DecimalFormat("00.####E0").format(c));//29.9792E7  
        //每三位以逗号进行分隔。  
        System.out.println(new DecimalFormat(",###").format(c));//299,792,458  
        //将格式嵌入文本  
        System.out.println(new DecimalFormat("光速大小为每秒,###米").format(c)); //光速大小为每秒299,792,458米
    }
}
```

- B03CountPrimeNumber

判断是否是素数

```
public static boolean Isprime(int n) {
        if (n == 1) {
            return false;
        } else if (n == 2) {
            return true;
        } else if (n % 2 == 0) {
            return false;
        } else {
            for (int i = 3; i <= (int) Math.sqrt(n); i += 2) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
```

- B09B09Kaprekar6174

```
public class B09Kaprekar6174 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.next();
        num = String.format("%4s",num);
        int res = 0;
        while (res != 6174) {

            char[] everynum = num.toCharArray();
            Arrays.sort(everynum);
            int left = 0;
            int right = 0;
            for (int i = 0; i < 4; i++) {
                left = left * 10 + everynum[3 - i] - '0';//如果没有-'0'显示的就是ascii表里的
                right = right * 10 + everynum[i] - '0';
                //System.out.println(right);
            }
            if (left == right) {
                System.out.printf("%04d - %04d = 0000\n", left, right);
                break;
            }
            res = left - right;
            System.out.printf("%04d - %04d = %04d\n", left, right, res);
            num = String.valueOf(res);//可以使res变成字符串
        }
    }
}
```
首先这段代码通不过测试,因为错误出在

```
left = left * 10 + everynum[3 - i] - '0'
```

因为下标越界,如果输入的数字是个位数十位数或者百位数,格式不是000x,00xx,0xxx的话,那么结果就会是错的

因为```char[] everynum = num.tocharArray();```这行代码在把字符串转入数组的时候,转入到的数组是一位数两位数或者三位数,那么数组里面的`everynum[2],[3],[4]`就是空的,在for循环的时候会报下标越界的错误


```
import java.util.Scanner;
import java.util.Arrays;

public class B09Kaprekar6174 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int res = 0;
        while (res != 6174) {
            twoValue t = sort(num);
            int left = t.val1;
            int right = t.val2;
            if (left == right) {
                System.out.printf("%04d - %04d = 0000\n", left, right);
                break;
            }
            res = left - right;
            System.out.printf("%04d - %04d = %04d\n", left, right, res);
            num = res;
        }

    }

    private static twoValue sort(int num) {
        int[] digit = new int[4];
        int left = 0;
        int right = 0;
        for (int i = 0; i < 4; i++) {
            digit[i] = num % 10;
            num /= 10;
        }
        Arrays.sort(digit);
        for (int i = 0; i < 4; i++) {
            left = left * 10 + digit[3 - i];
        }
        for (int i = 0; i < 4; i++) {
            right = right * 10 + digit[i];
        }
        return new twoValue(left, right);
    }

    static class twoValue {
        int val1;
        int val2;

        twoValue(int val1, int val2) {
            this.val1 = val1;
            this.val2 = val2;
        }
    }
}
```
这个方法免去了字符串的转化,只用了数组和int,在算法中尽量避免使用字符串,字符串的效率比较低

```
twoValue t = sort(num);
            int left = t.val1;
            int right = t.val2;
```



```
	 private static twoValue sort(int num) {
        int left = 0;
        int right = 0;
        return new twoValue(left, right);
    }
```

```
static class twoValue {
        int val1;
        int val2;

        twoValue(int val1, int val2) {
            this.val1 = val1;
            this.val2 = val2;
        }
    }
```
这一系列的代码可以实现在sort函数返回两个值,避免了给left和right分别写两个sort的麻烦
