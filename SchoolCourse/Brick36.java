package Algorithm.SchoolCourse;

public class Brick36 {
    public static void main(String[] args) {
        for (int i = 0; i <= 36 / 4; i++) {
            for (int j = 0; j <= 36 / 3; j++) {
                for (int k= 0; k <= 36; k++) {
                    if (i * 4 + j * 3 + k / 2.0 == 36 && i + j +k ==36) {
                        System.out.println("男人=" + i + "女人=" + j +"小孩=" + k);
                    }
                }
            }
        }
    }
}
