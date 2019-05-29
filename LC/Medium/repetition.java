package Algorithm.LC.Medium;
import java.util.Scanner;
public class repetition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] arr = new int[str.length()];
        for (int i = 0; i < str.length(); i++){
            arr[i] = Integer.parseInt(str.substring(i, i+1));
        }
        System.out.println(findDuplicate(arr));
    }
    private static int findDuplicate(int[] nums) {
        int index = 0;
        while(index < nums.length) {
            int curVar = nums[index];
            if(curVar == index + 1) {
                index++;
                continue;
            }
            while(curVar != index + 1) {
                int nextVar = nums[curVar - 1];
                if(nextVar == curVar)
                    return curVar;
                nums[curVar - 1] = curVar;
                curVar = nextVar;
            }
            nums[index++] = curVar;
            
        }
        return - 1;
    }
//    private static int findDuplicate(int[] nums) {
//        int low = 1, high = nums.length - 1;
//        while (low <= high) {
//            int mid = (int) (low + (high - low) * 0.5);
//            int cnt = 0;
//            for (int a : nums) {
//                if (a <= mid) ++cnt;
//            }
//            if (cnt <= mid) low = mid + 1;
//            else high = mid - 1;
//        }
//        return low;
//    }
//    private static int findDuplicate(int[] nums) {
//        int n = nums.length;
//        int slow = n;
//        int fast = n;
//        do{
//            slow = nums[slow-1];
//            fast = nums[nums[fast-1]-1];
//        }while(slow != fast);
//        slow = n;
//        while(slow != fast){
//            slow = nums[slow-1];
//            fast = nums[fast-1];
//        }
//        return slow;
//    }

}
