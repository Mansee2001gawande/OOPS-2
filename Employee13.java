/*13) Explain the importance of toString() and equals() method of the Object class and override 
them on class Employee (empId,name,salary).Create class for main method (say XYZ),and accept five
employees information and store in an array. Also ensure if entered empId already exist or not 
(use equals method).Display all employee info using toString() method.
*/import java.util.Scanner;
public class Employee13 {
     int empId;
    private String name;
    private int salary;
    Employee13(){
        
    }
    Employee13(int empId,String name,int salary){
        this.empId = empId;
        this.name = name;
        this.salary = salary;

       // public String toString() {
            //return empId+" "+name+" "+salary;
       // }
    }
}
class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("enter the emplyees no :=");
        int no=sc.nextInt();
        Employee13 object []=new Employee13[no];

    for(int i=0;i<no;i++){
        if(i<no){
            System.out.println("information about employees");
            System.out.println("enter employee id :=");
            int empId=sc.nextInt();
            System.out.println("enter employee name :=");
            String name=sc.nextLine();
            System.out.println("enter employee salary :=");
            int salary=sc.nextInt();
            object[i]=new Employee13(empId,name,salary);
        }
    }

        System.out.println(" entered empId already exist or not"); //using equals method
        System.out.println("enter employee id you want to search");
        int num=sc.nextInt();
        boolean flag=true;
        for(int i=0;i<no;i++){
            if(object[i].empId == num){
                flag=false;
                if(i<no)
                    System.out.println("employee id is found");
                    else
                    System.out.println("employee id is not found");
                }
            }
        System.out.println(object.toString());
        }
    }

