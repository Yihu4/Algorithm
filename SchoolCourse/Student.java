package Algorithm.SchoolCourse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Student implements Comparable<Student> {

    private String name;
    private String no;
    private double score;

    public Student(String name, String no, double score) {
        this.name = name;
        this.no = no;
        this.score = score;
    }

    public int compareTo(Student e) {
        if (this.score > e.score) {
            return -1;
        } else if (this.score < e.score) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {

        Student s1 = new Student("一", "1", 59.5);
        Student s2 = new Student("二", "2", 68.0);
        Student s3 = new Student("三", "3", 49.0);
        Student s4 = new Student("四", "4", 91.0);
        Student s5 = new Student("五", "5", 27.0);
        Student s6 = new Student("六", "6", 66.6);
        Student s7 = new Student("七", "7", 88.0);
        Student s8 = new Student("八", "8", 100.0);

        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        list.add(s6);
        list.add(s7);
        list.add(s8);

        Collections.sort(list);

        for (Student stu : list) {
            System.out.println(String.format("名字：%s  学号:%s  分数%s", stu.getName(), stu.getNo(), stu.getScore()));
        }
    }


    public String getName() {
        return name;
    }

    public String getNo() {
        return no;
    }

    public double getScore() {
        return score;
    }
}