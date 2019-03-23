package Algorithm.SchoolCourse;

public class Narcissus {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            if(Math.pow(i % 10, 3) + Math.pow(((i - i % 10) / 10) % 10, 3) + Math.pow((i -i % 10 - (((i - i % 10) / 10) % 10) * 10) /100,3)==i) {
                System.out.println(i);
            }
        }
    }
}
//i - i % 10 剩十位和百位 123->120 23->20
//(i - i % 10) / 10 123->12  23->2
//((i - i % 10) / 10) % 10 十位 123->2 23->3
//(i -i % 10 - (((i - i % 10) / 10) % 10) * 10) /100百位