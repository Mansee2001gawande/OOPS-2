import java.util.Scanner;

public class As8extra {    //As8extra == student
    protected int rollno;
    protected float percentage;

    public As8extra() {

    }

    public As8extra(int rollno, float percentage) {
        this.rollno = rollno;
        this.percentage = percentage;
    }

    public void m1() {
        System.out.println("rollnumber::" + rollno);
        System.out.println("percentage::" + percentage);
    }
}

class CollegeStudent extends As8extra {
    protected int semster;

    public CollegeStudent() {

    }

    public CollegeStudent(int rollno, float percentage, int semster) {
        super(rollno, percentage);
        this.semster = semster;

    }

    public void m1() {
        super.m1();
        System.out.println("Semster::" + semster);
    }
}

class SchoolStudent extends As8extra {
    protected int classroom;

    public SchoolStudent() {

    }

    public SchoolStudent(int rollno, float percentage, int classroom) {
        super(rollno, percentage);
        this.classroom = classroom;

    }

    public void m1() {
        super.m1();
        System.out.println("Classroom::" + classroom);
    }
}

 class assigment8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter Number of college Student: ");
        int n = sc.nextInt();
        System.out.print("enter Number of school Student: ");
        int m = sc.nextInt();
        As8extra obj[] = new As8extra[n + m];
        for (int i = 0; i < n + m; i++) {
            if (i < n) {
                System.out.println("enter information College student");
                System.out.print("enter rollNumber: ");
                int rollno = sc.nextInt();
                System.out.print("enter percentage: ");
                float percentage = sc.nextFloat();
                System.out.print("enter members Semester: ");
                int semster = sc.nextInt();
                obj[i] = new CollegeStudent(rollno, percentage, semster);
            } else {
                System.out.println("enter information School student ");
            
                System.out.print("enter rollNumber: ");
                int rollno = sc.nextInt();
                System.out.print("enter percentage: ");
                float percentage = sc.nextFloat();
                System.out.print("enter members class name: ");
                int classroom = sc.nextInt();
                obj[i] = new SchoolStudent(rollno, percentage, classroom);
            }
        }
        System.out.println("**Information of Students**");
        for (int i = 0; i < n + m; i++) {
            if (i < n)
                obj[i].m1();
            else
                obj[i].m1();
        }
        System.out.println( "search record on the basic of rollno and check given rollno is of SchoolStudent or of CollegeStudent...");
        System.out.print("enter rollnumber: ");
        int num = sc.nextInt();
        boolean flag = true;
        for (int i = 0; i < n + m; i++) {
            if (obj[i].rollno == num) {
                flag = false;
                if (i < n)
                    System.out.println("College Student");
                else
                    System.out.println("Student Student");
                break;
            }
        }
        if (flag)
            System.out.println("NOt found");
        int count = 0;
        System.out.println("How many student--A Grade percentage>75...");
        for (int i = 0; i < n + m; i++) {
            if (obj[i].percentage >= 75)
                count++;
        }
        System.out.println(count);
    }
}