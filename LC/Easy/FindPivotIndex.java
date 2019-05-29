package Algorithm.LC.Easy;

import java.util.Scanner;

public class FindPivotIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] arr = new int[str.length()];
        for (int i = 0; i < str.length(); i++){
            arr[i] = Integer.parseInt(str.substring(i, i+1));
        }
        System.out.println(pivotIndex(arr));
    }

    private static int pivotIndex(int[] nums) {
        int count = -1;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            int left = 0;
            int right = 0;
            count++;
            for (int m = 0; m < i; m++) {
                left += nums[m];
            }
            for (int n = i + 1; n < nums.length; n++) {
                right += nums[n];
            }
            if (left == right) {
                flag = true;
                break;
            }
        }
        if (flag)
            return count;
        else return -1;
    }
}
//全部数字加起来减去那个数等于两倍的一边的数就可以,无需嵌套循环
// sum += nums[i++]这行代码十分好用
// 无需在循环内容里面加sum += nums[i - 1];
//
// class Solution {
//    public int pivotIndex(int[] nums) {
//        int total = 0, sum = 0;
//        for (int num : nums) total += num;
//        for (int i = 0; i < nums.length; sum += nums[i++])
//            if (sum * 2 == total - nums[i]) return i;
//        return -1;
//    }
//}