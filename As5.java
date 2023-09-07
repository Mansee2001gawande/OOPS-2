/* 5.create class one bhk with instance variable roomArea,hallArea and price create default and parameterized
 constructor */

public class As5 {
    private int roomArea;
    private int hallArea;
    private int price;

    As5() {

    }

    As5(int roomArea, int hallArea, int price) {
        this.roomArea = roomArea;
        this.hallArea = hallArea;
        this.price = price;
    }

    public void method() {
        System.out.print(roomArea + " " + hallArea + " " + price);
    }
    //public int getprice(){
     //   return price;
   // }
}

/*
 * class Price extends As5{
 * public static void main(String[] args) {
 * As5 obj=new As5();
 * obj.method();
 * }
 * }
 */
/*
 * create one anather class two bhk which has all properties and behavoiur of
 * one bhk and new instance
 * variable roomArea2 method show to all data member information
 * write a main function in anather class (say XYZ) and store three twobhk flats
 * information.and print
 * informatrion using show method also print total amount of all flats.
 */
class Twobhk extends As5 {
    private int roomArea2;
   // static int total;

    Twobhk(int roomArea, int hallArea, int price, int roomArea2) {
        super(roomArea, hallArea, price);
        this.roomArea2 = roomArea2;
    }

    public void show() {
        super.method();
        System.out.print(" " + roomArea2);

    }
    

   // public void displayamount() {
        //System.out.println("Total Amount of all flat : " + total);
   // }
            
}
class Ma {
    public static void main(String[] args) {
        As5 obj = new As5();
        obj.method();

        Twobhk onebhk = new Twobhk(10, 25, 400000, 30);
        Twobhk twobhk = new Twobhk(20, 35, 600000, 40);
        Twobhk threebhk = new Twobhk(50, 45, 800000, 70);
        onebhk.show();
        twobhk.show();
        threebhk.show();

            public void totalprice(){
         total=0;
         total = onebhk.price+twobhk.price+threebhk.price;
         System.out.print(total);
    }
            Twobhk amount3 = new Twobhk();
            amount3.totalprice();

        }

    }

