//630510625_ธนศิษฐ์
import java.util.Scanner;
//สร้าง class สำหรับ main
public class Lab02_3_630510625{
    public static void main(String[] args){
        //สร้างและรับค่าตัวแปรต่างๆ
        int num;
        //สร้างตัวแปรสำหรับเรียกใช้ method ที่เป็น boolean
        boolean oe,pr;
        Scanner inVar = new Scanner(System.in);
        System.out.print("Enter Number: ");
        num = inVar.nextInt();
        inVar.close();
        oe = checkOddEven(num);
        pr = checkPrime(num);
        //เช็คตัวเลขว่าเป็น odd หรือ even และเป็น prime มั้ยพร้อมแสดงผลลัพธ์ 
        if(oe == true && pr == true){
            System.out.printf("%d is even number."+"\n",num);
            System.out.printf("%d is prime number.",num);
        }else if(oe == true && pr == false){
            System.out.printf("%d is even number."+"\n",num);
            System.out.printf("%d is not prime number.",num);
        }else if(oe == false && pr == true){
            System.out.printf("%d is not even number."+"\n",num);
            System.out.printf("%d is prime number.",num);
        }else if(oe == false && pr == false){
            System.out.printf("%d is not even number."+"\n",num);
            System.out.printf("%d is not prime number.",num);
        }
    }

    //สร้าง method สำหรับเช็คว่าตัวเลขเป็น odd หรือ even และคืนค่าเป็น boolean
    public static boolean checkOddEven(int num){
        if(num%2 == 0){
            return true;
        }else{
            return false;
        }
    }

    //สร้าง method สำหรับเช็คว่าตัวเลขเป็น prime หรือไม่ และคืนค่าเป็น boolean
    public static boolean checkPrime(int num){  
        if(num <= 1) {  
            return false;  
        }for(int i = 2; i < Math.sqrt(num); i++){  
            if(num % i == 0){  
            return false;
        }   
    }
    return true;
    }
}