//630510625_ธนศิษฐ์
import java.util.Scanner;
//สร้าง class Human
class Human{
    private char gender;
    private float weight;
    private float height;
    private String shape;

    //สร้าง method สำหรับการเก็บค่าตัวแปรต่างๆ
    public void setData(){
        Scanner inVar = new Scanner(System.in);
        do{
        System.out.print("Enter gender: ");
        gender = inVar.nextLine().charAt(0);
        }while(gender != 'm' && gender != 'f');
        System.out.print("Enter weight: ");
        weight = inVar.nextFloat();
        System.out.print("Enter height: ");
        height = inVar.nextFloat();
    }

    //สร้าง method สำหรับการคำนวณค่า
    public void calShape(){
        if (gender == 'm'){
            if (weight <= (height-100)){
                shape = "Your shape is OK";
            }else {
                shape = "Your shape is not OK";
            }
        }else{
            if(weight <= (height-110)){
                shape = "Your shape is OK";
            }else {
                shape = "Your shape is not OK";
            }
        }
    }

    //สร้าง method สำหรับการแสดงผลลัพธ์
    public void printResult(){
        System.out.print(shape);
    }
}

//สร้าง class ของ main
public class Lab03_1_630510625{
    public static void main(String[] args) {
        //สร้างตัวแปร h แทน class Human
        Human h = new Human();
        //เรียกใช้ method จากในคลาส Human ผ่านตัวแปร h
        h.setData();
        h.calShape();
        h.printResult();
    } 
}
