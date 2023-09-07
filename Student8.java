/*8) Create a class Student with two members : rollno and percentage.
	Create default and parameterized constructors. Create method show() to 	display information.
	Create another class CollegeStudent inherits Student class. Add a new member semester to it.Create default and parameterized constructors. Also override show() method.
	Create another class SchoolStudent inherits Student class. Add a new memberclassname(eg 12 th ,10 th etc.) to it. Create default and parameterized 	constructors. Also override show() method.
	Create a class(say XYZ) with main method that carries out the operation of the project :
has array to store objects of any class(Student or CollegeStudent, SchoolStudent).
create two CollegeStudent and three SchoolStudent record objects and store 	them inside the array.
display all record from the array.
search record on the basic of rollno and check given rollno is of SchoolStudent or of CollegeStudent.
count how many students are having A grade,if for A grade percentage >75.
*/

import java.util.Scanner;

public class Student8 {
    protected int rollno;
    protected float percentage;
    Student8(){
    }
    Student8(int rollno,float percentage){
        this.rollno=rollno;
        this.percentage=percentage;
    }
    public int Getrollno(){
        return rollno;
    }
    public void show(){
        System.out.println("roll no:="+rollno);
        System.out.println("percentage"+percentage);
    }
}
class CollegeStudent extends Student8{
    private int sem;
    CollegeStudent(){

    }
    CollegeStudent (int rollno,float percentage,int sem){
        super(rollno,percentage);
        this.sem=sem;
    }
    public void show1(){
        super.show();
        System.out.println("roll no:="+sem);
    }
}
class SchoolStudent extends Student8{
    private int classname;

    SchoolStudent(){

    }
    SchoolStudent (int rollno,float percentage,int classname){
        super(rollno,percentage);
        this.classname=classname;
    }
    public void show3(){
        super.show();
        System.out.println("roll no:="+classname);
    }
}
class Main{
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);

    System.out.print("Enter the no of college student ");
    int c= sc.nextInt();
    System.out.print("enter the no of school student");
    int s=sc.nextInt();

    Student8 object[]=new Student8[c+s];
    for(int i=0;i<c+s;i++){
        if(i<c){
            System.out.println("enter information about college student");
            System.out.print("enter the roll no");
            int rollno=sc.nextInt();
            System.out.print("enter the percentage");
            float percentage=sc.nextFloat();
            System.out.print("enter the semester");
            int sem=sc.nextInt();
            object[i]=new CollegeStudent (rollno,percentage,sem);
        } else{
                System.out.println("enter information about School Student");
                System.out.print("enter sch student roll no");
                int rollno=sc.nextInt();
                System.out.print("enter sch student percentage");
                float percentage=sc.nextFloat();
                System.out.print("enter sch student classname");
                int classname=sc.nextInt();
                object[i]=new SchoolStudent(rollno,percentage,classname);
            }
        }
                System.out.println("#student of information #");
                for(int i=0;i<c+s;i++){
                    if(i<c)
                        object[i].show();
                    else
                        object[i].show();
                }
 System.out.println("search record on the basic of rollno and check given rollno is of SchoolStudent or of CollegeStudent...");
                System.out.print("enter the rollno");
                int num=sc.nextInt();
                boolean flag=true;
                for(int i = 0; i < c + s; i++){
                    if(object[i].rollno == num){
                        flag=false;
                        if(i<c)
                            System.out.println("college student");
                         else
                            System.out.println("School student");
                            break;
                        }
                    }
                            if(flag)
                            System.out.print("not found");
                            int count=0;
                            System.out.println("how many student have A-grade per>75");
                            for(int i=0;i<c+s;i++){
                                if(object[i].percentage>=75)
                                count++;
                            }
                            System.out.print(count);
                        }
                    } 
                  
    /*CollegeStudent obj=new CollegeStudent(1,65f,1);
    CollegeStudent obj1=new CollegeStudent(2,75f,2);

    SchoolStudent obj3=new SchoolStudent(3 ,62f,12);
    SchoolStudent obj4=new SchoolStudent(3 ,94f,12);
    SchoolStudent obj5=new SchoolStudent(3 ,83f,12);

    System.out.print("college student information:-");
    obj.show1();
    obj1.show1();

    System.out.print("Schoolstudent information");
    obj3.show3();
    obj4.show3();
    obj5.show3();
}
}*/



