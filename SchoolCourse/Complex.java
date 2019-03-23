package Algorithm.SchoolCourse;

public class Complex {
    private int RealPart;
    private int ImaginPart;

    private Complex() {
        this(0, 0);
    }

    private Complex(int RealPart, int ImaginPart) {
        this.RealPart = RealPart;
        this.ImaginPart = ImaginPart;
    }

    private void complexAdd(Complex a) {
        Complex result = new Complex();
        result.RealPart = this.RealPart + a.RealPart;
        result.ImaginPart = this.ImaginPart + a.ImaginPart;
        System.out.print("加法结果为:" + result.RealPart + "+" + result.ImaginPart + "i");
    }

    public String toString() {
        return "(" + this.RealPart + this.ImaginPart + "i" + ")";
    }

    public static void main(String[] args) {
        Complex fushu1 = new Complex(2, 2);
        Complex fushu2 = new Complex(3, 3);
        fushu1.complexAdd(fushu2);
    }
}
