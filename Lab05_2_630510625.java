//630510625_ธนศิษฐ์
import java.util.Scanner;

//สร้าง class Volume
class Volume{
    private String boxname;
    private float width;
    private float length;
    private float height;
    private float volume;
    
    //สร้าง method Volume สำหรับรับค่า parameter ของกล่องที่ 1
    public Volume(String b,float w,float l,float h){
        float area_=w*l*h;
        System.out.printf("The Volume of Box: %s = %.1f",b,area_);
    }

    //สร้าง method setData สำหรับรับค่าต่างๆ ของกล่องที่ 2
    public void setData(){
        Scanner input = new Scanner(System.in);
        System.out.print("Input Name of Box: ");
        boxname=input.nextLine();
        System.out.print("Input Width: ");
        width=input.nextFloat();
        System.out.print("Input Length: ");
        length=input.nextFloat();
        System.out.print("Input Height: ");
        height=input.nextFloat();
    }

    //สร้าง method calVolume สำหรับคำนวนปริมาตรของกล่องที่ 2
    public void calVolume(){
        volume=width*length*height;
    }

    //สร้าง method printResult สำหรับแสดงค่าปริมาตรของกล่องที่ 2
    public void printResult(){
        System.out.printf("The Volume of Box: %s = %.1f",boxname,volume);
    }

}

//สร้าง method main ใน class Lab05_2_630510625 สำหรับเรียกใช้ method จากใน class Volume
public class Lab05_2_630510625{  
    public static void main(String args[]){
        System.out.print("Hello from 1st construtor\n");
        //เรียกใช้ constructor ตัวแรกเพิ่มรับค่า parameter เพื่อคำนวนค่าและแสดงผลปริมาตรของกล่องที่ 1
        Volume vol = new Volume("SizeA",14,20,6);
        System.out.print("\n\n\n");
        System.out.print("Hello from 2nd construtor\n");
        //เรียกใช้ constructor ตัวที่สองสำหรับรับค่าจาก method ต่้างๆ ใน class Volume เพื่อทำการคำนวนและแสดงผมปริมาตรของกล่องที่ 2
        vol.setData();
        vol.calVolume();
        vol.printResult();
    }
}