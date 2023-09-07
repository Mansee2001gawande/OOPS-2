import java.util.Scanner;
public class Sem1 {
    int statistic,maths,problemsolving,pc,english,dco,pcpr,cpr;
    Sem1(int statistic,int maths,int problemsolving,int pc,int english,int dco,int pcpr,int cpr){
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
class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter length of subjects : ");
        int sublength=sc.nextInt();
        System.out.println("enter total marks od each papers : ");
        int total=sc.nextInt();
        int passing=total/3;
        System.out.println(passing);
        Sem1 obtained []=new Sem1 [sublength];
      for(int i=0;i<sublength;i++){
        if(i<sublength){
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
        obtained[i]=new Sem1(statistic,maths,problemsolving,pc,english,dco,pcpr,cpr);
        }
    }
        for(int i=0;i<sublength;i++){
            obtained[i].show();
        }
        for(int i=0;i<sublength;i++){
            boolean flag=true;
            if(obtained[i].statistic>=passing) {
            if(flag)
            System.out.println("you have atkt in statistics");
            }

        }
    } 
} 

