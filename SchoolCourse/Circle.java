package Algorithm.SchoolCourse;

public class Circle {
    double radius;

    Circle() {

    }

    Circle(double r) {
        this.radius = r;

    }

    double getArea() {
        double area = Math.PI * radius * radius;
        return area;
    }

    double getPerimeter() {
        double per = 2 * Math.PI * radius;
        return per;
    }

    void show() {
        double area = getArea();
        double per = getPerimeter();
        System.out.println("半径=" + radius + " 周长=" + per + " 面积=" + area);
    }

    public static void main(String[] args) {
        Circle get = new Circle(5);
        get.show();

    }

}
