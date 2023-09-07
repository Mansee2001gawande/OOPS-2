import java.util.Scanner;

    class Marksheetproject {
        private int t[] = new int[6];
        private int p[] = new int[2];
        private int ti[] = new int[4];
        private String s[] = new String[6];
        private String sp[] = new String[2];
        private String si[] = new String[4];
        private String status = "Pass";
        private String back[] = new String[2];
        private int ind = 0;
        private int total = 0;
        private int attempt = 1;
        private String sem;
        private int grandtotal = total;
    
        public Marksheetproject() {
    
        }
    
        public Marksheetproject(int t[], int p[], int ti[], String s[], String sp[], String si[], String sem) {
            this.sem = sem;
            for (int i = 0; i < 2; i++) {
                this.p[i] = p[i];
                this.sp[i] = sp[i];
                total += p[i];
            }
            for (int i = 0; i < 4; i++) {
                this.si[i] = si[i];
                this.ti[i] = ti[i];
                total += ti[i];
            }
            for (int i = 0; i < 6; i++) {
                this.t[i] = t[i];
                this.s[i] = s[i];
                total += t[i];
                if ((s[i].equals(sp[0]) || s[i].equals(sp[1])) && t[i] < 17) {
                    if (ind == 2) {
                        status = "Fail";
                        continue;
                    }
                    status = "ATKT";
                    back[ind] = s[i];
                    ind++;
    
                }
                if ((!s[i].equals(sp[0]) && !s[i].equals(sp[1])) && t[i] < 13) {
                    if (ind == 2) {
                        status = "Fail";
                        continue;
                    }
                    status = "ATKT";
                    back[ind] = s[i];
                    ind++;
    
                }
    
            }
        }
    
        public int numberOfBacks() {
            return ind;
        }
    
        public String[] backSubjects() {
            return back;
        }
    
        public void setMarks(int marks[]) {
            attempt++;
            status = "Pass";
            int index = 0;
            for (int j = 0; j < ind; j++) {
                for (int i = 0; i < 6; i++) {
                    if (back[j].equals(s[i])) {
                        if ((s[i].equals(sp[0]) || s[i].equals(sp[1])) && marks[j] < 17) {
                            back[index] = back[j];
                            index++;
                            status = "ATKT";
                        }
                        if ((!s[i].equals(sp[0]) && !s[i].equals(sp[1])) && marks[j] < 13) {
                            back[index] = back[j];
                            index++;
                            status = "ATKT";
                        }
    
                        total -= t[i];
                        t[i] = marks[j];
                        total += t[i];
                    }
                }
            }
            ind = index;
        }
    
        public String status() {
            return status;
        }
    
        public int getTotal() {
            return total;
        }
    
        public void showHeader() {
            System.out.println(
                    "|------------------------------------------------------------------------------------------------|");
            System.out.println("\t\t\t\t\t  RESULT");
            System.out.println(
                    "|------------------------------------------------------------------------------------------------|");
            System.out.println(
                    "|________________________________|");
    
            System.out
                    .println("|Exam Name:     |" + "B.C.A. " + sem + "  |" + "Enrollment No:     |" + "DX2006463          |"
                            + "Roll No.:       90070171" + " |");
            System.out.println("|Name:          |" + "Kum.Mansee " + "                |" + "Father's Name:    "
                + "Mr.Vijay" + "                 |");
            System.out.println("|Status:        |" + "REGULAR       |"
                    + "College: Campus Of Best Moral College " + "                           |");
            System.out.println(
                    "|________________________________|");
    
        }
    
        public void showMiddle() {
            String ANSI_RED = "\u001B[31m";
            String ANSI_RESET = "\u001B[0m";
           
            System.out.print("|\t\tSubject\t\t");
    
            System.out.println("|\tMax Marks      |       Marks Obtained\t|\t\t |");
            System.out
                    .println(
                            "|________________________________|");
            System.out.println("|\t\t\t\t| I | II | III | Total |  I  | II | III | Total |\t\t |");
    
            for (int i = 0; i < 6; i++) {
                System.out.print("|" + s[i]);
                for (int x = s[i].length(); x < 24; x++) {
                    System.out.print(" ");
                }
                if (s[i].equals(sp[0]) || s[i].equals(sp[1])) {
                    System.out.print(
                            "    T\t| 50|\t       |  " + " 50" + "  |  " + t[i] + " |\t        |   " + t[i] + "  |\t\t |");
                } else {
                    System.out.print(
                            "    T\t| 40|\t       |  " + " 40" + "  |  " + t[i] + " |\t        |   " + t[i] + "  |\t\t |");
                }
                if (status.equals("ATKT") && (s[i] == back[0] || s[i] == back[1])) {
                    System.out.print(ANSI_RED + "ATKT" + ANSI_RESET);
                }
                System.out.println();
            }
            for (int i = 0; i < 4; i++) {
                System.out.print("|" + si[i]);
                for (int x = si[i].length(); x < 24; x++) {
                    System.out.print(" ");
                }
                System.out.println(
                        "    P\t| 10|\t       |  " + " 10" + "  |   " + ti[i] + " |\t        |    " + ti[i] + "  |\t\t |");
            }
            for (int i = 0; i < 2; i++) {
                System.out.print("|" + sp[i]);
                for (int x = sp[i].length(); x < 24; x++) {
                    System.out.print(" ");
                }
                System.out.println(
                        "    P\t| 25|\t       |  " + " 25" + "  |  " + p[i] + " |\t        |   " + p[i] + "  |\t\t |");
            }
        }
    
        public void showTotal() {
            System.out.println(
                    "|------------------------------------------------------------------------------------------------|");
            System.out.println("|     \t\t\t\t\t       |  " + "350" + "  |  GRAND TOTAL   |  " + total + "  |\t\t |");
            System.out.println(
                    "|________________________________|");
        }
    
        public void showFooter() {
            System.out.println(
                    "|------------------------------------------------------------------------------------------------|");
            System.out
                    .println("|  IYr   |  IIYr  |  IIIYr  |  Total Marks  | Result | Division |  Attempt  |\t\t         |");
            System.out.println(
                    "|------------------------------------------------------------------------------------------------|");
            System.out.println("|Obt.|Max|Obt.|Max|Obt.|Max |  Obt. |  Max  | " + status + "   |          |     " + attempt
                    + "     |\t\t         |");
            System.out.println(
                    "|------------------------------------------------------------------------------------------------|");
        }
    
        public void show2(int total[]) {
            for (int i = 0; i < 6; i++) {
                System.out.print("|SEMESTER-" + (i + 1));
                for (int x = 10; x < 24; x++) {
                    System.out.print(" ");
                }
                grandtotal = grandtotal + total[i];
                // System.out.println(" T\t 350\t\t" + total[i]);
                System.out.println("    T\t|350|\t       |  " + "350" + "  | " + total[i] + " |\t        |  " + total[i]
                        + "  |\t\t |");
    
            }
            System.out.println(
                    "|------------------------------------------------------------------------------------------------|");
            System.out.println("|     \t\t\t\t\t       |  " + "2100" + " |  GRAND TOTAL   |  " + grandtotal + "  |\t\t |");
            System.out.println(
                    "|________________________________|");
        }
    
        public void showMigration() {
            System.out.println("\t\t____________________________\n");
            System.out.println("\t\t|\t\t\t\t\t\t\t\t\t\t |\n");
            System.out.println("\t\t|\t\t  DEVI AHILYA VISHWA VIDYALAYA, INDORE (M.P.)\t\t\t |\n");
            System.out.println("\t\t|\t\t\t\t\t\t\t\t\t\t |\n");
            System.out.println("\t\t|\t\t\tMIGRATION CERTIFICATE - 2022\t\t\t\t |");
            System.out.println("\t\t|\t\t\t\t\t\t\t\t\t\t |\n");
            System.out.println("\t\t|\t Shri/ku./Shrimati Mansee Gawande Entrolment No. |,DX1910480");
            System.out.println("\t\t|\t is informed that this University has no Objection to his/ her\t\t |\n");
            System.out.println("\t\t|\t migrating to another University.He/ She has graduated as a\t\t |\n");
            System.out.println("\t\t|\t student  at Bachelor of Computer Application  Examination.\t\t |\n");
            System.out.println("\t\t|\t\t\t\t\t\t\t\t\t\t |\n");
            System.out.println("\t\t|\t\t\t\t\t\t\t\t\t\t |\n");
            System.out.println("\t\t|\t\t\t\t\t\t\t\t\t\t |\n");
            System.out.println("\t\t|\t University House\t\t\t\t\tsign\t\t |\n");
            System.out.println(
                    "\t\t|\t Indore-452001\t\t\t\t\t\t\t\t |\n\t\t|\t Date:16/08/2023\t\t\t\t\t\t\t\t |\n");
            System.out.println("\t\t|\t\t\t\t\t\t\t\t\t\t |\n");
            System.out.println("\t\t|\t\t\t\t\t\t\t\t\t\t |\n");
            System.out.println("\t\t|\t\t\t\t\t\t\t\t\t\t |\n");
            System.out.println("\t\t|____________________________|\n");
        }
    
        public void showTC() {
            System.out.println("\t\t|\t\t\t\t\t\t\t\t\t\t |\n");
            System.out.println(" \t\t|\t\t      DEVI AHILYA VISHWA VIDYALAYA, INDORE (M.P.)\t\t |\n");
            System.out.println(" \t\t|\t\t\tA.B. Road,Indore - 452 017\t\t\t\t |\n");
            System.out.println(" \t\t\t    web site : www.davvcollege.org. E-mail : contact@davvcollege.com\n \n");
            System.out.println(" \t\t\tBook No. 32\t\t\t\t\tSerial No. A \n");
            System.out.println(" \n\n\t\t\t\t\tCOLLEGE LEAVING CERTIFICATE \n");
            System.out.println("\n\t\t\tCollege Roll no.10325462\t\t\tDate:16/08/2023\n");
            System.out.println(
                    "\n\n\t\t\tIt is to Certify that Ku. / Shri : Mansee Gawande \n\t\t\tFather Name :  Shri Vijay Gawande \n\t\t\tMother's Name Smt. : Alka Gawande\n");
            System.out.println(" \n\t\t\tDevi Ahilya Vishwavidyalaya, Indore Entollment No. : DX1910480\n");
            System.out.println(" \t\t\tWas a  student of this college from year 2019 to year\n");
            System.out.println(" \t\t\t2022 in class BCA 1st sem to 6th sem .\n");
            System.out.println("\n \t\t\tHis/her result of last examination held in the year 2022 class \n");
            System.out.println(" \t\t\tB.C.A Passed.His / Her Conduct and Character during the period of \n");
            System.out.println(" \t\t\tstudy in this college known to the undersigned was GOOD Reason \n");
            System.out.println(" \t\t\tfor leaving this college . \n");
            System.out.println("\n\n\t\t|\t\t\t\t\t\tPrincipal Registrar\t\t |\n");
            System.out.println("\t\t|\t\t\t\t\t\t\t\t\t\t |\n");
            System.out.println("\t\t|____________________________|\n");
        }
    
        public void showDegree() {
           
            System.out.println(
                    "\t\033[0;30m\033[47m                                                                                     \033[0m");
            System.out.println(
                    "\t\033[0;30m\033[47m\033[1;30m                     DEVI AHILYA VISHWAVIDYALAYA , INDORE                            \033[0m");
            System.out.println(
                    "\t\033[0;30m\033[47m                                                                                     \033[0m");
            System.out.println(
                    "\t\033[0;30m\033[47m----------------------------------STATEMENT OF MARKS---------------------------------\033[0m");
            System.out.println(
                    "\t\033[0;30m\033[47m                                                                                     \033[0m");
            System.out.println(
                    "\t\033[0;30m\033[47m                     On Recommendation of The Academic Council                       \033[0m");
            System.out.println(
                    "\t\033[0;30m\033[47m                              has Conferred Upon                                     \033[0m");
            System.out.println(
                    "\t\033[0;30m\033[47m                                                                                     \033[0m");
            System.out.println(
                    "\t\033[0;30m\033[47m                                                                                     \033[0m");
            System.out.println(
                    "\t\033[0;30m\033[47m\033[1;30m                                    Mansee                                         \033[0m");
            System.out.println(
                    "\t\033[0;30m\033[47m                                                                                     \033[0m");
            System.out.println(
                    "\t\033[0;30m\033[47m                                 the degree of                                       \033[0m");
            System.out.println(
                    "\t\033[0;30m\033[47m                                                                                     \033[0m");
            System.out.println(
                    "\t\033[0;30m\033[47m\033[1;30m                    Becholer Of Computer Application                                 \033[0m");
            System.out.println(
                    "\t\033[0;30m\033[47m                                                                                     \033[0m");
            System.out.println(
                    "\t\033[0;30m\033[47m                     having passed the examination of 2023-2024                      \033[0m");
            System.out.println(
                    "\t\033[0;30m\033[47m                in first Division with all its right and privileges                  \033[0m");
            System.out.println(
                    "\t\033[0;30m\033[47m          in witness whereof the seal of the university is hereunto affixed.         \033[0m");
            System.out.println(
                    "\t\033[0;30m\033[47m                     given on this 16th day of August. 2023-2024.                    \033[0m");
            System.out.println(
                    "\t\033[0;30m\033[47m                                                                                     \033[0m");
            System.out.println(
                    "\t\033[0;30m\033[47m                                                                                     \033[0m");
            System.out.println(
                    "\t\033[0;30m\033[47m                                                                                     \033[0m");
            System.out.println(
                    "\t\033[0;30m\033[47m                                                                                     \033[0m");
            System.out.println(
                    "\t\033[0;30m\033[47m                                                                                     \033[0m");
            System.out.println(
                    "\t\033[0;30m\033[47m                                                                                     \033[0m");
            System.out.println(
                    "\t\033[0;30m\033[47m_____________________________\033[0m");
        }
    }
    
     class Marksheet {
        public static void main(String args[]) {
            Scanner sc = new Scanner(System.in);
            int t[] = new int[6];
            int p[] = new int[2];
            int ti[] = new int[4];
            int marks[] = new int[2];
            int ind;
            String backsub[];
            boolean repeat = true;
            Marksheetproject sem1 = null;
            Marksheetproject sem2 = null;
            Marksheetproject sem3 = null;
            Marksheetproject sem4 = null;
            Marksheetproject sem5 = null;
            Marksheetproject sem6 = null;
            String RED = "\u001B[31m";
            String GREEN = "\u001B[32m";
            String YELLOW = "\u001B[33m";
            String RESET =  "\u001B[0m";
            while (repeat) {
                System.out.println("Enter marks for 1st semester : ");
                String s[] = { "Mathematics-1", "Statistics-1", "Programming C-1", "PC Software", "English",
                        "Digital C.O." };
                String sp[] = { "Programming C-1", "PC Software" };
                String si[] = { "Mathematics-1", "Statistics-1", "English", "Digital C.O." };
                System.out.println(YELLOW+"Enter marks of theory exams : "+RESET);
                for (int i = 0; i < 6; i++) {
                    System.out.println(s[i] + " : ");
                    t[i] = sc.nextInt();
                    if ((s[i].equals(sp[0]) || s[i].equals(sp[1])) && (t[i] < 0 || t[i] > 50)) {
                        System.out.println(RED+"Invalid Input : "+RESET);
                        i--;
                    } else if ((!s[i].equals(sp[0]) && (!s[i].equals(sp[1]))) && (t[i] < 0 || t[i] > 40)) {
                        System.out.println(RED+"Invalid Input : "+RESET);
                        i--;
                    }
                }
                System.out.println(YELLOW+"Enter marks of practical exam out of 25 : "+RESET);
                for (int i = 0; i < 2; i++) {
                    System.out.println(sp[i] + " : ");
                    p[i] = sc.nextInt();
                    if ((p[i] < 0) || (p[i] > 25)) {
                        System.out.println(RED+"Invalid Input : "+RESET);
                        i--;
                    }
                }
                System.out.println(YELLOW+"Enter marks of Internal exam out of 10 :  "+RESET);
                for (int i = 0; i < 4; i++) {
                    System.out.println(si[i] + " : ");
                    ti[i] = sc.nextInt();
                    if ((ti[i] < 0) || (ti[i] > 10)) {
                        System.out.println(RED+"Invalid Input : "+RESET);
                        i--;
                    }
                }
                sem1 = new Marksheetproject(t, p, ti, s, sp, si, "SEM-1");
                repeat = sem1.status().equals("Fail");
                if (sem1.status().equals("Fail")) {
                    System.out.println(RED + "You are not promoted to next semester :" + RESET);
                }
                if (sem1.status().equals("ATKT")) {
                    System.out.println(YELLOW + "You are promoted to next semester with T+RESETKT in " + sem1.numberOfBacks()
                            + " subjects" + RESET);
                }
                if (sem1.status().equals("Pass")) {
                    System.out.println(GREEN + "Congratulations! You are promoted to next semester :" + RESET);
                }
    
            }
            repeat = true;
            sem1.showHeader();
            sem1.showMiddle();
            sem1.showTotal();
            sem1.showFooter();
    
            while (repeat) {
                System.out.println(YELLOW+"Enter marks for 2nd semester : "+RESET);
    
                String s2[] = { "Mathematics-II", "P & P through C-II", "Statistics-II", "Operating System", "Hindi",
                        "Intro to info system" };
                String sp2[] = { "P & P through C-II", "Intro to info system" };
                String si2[] = { "Mathematics-II", "Statistics-II", "Operating System", "Hindi" };
                System.out.println(YELLOW+"Enter marks of theory exams : "+RESET);
                for (int i = 0; i < 6; i++) {
                    System.out.println(s2[i] + " : ");
                    t[i] = sc.nextInt();
                    if ((s2[i].equals(sp2[0]) || s2[i].equals(sp2[1])) && (t[i] < 0 || t[i] > 50)) {
                        System.out.println("Invalid Input : ");
                        i--;
                    } else if ((!s2[i].equals(sp2[0]) && (!s2[i].equals(sp2[1]))) && (t[i] < 0 || t[i] > 40)) {
                        System.out.println("Invalid Input : ");
                        i--;
                    }
                }
                System.out.println(YELLOW+"Enter marks of practical exam out of 25 :"+RESET);
                for (int i = 0; i < 2; i++) {
                    System.out.println(sp2[i] + " : ");
                    p[i] = sc.nextInt();
                    if ((p[i] < 0) || (p[i] > 25)) {
                        System.out.println("Invalid Input : ");
                        i--;
                    }
                }
                System.out.println(YELLOW+"Enter marks of Internal exam out of 10 :  "+RESET);
                for (int i = 0; i < 4; i++) {
                    System.out.println(si2[i] + " : ");
                    ti[i] = sc.nextInt();
                    if ((ti[i] < 0) || (ti[i] > 10)) {
                        System.out.println("Invalid Input : ");
                        i--;
                    }
                }
                sem2 = new Marksheetproject(t, p, ti, s2, sp2, si2, "SEM-2");
                repeat = sem2.status().equals("Fail");
                if (sem2.status().equals("Fail")) {
                    System.out.println(RED + "You are not promoted to next semester :" + RESET);
                }
                if (sem2.status().equals("ATKT")) {
                    System.out.println(YELLOW + "You are promoted to next semester with T+RESETKT in " + sem2.numberOfBacks()
                            + " subjects" + RESET);
                }
                if (sem2.status().equals("Pass")) {
                    System.out.println(GREEN + "Congratulations! You are promoted to next semester :" + RESET);
                }
            }
            repeat = true;
            sem2.showHeader();
            sem2.showMiddle();
            sem2.showTotal();
            sem2.showFooter();
            if (sem1.status().equals("ATKT")) {
                ind = sem1.numberOfBacks();
                backsub = sem1.backSubjects();
                for (int i = 0; i < ind; i++) {
                    System.out.print("Enter SEM-1 " + backsub[i] + " marks : ");
                    marks[i] = sc.nextInt();
                }
                sem1.setMarks(marks);
                System.out.println(
                        "===========================================================================================================");
                System.out.println();
                sem1.showHeader();
                sem1.showMiddle();
                sem1.showTotal();
                sem1.showFooter();
            }
    
            while (repeat) {
                System.out.println("Enter marks for 3rd Semester : ");
                String s3[] = { "Descrete Math", "Unix Ope Sys", "OOPS & C++", "ACC & Finan MGM", "Data Structure",
                        "Comm Skill" };
                String sp3[] = { "Data Structure", "Unix Ope Sys" };
                String si3[] = { "Descrete Math", "OOPS & C++", "ACC & Finan MGM", "Comm Skill" };
                System.out.println("Enter marks of theory exams : ");
                for (int i = 0; i < 6; i++) {
                    System.out.println(s3[i] + " : ");
                    t[i] = sc.nextInt();
                    if ((s3[i].equals(sp3[0]) || s3[i].equals(sp3[1])) && (t[i] < 0 || t[i] > 50)) {
                        System.out.println("Invalid Input : ");
                        i--;
                    } else if ((!s3[i].equals(sp3[0]) && (!s3[i].equals(sp3[1]))) && (t[i] < 0 || t[i] > 40)) {
                        System.out.println("Invalid Input : ");
                        i--;
                    }
                }
                System.out.println("Enter marks of practical exam out of 25 : ");
                for (int i = 0; i < 2; i++) {
                    System.out.println(sp3[i] + " : ");
                    p[i] = sc.nextInt();
                    if ((p[i] < 0) || (p[i] > 25)) {
                        System.out.println("Invalid Input : ");
                        i--;
                    }
                }
                System.out.println("Enter marks of Internal exam out of 10 :  ");
                for (int i = 0; i < 4; i++) {
                    System.out.println(si3[i] + " : ");
                    ti[i] = sc.nextInt();
                    if ((ti[i] < 0) || (ti[i] > 10)) {
                        System.out.println("Invalid Input : ");
                        i--;
                    }
                }
                sem3 = new Marksheetproject(t, p, ti, s3, sp3, si3, "SEM-3");
                repeat = sem3.status().equals("Fail");
                if (sem3.status().equals("Fail")) {
                    System.out.println(RED + "You are not promoted to next semester :" + RESET);
                }
                if (sem3.status().equals("ATKT")) {
                    System.out.println(YELLOW + "You are promoted to next semester with T+RESETKT in " + sem3.numberOfBacks()
                            + " subjects" + RESET);
                }
                if (sem3.status().equals("Pass")) {
                    System.out.println(GREEN + "Congratulations! You are promoted to next semester :" + RESET);
                }
            }
            repeat = true;
            sem3.showHeader();
            sem3.showMiddle();
            sem3.showTotal();
            sem3.showFooter();
            if (sem1.status().equals("ATKT")) {
                ind = sem1.numberOfBacks();
                backsub = sem1.backSubjects();
                for (int i = 0; i < ind; i++) {
                    System.out.print("Enter SEM-1 " + backsub[i] + " marks : ");
                    marks[i] = sc.nextInt();
                }
                sem1.setMarks(marks);
                System.out.println(
                        "===========================================================================================================");
                System.out.println();
                sem1.showHeader();
                sem1.showMiddle();
                sem1.showTotal();
                sem1.showFooter();
            }
            if (sem2.status().equals("ATKT")) {
                ind = sem2.numberOfBacks();
                backsub = sem2.backSubjects();
                for (int i = 0; i < ind; i++) {
                    System.out.print("Enter SEM-2 " + backsub[i] + " marks : ");
                    marks[i] = sc.nextInt();
                }
                sem2.setMarks(marks);
                System.out.println(
                        "===========================================================================================================");
                System.out.println();
                sem2.showHeader();
                sem2.showMiddle();
                sem2.showTotal();
                sem2.showFooter();
            }
    
            while (repeat) {
                System.out.println(GREEN+"Enter marks for 4th semester : "+RESET);
                String s4[] = { "CONM.", "Software Eng.", "DBMS", "Prog. With Java", "Env. Awareness", "Enterpreniurship" };
                String sp4[] = { "CONM", "DBMS" };
                String si4[] = { "Software Eng.", "Prog. With Java", "Env. Awareness", "Enterpreniurship" };
                System.out.println(YELLOW+"Enter marks of theory exams : "+RESET);
                for (int i = 0; i < 6; i++) {
                    System.out.println(s4[i] + " : ");
                    t[i] = sc.nextInt();
                    if ((s4[i].equals(sp4[0]) || s4[i].equals(sp4[1])) && (t[i] < 0 || t[i] > 50)) {
                        System.out.println(RED+"Invalid Input : "+RESET);
                        i--;
                    } else if ((!s4[i].equals(sp4[0]) && (!s4[i].equals(sp4[1]))) && (t[i] < 0 || t[i] > 40)) {
                        System.out.println(RED+"Invalid Input : "+RESET);
                        i--;
                    }
                }
                System.out.println(YELLOW+"Enter marks of practical exam out of 25 : "+RESET);
                for (int i = 0; i < 2; i++) {
                    System.out.println(sp4[i] + " : ");
                    p[i] = sc.nextInt();
                    if ((p[i] < 0) || (p[i] > 25)) {
                        System.out.println(RED+"Invalid Input : "+RESET);
                        i--;
                    }
                }
                System.out.println(YELLOW+"Enter marks of Internal exam out of 10 :  "+RESET);
                for (int i = 0; i < 4; i++) {
                    System.out.println(si4[i] + " : ");
                    ti[i] = sc.nextInt();
                    if ((ti[i] < 0) || (ti[i] > 10)) {
                        System.out.println(RED+"Invalid Input : "+RESET);
                        i--;
                    }
                }
                sem4 = new Marksheetproject(t, p, ti, s4, sp4, si4, "SEM-4");
                repeat = sem4.status().equals("Fail");
                if (sem4.status().equals("Fail")) {
                    System.out.println(RED + "You are not promoted to next semester :" + RESET);
                }
                if (sem4.status().equals("ATKT")) {
                    System.out.println(YELLOW + "You are promoted to next semester with T+RESETKT in " + sem4.numberOfBacks()
                            + " subjects" + RESET);
                }
                if (sem4.status().equals("Pass")) {
                    System.out.println(GREEN + "Congratulations! You are promoted to next semester :" + RESET);
                }
            }
            repeat = true;
            sem4.showHeader();
            sem4.showMiddle();
            sem4.showTotal();
            sem4.showFooter();
            if (sem1.status().equals("ATKT")) {
                ind = sem1.numberOfBacks();
                backsub = sem1.backSubjects();
                for (int i = 0; i < ind; i++) {
                    System.out.print("Enter SEM-1 " + backsub[i] + " marks : ");
                    marks[i] = sc.nextInt();
                }
                sem1.setMarks(marks);
                System.out.println(
                        "===========================================================================================================");
                System.out.println();
                sem1.showHeader();
                sem1.showMiddle();
                sem1.showTotal();
                sem1.showFooter();
            }
            if (sem2.status().equals("ATKT")) {
                ind = sem2.numberOfBacks();
                backsub = sem2.backSubjects();
                for (int i = 0; i < ind; i++) {
                    System.out.print("Enter SEM-2 " + backsub[i] + " marks : ");
                    marks[i] = sc.nextInt();
                }
                sem2.setMarks(marks);
                System.out.println(
                        "===========================================================================================================");
                System.out.println();
                sem2.showHeader();
                sem2.showMiddle();
                sem2.showTotal();
                sem2.showFooter();
            }
            if (sem3.status().equals("ATKT")) {
                ind = sem3.numberOfBacks();
                backsub = sem3.backSubjects();
                for (int i = 0; i < ind; i++) {
                    System.out.print("Enter SEM-3 " + backsub[i] + " marks : ");
                    marks[i] = sc.nextInt();
                }
                sem3.setMarks(marks);
                System.out.println(
                        "===========================================================================================================");
                System.out.println();
                sem3.showHeader();
                sem3.showMiddle();
                sem3.showTotal();
                sem3.showFooter();
            }
    
            while (repeat) {
                System.out.println("Enter marks for 5th semester : ");
                String s5[] = { "Linear Alzebra", "Computer Networks", "Human Values", "Info. Technology",
                        "Cloud Computing",
                        "Data Science" };
                String sp5[] = { "Data Science", "Cloud Computing" };
                String si5[] = { "Linear Alzebra", "Computer Networks", "Human Values", "Info. Technology" };
                System.out.println(YELLOW+"Enter marks of theory exams : "+RESET);
                for (int i = 0; i < 6; i++) {
                    System.out.println(s5[i] + " : ");
                    t[i] = sc.nextInt();
                    if ((s5[i].equals(sp5[0]) || s5[i].equals(sp5[1])) && (t[i] < 0 || t[i] > 50)) {
                        System.out.println(RED+"Invalid Input : "+RESET);
                        i--;
                    } else if ((!s5[i].equals(sp5[0]) && (!s5[i].equals(sp5[1]))) && (t[i] < 0 || t[i] > 40)) {
                        System.out.println(RED+"Invalid Input : "+RESET);
                        i--;
                    }
                }
                System.out.println(YELLOW+"Enter marks of practical exam out of 25 : "+RESET);
                for (int i = 0; i < 2; i++) {
                    System.out.println(sp5[i] + " : ");
                    p[i] = sc.nextInt();
                    if ((p[i] < 0) || (p[i] > 25)) {
                        System.out.println(RED+"Invalid Input : "+RESET);
                        i--;
                    }
                }
                System.out.println(YELLOW+"Enter marks of Internal exam out of 10 :  "+RESET);
                for (int i = 0; i < 4; i++) {
                    System.out.println(si5[i] + " : ");
                    ti[i] = sc.nextInt();
                    if ((ti[i] < 0) || (ti[i] > 10)) {
                        System.out.println(RED+"Invalid Input : "+RESET);
                        i--;
                    }
                }
                sem5 = new Marksheetproject(t, p, ti, s5, sp5, si5, "SEM-5");
                repeat = sem5.status().equals("Fail");
                if (sem5.status().equals("Fail")) {
                    System.out.println(RED + "You are not promoted to next semester :" + RESET);
                }
                if (sem5.status().equals("ATKT")) {
                    System.out.println(YELLOW + "You are promoted to next semester with T+RESETKT in " + sem5.numberOfBacks()
                            + " subjects" + RESET);
                }
                if (sem5.status().equals("Pass")) {
                    System.out.println(GREEN + "Congratulations! You are promoted to next semester :" + RESET);
                }
            }
            repeat = true;
            sem5.showHeader();
            sem5.showMiddle();
            sem5.showTotal();
            sem5.showFooter();
            if (sem1.status().equals("ATKT")) {
                ind = sem1.numberOfBacks();
                backsub = sem1.backSubjects();
                for (int i = 0; i < ind; i++) {
                    System.out.print("Enter SEM-1 " + backsub[i] + " marks : ");
                    marks[i] = sc.nextInt();
                }
                sem1.setMarks(marks);
                System.out.println(
                        "===========================================================================================================");
                System.out.println();
                sem1.showHeader();
                sem1.showMiddle();
                sem1.showTotal();
                sem1.showFooter();
            }
            if (sem2.status().equals("ATKT")) {
                ind = sem2.numberOfBacks();
                backsub = sem2.backSubjects();
                for (int i = 0; i < ind; i++) {
                    System.out.print("Enter SEM-2 " + backsub[i] + " marks : ");
                    marks[i] = sc.nextInt();
                }
                sem2.setMarks(marks);
                System.out.println(
                        "===========================================================================================================");
                System.out.println();
                sem2.showHeader();
                sem2.showMiddle();
                sem2.showTotal();
                sem2.showFooter();
            }
            if (sem3.status().equals("ATKT")) {
                ind = sem3.numberOfBacks();
                backsub = sem3.backSubjects();
                for (int i = 0; i < ind; i++) {
                    System.out.print("Enter SEM-3 " + backsub[i] + " marks : ");
                    marks[i] = sc.nextInt();
                }
                sem3.setMarks(marks);
                System.out.println(
                        "===========================================================================================================");
                System.out.println();
                sem3.showHeader();
                sem3.showMiddle();
                sem3.showTotal();
                sem3.showFooter();
            }
            if (sem4.status().equals("ATKT")) {
                ind = sem4.numberOfBacks();
                backsub = sem4.backSubjects();
                for (int i = 0; i < ind; i++) {
                    System.out.print("Enter SEM-4" + backsub[i] + " marks : ");
                    marks[i] = sc.nextInt();
                }
                sem1.setMarks(marks);
                System.out.println(
                        "===========================================================================================================");
                System.out.println();
                sem4.showHeader();
                sem4.showMiddle();
                sem4.showTotal();
                sem4.showFooter();
            }
    
            while (repeat) {
                System.out.println(GREEN+"Enter marks for 6th semester : "+RESET);
                String s6[] = { "PR.Intr&Web TE. ", "Operation Research", "Project", "Internet & Web TE",
                        "Computer Graphics",
                        "Principal & Prac." };
                String sp6[] = { "Operation Research", "Principal & Prac." };
                String si6[] = { "PR.Intr&Web TE.", "Project", "Internet & Web TE", "Computer Graphics" };
                System.out.println(YELLOW+"Enter marks of theory exams : "+RESET);
                for (int i = 0; i < 6; i++) {
                    System.out.println(s6[i] + " : ");
                    t[i] = sc.nextInt();
                    if ((s6[i].equals(sp6[0]) || s6[i].equals(sp6[1])) && (t[i] < 0 || t[i] > 50)) {
                        System.out.println(RED+"Invalid Input : "+RESET);
                        i--;
                    } else if ((!s6[i].equals(sp6[0]) && (!s6[i].equals(sp6[1]))) && (t[i] < 0 || t[i] > 40)) {
                        System.out.println(RED+"Invalid Input : "+RESET);
                        i--;
                    }
                }
                System.out.println(YELLOW+"Enter marks of practical exam out of 25 : "+RESET);
                for (int i = 0; i < 2; i++) {
                    System.out.println(sp6[i] + " : ");
                    p[i] = sc.nextInt();
                    if ((p[i] < 0) || (p[i] > 25)) {
                        System.out.println(RED+"Invalid Input : "+RESET);
                        i--;
                    }
                }
                System.out.println(YELLOW+"Enter marks of Internal exam out of 10 :  "+RESET);
                for (int i = 0; i < 4; i++) {
                    System.out.println(si6[i] + " : ");
                    ti[i] = sc.nextInt();
                    if ((ti[i] < 0) || (ti[i] > 10)) {
                        System.out.println(RED+"Invalid Input : "+RESET);
                        i--;
                    }
                }
                sem6 = new Marksheetproject(t, p, ti, s6, sp6, si6, "SEM-6");
                repeat = sem6.status().equals("Fail");
                if (sem6.status().equals("Fail")) {
                    System.out.println(RED + "You have not cleared the Examination :" + RESET);
                }
               if (sem6.status().equals("ATKT")) {
                    System.out.println(YELLOW + "You got ATKT in " + sem6.numberOfBacks() + " subjects" + RESET);
                }
                if (sem6.status().equals("Pass")) {
                    System.out.println(GREEN + "Congratulations! You have completed your graduation :" + RESET);
                }
            }
            repeat = true;
            int total[] = { sem1.getTotal(), sem2.getTotal(), sem3.getTotal(), sem4.getTotal(), sem5.getTotal(),
                    sem6.getTotal() };
            sem6.showHeader();
            sem6.showMiddle();
            sem6.show2(total);
            sem6.showFooter();
            if (sem1.status().equals("ATKT")) {
                ind = sem1.numberOfBacks();
                backsub = sem1.backSubjects();
                for (int i = 0; i < ind; i++) {
                    System.out.print("Enter SEM-1 " + backsub[i] + " marks : ");
                    marks[i] = sc.nextInt();
                }
                sem1.setMarks(marks);
                System.out.println(
                        "===========================================================================================================");
                System.out.println();
                sem1.showHeader();
                sem1.showMiddle();
                sem1.showTotal();
                sem1.showFooter();
            }
            if (sem2.status().equals("ATKT")) {
                ind = sem2.numberOfBacks();
                backsub = sem2.backSubjects();
                for (int i = 0; i < ind; i++) {
                    System.out.print("Enter SEM-2 " + backsub[i] + " marks : ");
                    marks[i] = sc.nextInt();
                }
                sem2.setMarks(marks);
                System.out.println(
                        "===========================================================================================================");
                System.out.println();
                sem2.showHeader();
                sem2.showMiddle();
                sem2.showTotal();
                sem2.showFooter();
            }
            if (sem3.status().equals("ATKT")) {
                ind = sem3.numberOfBacks();
                backsub = sem3.backSubjects();
                for (int i = 0; i < ind; i++) {
                    System.out.print("Enter SEM-3 " + backsub[i] + " marks : ");
                    marks[i] = sc.nextInt();
                }
                sem3.setMarks(marks);
                // System.out.println(
                //         "===========================================================================================================");
                System.out.println();
                sem3.showHeader();
                sem3.showMiddle();
                sem3.showTotal();
                sem3.showFooter();
            }
            if (sem4.status().equals("ATKT")) {
                ind = sem4.numberOfBacks();
                backsub = sem4.backSubjects();
                for (int i = 0; i < ind; i++) {
                    System.out.print("Enter SEM-4 " + backsub[i] + " marks : ");
                    marks[i] = sc.nextInt();
                }
                sem4.setMarks(marks);
                System.out.println(
                        "===========================================================================================================");
                System.out.println();
                sem4.showHeader();
                sem4.showMiddle();
                sem4.showTotal();
                sem4.showFooter();
            }
            if (sem5.status().equals("ATKT")) {
                ind = sem5.numberOfBacks();
                backsub = sem5.backSubjects();
                for (int i = 0; i < ind; i++) {
                    System.out.print("Enter SEM-5 " + backsub[i] + " marks : ");
                    marks[i] = sc.nextInt();
                }
                sem5.setMarks(marks);
                System.out.println(
                        "===========================================================================================================");
                System.out.println();
                sem5.showHeader();
                sem5.showMiddle();
                sem5.showTotal();
                sem5.showFooter();
            }
            System.out.println(
                    "===========================================================================================================");
            System.out.println();
    
            Marksheetproject obj = new Marksheetproject();
            obj.showMigration();
            System.out.println(
                    "===========================================================================================================");
            System.out.println();
            obj.showTC();
            System.out.println(
                    "===========================================================================================================");
            System.out.println();
            obj.showDegree();
    
        }
    }  
