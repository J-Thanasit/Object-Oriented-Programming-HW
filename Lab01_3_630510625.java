//630510625_ธนศิษฐ์
import java.util.Scanner;
public class Lab01_3_630510625{
    public static void main(String[] args){
        int Kombucha,rem,newbot,exch;
        Scanner sn = new Scanner(System.in);
        System.out.print("Enter N: ");
        //รับค่าจำนวนขวดทั้งหมดที่ดื่มไปตอนแรก
        Kombucha = sn.nextInt();
        //จำนวนขวดที่นำไปแลก
        newbot = Kombucha/5;
        //จำนวนขวดที่เหลือเศษ
        rem = Kombucha%5;
        //สมการคำนวณว่าขวดพอแลกต่อได้มั้ย
        exch = ((Kombucha/5)*2)+(Kombucha%5);

        while(exch >=5){
            //เพิ่มจำนวนขวดที่แลกเข้าไปยังตัวแปรเก็บค่าขวดที่มีดื่มไปตอนแรก
            Kombucha += newbot*2;
            //คำนวณหาขวดที่แลกได้
            newbot = exch/5;
            //คำนวณหาขวดที่เหลือเศษ
            rem = exch%5;
            //คำนวณหาว่าขวดที่เหลือยังพอแลกได้อีกมั้ย
            exch = (newbot*2)+rem; 
        }
        //นำขวดที่ได้เพิ่มมาจากการนำขวดที่เหลือเศษแล้วพอไปแลกเพิ่มไปรวมกับจำนวนขวดตอนแรก
        Kombucha += newbot*2;
        //แสดงผลจำนวนขวดที่ดื่มไปทั้งหมดและขวดที่เหลือเศษ
        System.out.printf("Total number of drinking bottles = %d",Kombucha);
        System.out.printf(" The remaining empty bottles = %d",exch);
    }
    
}
