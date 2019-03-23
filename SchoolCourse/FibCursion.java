package Algorithm.SchoolCourse;

public class FibCursion {
    //递归
    public static  void main(String[] args){
        System.out.println(f(20));
    }
    public static int f(int n){
        if (n == 1 || n == 2){
            return 1;
        }else {
            return f(n - 1) + f(n - 2);
        }
    }
}
