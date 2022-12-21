//630510625_ธนศิษฐ์
import java.util.Scanner;
//สร้าง class สำหรับ main 
public class Lab02_1_630510625{
    public static void main(String[] args) {
        Scanner inVar = new Scanner(System.in);
        char ch;
        int num;
        //รับค่าตัวแปร ch ที่เป็นตัวอักษร 
        System.out.print("Enter Alphabet: ");
        ch = inVar.nextLine().charAt(0);
        //รับค่าตัวแปร num ที่เป็นตัวเลขจำนวนเต็มไม่มีทศนิยม
        System.out.print("Enter Number: ");
        num = inVar.nextInt();
        //หากค่าที่รับมามีค่าน้อยกว่า 2 หรือมากกว่า 10 ให้ทำการรับค่าใหม่
        while(num < 2 || num > 10){
            System.out.print("Enter Number: ");
            num = inVar.nextInt();
        //เรียกใช้ method A หากรับค่า ch เป็น A หรือ a    
        }if(ch == 'A' || ch == 'a'){
            printStartA(num);
        //เรียกใช้ method B หากรับค่า ch เป็น A หรือ a   
        }else if(ch == 'B' || ch == 'b'){
            printStartB(num);
        //แสดงข้อความ Good Bye หากค่า ch ที่รับมาไม่ใช่ A,a หรือ B,b
        }else{
            System.out.println("Good Bye");
        }
    }

    //สร้าง method สำหรับการสร้างดาวเมื่อรับค่า ch เป็นอักษร A หรือ a
    public static void printStartA(int n) {
        int row,col;
        for(row = n; row >= 1 ; row--){
            for(col = 1; col <= row; col++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }

    //สร้าง method สำหรับการสร้างดาวเมื่อรับค่า ch เป็นอักษร B หรือ b
    public static void printStartB(int n) {
        int row,col,space;
        for(row = 1; row <= n; row++ ){
            for(space = 1; space <= n-row; space++){
                System.out.print(" ");
            }
             for(col = (n-row); col < n; col++){
                 System.out.print("*");
             }
             System.out.print("\n");
        }
    }
}
