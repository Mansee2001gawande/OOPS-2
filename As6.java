/*create one anather class two bhk which has all properties and behavoiur of one bhk and new instance
 variable roomArea2 method show to all data member information 
 write a main function in anather class (say XYZ) and store three twobhk flats information.and print
informatrion using show method also print total amount of all flats.*/
 public class As6 extends As5 {
        private int roomArea2;
    
        As6(){
    
         }
         As6(int roomArea,int hallArea,int price,int roomArea2){
                super(roomArea,hallArea,price);
                this.roomArea2=roomArea2;
        }
        public void show(){
            System.out.println(roomArea2);
        }
        public void method(){
            
        }

        
    }
    class Main extends As6 {
        public static void main(String[] args) {
                       // super(roomArea,hallArea,price,roomArea2);

            //public void m3()
            //As6 obj=new As6();
           //o obj.show();
            As6 onebhk=new As6(10,25,400000,30);
            As6 twobhk=new As6(20,35,600000,40);
            As6 threebhk=new As6(50,45,800000,70);

            onebhk.show();
            twobhk.show();
            threebhk.show();
         }
    }
    
    
    
    

