package Algorithm.SchoolCourse;

public abstract class Vehicle {
    private String name;

    public Vehicle(String name) {
        this.name = name;
    }

    public Vehicle() {

    }

    public String getName() {
        return name;
    }

    public abstract void NumOfWheels();

}

class Car extends Vehicle {
    public Car( String name) {
        super(name);
        System.out.println("--有参--" + name);
    }
    public Car(){

    }

    @Override
    public void NumOfWheels() {
        // TODO Auto-generated method stub
        System.out.println("我是" +getName() +",我有四个轮子");
    }
}

class Motorbike extends Vehicle {
    public Motorbike( String name) {
        super(name);
        System.out.println("--有参--" + name);
    }
    public Motorbike(){

    }

    @Override
    public void NumOfWheels() {
        // TODO Auto-generated method stub
        System.out.println("我是" +getName() +",我有两个轮子");
    }

}