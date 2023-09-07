/*) Create three classes  Faculty  (facultyid, salary), FullTimeFaculty  (basic, allowance) inherits class
 Faculty, PartTimeFaculty  (hour, rate) inherits class Faculty. Create   a   method   for   accepting 
 input   in   FullTimeFaculty  and  PartTimeFaculty,  but   salary  should   not  be  accepted salary   is
calculated   on   the   basis   of   (basic+allowance)   for   FullTimeFaculty   and  (hour*rate)   for 
PartTimeFaculty.   Also   create   method   in   above   classes   to  display faculty data.Create another   
class(say   XYZ)   for   main   method   and   store   2 fulltime and 2 parttime faculty information.
Also print their details. 
*/
 public class Faculty7 {
    private int facultyid;
    private int salary;

        Faculty7(){

        }
    public Faculty7(int facultyid,int salary){
        this.facultyid=facultyid;
        this.salary=salary;
    }
    public int Getsalary(){
        return salary;
    }
    public void display(){
        System.out.println("facultyid = " +facultyid);
        System.out.println("salary = " +salary);
    }
}
 class FulltimeFaculty extends Faculty7{ 
    private int basic;
    private int allowance;
    public FulltimeFaculty(int facultyid,int basic,int allowance){
        super(facultyid,basic+allowance);
        this.basic=basic;
        this.allowance=allowance;

         }
         public int method(){
            return Getsalary();

         }
            public void display1() {
                super.display();
                System.out.println(" basic = " +basic);
                System.out.println("allowance = " +allowance);

         }
    }
    class ParttimeFaculty extends Faculty7{
        private int hour;
        private int rate;
        ParttimeFaculty (int facultyid,int hour,int rate){
            super(facultyid,hour*rate);
            this.hour=hour;
            this.rate=rate;
            }

            public int method(){
            return Getsalary(); 
            }
        public void display2(){
            super.display();
            System.out.println("Working hour : "+hour);
            System.out.println("Working rate : "+rate);
        }
    }
     class Main{
        public static void main(String[] args) {
        FulltimeFaculty obj = new FulltimeFaculty(1, 50000, 10000);
        ParttimeFaculty obj1 =new ParttimeFaculty(2,5500,600);
        
            System.out.println("For Fulltime Faculty information");
           obj.display1();
           System.out.println("For Parttime Faculty information");
           obj1.display2();
        }

     }
    
