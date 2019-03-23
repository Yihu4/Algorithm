package Algorithm.SchoolCourse;

/*
 教练和运动员案例(学生分析然后讲解)
    乒乓球运动员和篮球运动员。
    乒乓球教练和篮球教练。
    为了出国交流，跟乒乓球相关的人员都需要学习英语。
    请用所学知识：
    分析，这个案例中有哪些抽象类，哪些接口，哪些具体类。
        分析：
            1、共同的属性：姓名 年龄
                   共同的方法：吃饭，睡觉
                   其中吃饭的内容两者不同，所以用抽象方法
                   不同的方法：队员练习，教练教导，分别写入队员类和教练类
            2、接口：学习英语
            3、抽象类：人类；  运动员类、教练类 这两个继承人类
                   具体类：乒乓球队员类、教练类和篮球队员类、教练类 ； 分别继承运动员类或教练类，其中乒乓球有关的扩展学习英语接口
*/

//定义学英语接口
interface English{
    public abstract void speak();
}

//定义抽象人类
abstract class person{
    //成员变量
    private String name;
    private int age;

    //无参构造方法
    public person(){}

    //有参构造方法
    public person(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }

    //抽象方法
    public abstract void eat();
    //成员方法
    public void sleep(){
        System.out.println("睡觉去");
    }
}

//抽象运动员类
abstract class player extends person{
    //无参构造方法
    public player(){}
    //有参构造方法
    public player(String name,int age){
        super(name,age);
    }
    //特有的方法，练习,不得不做的，用抽象
    public abstract void student();
}

//抽象教练类
abstract class coach extends person{
    public coach(){}
    public coach(String name,int age){
        super(name,age);
    }
    public abstract void teacher();
}

//具体乒乓球运动类
class pingpangplayer extends player implements English{
    public pingpangplayer(){}
    public pingpangplayer(String name,int age){
        super(name,age);
    }
    public void speak() {
        System.out.println("要学习英语");
    }
    public void student() {
        System.out.println("要练习发球和接球的技巧");
    }
    public void eat() {
        System.out.println("吃清淡的饭菜");
    }
}

//具体乒乓球教练类
class pingpangcoach extends coach implements English{
    public pingpangcoach(){}
    public pingpangcoach(String name,int age){
        super(name,age);
    }
    public void speak(){
        System.out.println("要学习英语");
    }
    public void teacher(){
        System.out.println("要教导队员发球和接球的技巧");
    }
    public void eat(){
        System.out.println("跟着队员吃清淡的饭菜");
    }
}

//具体篮球队员类
class basketballplayer extends player{
    public basketballplayer(){}
    public basketballplayer(String name,int age){
        super(name,age);
    }
    public void eat(){
        System.out.println("要吃油腻的饭菜");
    }
    public void student(){
        System.out.println("要练习运球和投篮技巧");
    }
}
//具体篮球教练类
class basketballcoach extends coach{
    public basketballcoach(){}
    public basketballcoach(String name,int age){
        super(name,age);
    }
    public void eat(){
        System.out.println("要跟着队员，吃油腻的饭菜");
    }
    public void teacher(){
        System.out.println("要教导队员运球和投篮技巧");
    }
}

class InterfaceTest1 {
    public static void main(String[] args) {
        //测试运动员(乒乓球运动员和篮球运动员)
        //乒乓球运动员
        pingpangplayer p3 = new pingpangplayer("马龙",26);
        p3.eat();
        p3.sleep();
        p3.student();
        p3.speak();

        basketballplayer b2p = new basketballplayer("姚明",38);
        b2p.eat();
        b2p.sleep();
        b2p.student();

        System.out.println("------------");
        //测试教练类

        pingpangcoach p2c = new pingpangcoach("教练p",41);
        p2c.eat();
        p2c.sleep();
        p2c.teacher();
        p2c.speak();

        basketballcoach b2c = new basketballcoach("教练b",38);
        b2c.eat();
        b2c.sleep();
        b2c.teacher();

    }

}