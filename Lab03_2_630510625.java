//630510625_ธนศิษฐ์
import java.util.Scanner;
//สร้าง class Parking
class Parking{
    private char type;
    private int minute;
    private double cost;

    //สร้าง method สำหรับเก็บค่าตัวแปรต่างๆ
    public void setData(){
        Scanner inVar = new Scanner(System.in);
        do{
        System.out.print("Enter data for vehicle parking #1"+"\n");
        System.out.print("Enter vehicle type: ");
        type = inVar.nextLine().charAt(0);
        }while(type != 'c' && type != 'm');
        System.out.print("Enter minute: ");
        minute = inVar.nextInt();
    }

    //สร้าง method สำหรับเก็บค่าตัวแปรในรอบที่ 2
    public void setData2(){
        Scanner inVar = new Scanner(System.in);
        do{
        System.out.print("Enter data for vehicle parking #2"+"\n");
        System.out.print("Enter vehicle type: ");
        type = inVar.nextLine().charAt(0);
        }while(type != 'c' && type != 'm');
        System.out.print("Enter minute: ");
        minute = inVar.nextInt();
    }

    //สร้าง method สำหรับคำนวณหาค่าจอดรถ
    public void calCost(){
        if (type == 'c'){
            if (minute <= 60){
                cost = minute*1;
            }else if (60 < minute && minute <= 120){
                cost = 60+((minute-60)*0.75);
            }else if (120 < minute && minute <= 240){
                cost = 105+((minute-120)*0.5);
            }else{
                cost = 165+((minute-240)*0.25);
            }
        }else{
            if(minute%60 > 0){
                cost = ((minute/60)+1)*5;
            }else{
                cost = (minute/60)*5;
            }
        }
    }

    //สร้าง method สำหรับการแสดงผลลัพธ์
    public void printResult(){
        System.out.printf("Cost = %.2f baht(s)",cost);
    }
}

//สร้าง class ของ main
public class Lab03_2_630510625{
    public static void main(String[] args){
        //สร้างตัวแปร p แทน class Parking
        Parking p = new Parking();
        //เรียกใช้ method ต่างๆ จากตัวแปร p
        p.setData();
        p.calCost();
        p.printResult();
        //สร้างบรรทัดใหม่
        System.out.print("\n"+"\n"+"\n");
        //เรียกใช้ method ต่างๆ จากตัวแปร p ครั้งที่ 2
        p.setData2();
        p.calCost();
        p.printResult();
    } 
}
