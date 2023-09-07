/* 11) Create an Abstract class Processor with int member variable data and method showData to 
display data value.Create abstract method process() to define processing of member data.Create a
 class Factorial using abstract class Processor to calculate and print factorial of a number by
overriding the process method.Create a class Circle using abstract class Processor to calculate 
and print area of a circle by overriding the process method Ask user to enter choice (factorial
or circle area). Also ask data to work upon; Use Processor class reference to achieve this 
mechanism.*/
import java.util.Scanner;
public abstract class Processor {   //when we declare method abstract .class must be abstract
     int data;
    Processor(){

    }
    public void showData(){
        System.out.print("data value"+data);
    }
     abstract public void process();
}
class Factorial extends Processor{
    Factorial(){

    }
     public void process(){
        int  fact=1;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the the no for factorial");
        int no=sc.nextInt();
        while(no>0){
            fact=fact*no;
            no--;
        }
        System.out.println("factorial of given no is" +fact);
         data=fact;
    }
}
class Circle extends Processor{
    public void process(){
        Scanner sc=new Scanner(System.in);
        float area;
        System.out.println("enter the radius");
        float radius=sc.nextFloat();
        area=3.14f*radius*radius;
        data=(int)area;
    }
}
class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        System.out.println("enter the your choice area for-1 ");
        //char a=sc.next().charAt(0);
        int a=sc.nextInt();
        //a=(int)97;

        if(a==1){
        Processor f=new Factorial();    //overriding the process method Ask user to enter choice
        f.process();
        f.showData();
        }
        //System.out.println("enter the your choice Factorial for-2 ");
        //int f=sc.nextInt();
        else  {
        Processor c=new Circle();
        c.process();
        c.showData ();

        }



        

        


    }
}


