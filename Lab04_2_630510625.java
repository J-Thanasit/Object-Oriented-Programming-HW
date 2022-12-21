//630510625_ธนศิษฐ์
import java.util.Scanner;

//สร้าง class Message
class Message{
    private String code;

    //สร้าง method สำหรับการรับค่าตัวอักษร
    public void setData(){
        Scanner input = new Scanner(System.in);
        System.out.print("Input text : ");
        code = input.nextLine();
    }

    //สร้าง method สำหรับแปลงอักษรเป็นรหัสลับ
    public void charConvert(){
        int codelength = code.length();
        String code_;
        String newcode="";
        //เช็คค่า ascii ของอักษรที่ตำแหน่ง i บวกค่าไป 3 แล้วแปลงกลับเป็นตัวอักษรตัวใหม่
        for(int i=0; i<codelength; i++){
            int char_a = code.charAt(i);
            code_ = String.valueOf((char)(char_a+3));
            newcode += code_;
            //เพิ่มช่องว่างทุก 3 ตัวอักษร
            if(i%3 == 2){
                newcode += " ";
            }
        }
        //ใส่ # เติมไปจนตัวอักษรครบ 3 ตัว หากตัวอักษรในชุดนั้นมีไม่ครบ
        for(int j=0; j<2; j++){
            if(codelength%3 < 3 && codelength%3 != 0 && codelength%3 != 2){
            newcode += "#";
            }
        }
        if(codelength%3 == 2){
            newcode += "#";
        }
        //แปลงตัวอักษรทั้งหมดเป็นพิมพ์ใหม่
        code = newcode.toUpperCase();
    }

    //สร้าง method สำหรับการแสดงผลลัพธ์
    public void printResult(){
        System.out.printf("%s",code);
    }
}

//สร้าง class main สำหรับเรียกใช้ method ใน class Message
public class Lab04_2_630510625{
    public static void main(String[] args){
        Message m = new Message();
        m.setData();
        m.charConvert();
        m.printResult();
    }
}