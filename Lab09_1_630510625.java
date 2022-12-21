//630510625_ธนศิษฐ์
import java.util.Scanner;

//สร้าง class OrderItem
class OrderItem{
    private String foodName;
    private int price;
    private int numDish;
    Scanner input = new Scanner(System.in);

    public void setData(){
        //รับค่าชื่ออาหาร
        System.out.print("Enter food name: ");
        foodName = input.nextLine();
        //รับค่าราคาอาหาร
        System.out.print("Enter price: ");
        price = input.nextInt();
        //รับค่าจำนวนของอาหาร
        System.out.print("Enter number of dishes: ");
        numDish = input.nextInt();
        System.out.print("*************************************************************");
    }

    //ส่งกลับค่าชื่ออาหาร
    public String getFoodName(){
        return foodName;
    }

    //ส่งกลับค่าราคาอาหาร
    public int getPrice(){
        return price;
    }

    //ส่งกลับค่าจำนวนอาหาร
    public int getNumDish(){
        return numDish;
    }
}

//สร้าง class Order ที่สืบทอดมาจาก class OrderItem
class Order extends OrderItem{
    private String orderId;
    private String tableNo;
    private int numberOfItem=0;
    private double totalPrice=0;
    private OrderItem [] item = new OrderItem[10];
    Scanner input = new Scanner(System.in);

    public void setData(){
        //รับค่าหมายเลขออเดอร์
        System.out.print("Enter order ID: ");
        orderId = input.next();
        //รับค่าหมายเลขโต๊ะอาหาร
        System.out.print("Enter Table No.: ");
        tableNo = input.next();
        //รับค่าจำนวนของชนิดอาหารที่สั่ง
        System.out.print("Enter number of food items: ");
        numberOfItem = input.nextInt();
        System.out.print("*************************************************************\n");
    }

    //ทำการเรียกใช้ method setData จาก class OrderItem เพื่อสร้าง arrays ที่เก็บชื่ออาหาร ราคา และจำนวน
    public void addItem(){
        for(int i=0;i<numberOfItem;i++){
            item[i] = new OrderItem();
            item[i].setData();
            System.out.println();
        }
    }

    //สร้าง method เพื่อทำการแสดงผลลัพธ์การทำงานของโปรแกรม
    public void showData(){
        //ทำการแสดงผลหมายเลขออเดอร์ หมายเลขโต๊ะ
        System.out.printf("Order ID - %s\tTable No. - %s\n",orderId,tableNo);
        //ทำการแสดงผลชื่ออาหาร ราคา จำนวนอาหาร
        System.out.print("Food Name\tPrice/Dish(Baht)\tQTY\n");
        //ทำการวนลูปเพื่อแสดงผลชื่อของอาหารแต่ละอย่าง ราคา และจำนวน
        for(int i=0;i<numberOfItem;i++){
            System.out.printf(item[i].getFoodName()+"\t\t"+item[i].getPrice()+"\t\t"+item[i].getNumDish());
            System.out.println();
        }
        //ทำการวนลูปเพื่อเพิ่มค่าราคาอาหารแต่ละอย่างเข้าไปในตัวแปร totalPrice
        for(int j=0;j<numberOfItem;j++){
            totalPrice += (item[j].getPrice())*(item[j].getNumDish());
        }
        //ทำการแสดงผลราคารวมจากตัวแปร totalPrice
        System.out.printf("Total Price = %.0f Bath",totalPrice);
    }
}

//สร้าง method main ใน class Lab09_1_630510625
public class Lab09_1_630510625{
    public static void main(String[] args){
        //ทำการสร้าง obj D สำหรับเรียกใช้ method ต่างๆ จาก class Order
        Order D = new Order();
        D.setData();
        D.addItem();
        D.showData();
    }
}

