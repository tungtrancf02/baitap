import org.w3c.dom.ls.LSOutput;

import java.util.*;

 class person {
String name;
int age;
public person(String name, int age) {
    this.name = name;
    this.age = age;

}
public void show(){
    System.out.println("name= "+name);
    System.out.println("age= "+age);
}
}
   class student extends person{
double gpa;
       public student(String name, int age, double gpa) {
           super(name, age);
           this.gpa = gpa;
       }
       public void show(){

           System.out.println("gpa="+gpa);
       }
   }
   class Staff extends student{
    double salary;
    public Staff(String name, int age, double gpa, double salary) {
        super(name, age, gpa);
        this.salary = salary;
    }
    public void show(){

        System.out.println("salary="+salary);

    }
   }

class nain {
    public static void main(String[] args) {




    person nguoi=new person("tung",18);
        nguoi.show();

student gpa=new student("tung",18,1.5);
gpa.show();

Staff luong=new Staff("tung",18,1.5,3000);
luong.show();

}
}

