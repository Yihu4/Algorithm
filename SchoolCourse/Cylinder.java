package Algorithm.SchoolCourse;

public class Cylinder extends Circle {
    double height;

    Cylinder(double r, double h) {
        this.radius = r;
        this.height = h;
    }

    double getVolume() {
        double vol = Math.PI * radius * radius;
        return vol;
    }

    void showVolume() {
        double vol = getVolume();
        System.out.println("半径=" + radius + " 体积=" + vol);
    }

    public static void main(String[] args) {
        Cylinder get = new Cylinder(5, 5);
        get.showVolume();
    }

}
