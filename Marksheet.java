import java.util.Scanner;

public class Marksheet {
      /*   public void format(){
        System.out.println("-------------------------------------------");
        System.out.println("\t DEVI AHILYA VISHWAVIDYALAY,INDORE \t");
        System.out.println("\t STATEMENT OF MARKS \t");
        System.out.println("-------------------------------------------");
        System.out.println(" \t (GRADE 'A+' UNIVERSITY,ACCREDITED BY NAAC)");
        System.out.println("JUL-2022");
        System.out.println("Roll no-:       \t  kum :-.");
        System.out.println("Enrollment no-: \t  F/H:-");
        System.out.println("Regular         \t P.M.B. GUJRATI SCIENCE COLLEGE,INDORE");
        System.out.println("---------------------------------------------------"); */
        int statistic,maths,problemsolving,pc,english,dco,pcpr,cpr;
        Marksheet(int statistic,int maths,int problemsolving,int pc,int english,int dco,int pcpr,int cpr){
            this.statistic=statistic;
            this.maths=maths;
            this.problemsolving=problemsolving;            
            this.pc=pc;
            this.english=english;
            this.dco=dco;
            this.pcpr=pcpr;
            this.cpr=cpr;
        }
        public void show(){
            System.out.println(" "+statistic);
            System.out.println(" "+maths);
            System.out.println(" "+problemsolving);
            System.out.println(" "+pc);
            System.out.println(" "+english);
            System.out.println(" "+dco);
            System.out.println(" "+pcpr);
            System.out.println(" "+cpr);
}
    }

    class Sem1{
        private int rollno;
        private int enrollment;
        private String Status;
        private String name;
        private String father;
        Sem1(){

        }
        Sem1(int rollno,int enrollment,String Status,String name,String father){
            this.rollno = rollno;
            this.enrollment = enrollment;
            this.Status = Status;
            this.name = name;
            this.father = father;
         }
         public void display(){
         System.out.print(rollno);
         System.out.print(enrollment);
         System.out.print(Status);
        System.out.println(name);
        System.out.println(father);

         }
    }
   // class Sem2{
   // Sem2(int rollno,int enrollment,String Status,String name,String father){
       // super(rollno,enrollment,Status,name,father);
   // }
       // public void display2(){
            //super.display();
      // }
    //}
class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
            System.out.println("enter information about college student: ");
            System.out.println("enter the roll no: ");
            int rollno=sc.nextInt();
            System.out.println("enter the enrollment no: ");
            int enrollment=sc.nextInt();

            System.out.println("enter the Status ragular/private: ");
            String status=sc.next();
            System.out.println("enter student name: ");
            String name1=sc.nextLine();
            String name=sc.nextLine();
    
            System.out.println("enter father name: ");
            String father=sc.nextLine();

            Sem1 obj=new Sem1 (rollno,enrollment,status,name,father);
            obj.display();

        System.out.println("enter the length of semester");
        int length=sc.nextInt();
        Marksheet obtained[]=new Marksheet [length];
        System.out.println("enter totol marks of each paper"); 
        int total=sc.nextInt();    //each paper total marks;
        int passing=total/3;
        System.out.println("passing"+passing);

        System.out.println("enter marks of 8 subjects of 1 by 1 to 6th sem:= ");
        for(int i=0;i<8;i++){
            if(i<length){
            //obtained[i]=sc.nextInt();
        //  if(obtained[i]<17)||(atkt>=2)
        // System.out.println("you have atkt in sub clear exam again");
            //}
        System.out.println("enter statistics marks");
         int statistic=sc.nextInt();
        System.out.println("enter maths marks");
         int maths=sc.nextInt();
        System.out.println("enter problem solving c++ marks");
        int problemsolving =sc.nextInt();
        System.out.println("enter pc software marks");
        int pc=sc.nextInt();
        System.out.println("enter english marks");
         int english=sc.nextInt();
        System.out.println("enter Dco marks");
         int dco=sc.nextInt();
        System.out.println("enter pc practical marks");
         int pcpr=sc.nextInt();
        System.out.println("enter c language marks");
       int cpr=sc.nextInt();
        obtained[i]=new Marksheet(statistic,maths,problemsolving,pc,english,dco,pcpr,cpr);
       // obtained[i]>=passing;
         }
    }
        System.out.println("#marks of subject information #");
        for(int i=0;i<length;i++){
            if(i<length)
            obtained[i].show();
            }

            //int count=0;
            boolean flag=true;
            for(int i = 0; i < length; i++) {    //length=how many semester;
            if((obtained[i].statistic>=passing)||(obtained[i].maths>=passing)||(obtained[i].problemsolving>=passing)
            ||(obtained[i].pc>=passing)||(obtained[i].english>=passing)||(obtained[i].english>=passing)||(
            obtained[i].dco>=passing)||(obtained[i].pcpr>=passing)||(obtained[i].cpr>=passing))
                //flag=false;
            System.out.println("you have atkt in subject give the exam of those paper again");
           // System.out.println("you cleared  your 1st sem exam(pass)");   

                    
                
             else/*  if((obtained[i].statistic>=passing)&&(obtained[i].maths>=passing)&&(obtained[i].problemsolving>=passing)
            &&(obtained[i].pc>=passing)&&(obtained[i].english>=passing)&&(obtained[i].english>=passing)&&(
            obtained[i].dco>=passing)&&(obtained[i].pcpr>=passing)&&(obtained[i].cpr>=passing)) */
            System.out.println("you cleared  your 1st sem exam(pass)");   
            
        }
    }
    }
    






                            //if(flag) {
                          //  System.out.println("you cleared  your 1st sem exam(pass)");
                      //  else //(flag=false) 
                       /*  while(obtained[i].statistic!=0){
                         obtained[i].statistic=obtained[i].statistic/10;   
                        count++;
                        } 
                        System.out.println(count);*/
