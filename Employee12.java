/*12) Create Interface Taxable with members salesTax=7% and incomeTax=10.5%.Create abstract method
 calcTax().Create class Employee(empId,name,salary) and implement Taxable to calculate incomeTax
on yearly salary.Create class Product(pid,price,quantity) and implement Taxable to calculate sales
Tax on unit price of product.Create class for main method(Say XYZ), accept employee information
 and a product information from user and print income tax and sales tax respectively.*/
 import java.util.Scanner;
 abstract interface Taxable {
    double salestax=0.07;
    double incometax=0.105;

    public abstract void calcTax();

    }
 
public class Employee12 implements Taxable {  //implement Taxable to calculate incomeTax
    private int empId;
    private String name;
    private double salary;
    Employee12(){

    }
    Employee12(int empId,String name,double salary){
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }
    public double calcTax(){
        return incometax*salary;
    }
}
class Product implements Taxable{   //implement Taxable to calculate sales Tax
    private int pid;
    private int quantity;
    private double price;

    Product(){

    }
    Product(int pid,int quantity,double price){
        this.pid=pid;
        this.quantity=quantity;
         this.price=price;
    }
        public double calcTax(){
        return incometax*price*quantity;   //calculate sales Tax on unit price of product
    }
}
class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("information about employee");
        System.out.println("enter employee id:=");
        int empId=sc.nextInt();
        System.out.println("enter employee name :=");
        String name=sc.nextLine();
        System.out.println("enter your salary :=");
        double salary=sc.nextDouble();

        System.out.println("information about product");
        System.out.println("enter product pid:-");
        int pid=sc.nextInt();
        System.out.println("enter product Quantity : =");
        int  quantity=sc.nextInt();
        System.out.println("enter product price");
        double price=sc.nextDouble();
  
        Taxable obj1=new Employee12(empId,name,salary);  //abstract/interface class obj=jis class ka obj call krna hai name 
        obj1. calcTax();                                 //obj.method

        Taxable obj2=new Product(pid,quantity,price);
        obj2.calcTax();
    }
}
