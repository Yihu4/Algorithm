package Algorithm.SchoolCourse;


public class Rectangle {
    float length, width;

    double getPerimeter() {
        return 2 * (width + length);
    }

    double getArea() {
        return width * length;
    }

    void showAll() {
        System.out.print("长" + this.length);
        System.out.print("宽" + this.width);
        System.out.print("面积" + getArea());
        System.out.print("周长" + getPerimeter());
    }


    public static void main(String args[]) {
        Rectangle rect = new Rectangle();
        rect.length = 11;
        rect.width = 12;
        rect.showAll();
    }
}
