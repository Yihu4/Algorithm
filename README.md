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