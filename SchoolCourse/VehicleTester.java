package Algorithm.SchoolCourse;

public class VehicleTester {

    public static void main(String[] args) {
        Car car=new Car("BMW");
        car.NumOfWheels();
        Motorbike mot=new Motorbike("捷安特");
        mot.NumOfWheels();
        Vehicle v = new Car("雷克萨斯");
        v.NumOfWheels();
    }
}