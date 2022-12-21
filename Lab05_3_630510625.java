//630510625_ธนศิษฐ์
import java.util.Scanner;

//สร้าง class Menu
class Menu{
    int choice;
    //print ส่วนต่างๆ ของ Menu
    public void setChoice(){
        System.out.println("**********");
        System.out.println("1.push");
        System.out.println("2.pop");
        System.out.println("3.show");
        System.out.println("4.exit");
        System.out.println("**********");
        System.out.print("Please select choice: ");
        System.out.print("\n\n\n");
    }

    //สร้าง method getChoice สำหรับรับค่าตัวเลือกและส่งกลับ
    public int getChoice(){
        Scanner input = new Scanner(System.in);
        choice = input.nextInt();
        return choice;
    }
}

//สร้าง class Stack
class Stack{
    private int ar[];
    private int cap;
    private int top;
    private int num;
    //สร้าง method Stack สำหรับเป็น constructor method
    public Stack(){
        ar = new int[5];
        cap = 5;
        top = -1;
    }

    //สร้าง method push
    public void push(){
        //ตรวจสอบว่า stack เต็มมั้ย
        if(isFull()){
            System.out.println("stack is full");
        //ถ้าไม่เต็มให้รับค่าตัวเลขสำหรับใส่ลงใน stack ในตำแหน่ง top+1
        }else{
            System.out.print("Enter num: ");
            Scanner input = new Scanner(System.in);
            num = input.nextInt();
            ar[top+1] = num;
            top+=1;
        }
        System.out.print("\n\n\n");
    }
    
    //สร้าง method pop
    public int pop(){
        //ตรวจสอบว่ามีข้อมูลใน stack มั้ย
        if(isEmpty()){
            System.out.println("stack is empty");
        //ถ้ามีให้ทำการดึงข้อมูลออกจาก stack ในตำแหน่ง top และแสดงข้อมูลนั้น
        }else{
            System.out.println("pop "+peek());
            System.out.print("\n\n\n");
            return ar[top--];
        }
        return 0;
    }

    //สร้าง method show
    public void show(){
        //ถ้า top=-1 (ค่าเริ่มต้น) ให้แสดงผลว่า stack ว่าง
        if(top==-1){
            System.out.print("stack is empty");
            System.out.print("\n\n");
        //ถ้า stack ไม่ว่างเปล่าให้แสดงข้อมูลทั้งหมดใน stack
        }else{
            for(int i=0;i<=top;i++){
                System.out.print(ar[i] + " ");
            }
        }
        System.out.print("\n\n\n");
    }

    //สร้าง method peek
    public int peek(){
        //ถ้า stack ไม่ว่างให้ส่งกลับข้อมูลในตำแหน่ง top
        if(!isEmpty()){
            return ar[top];
        //ถ้า stack ว่างเปล่าไม่ต้องทำอะไร
        }else{
            ;
        }
        return -1;
    }

    //สร้าง method แบบบูลีน isEmpty ไว้ตรวจสอบว่า stack ว่างเปล่ามั้ย
    public Boolean isEmpty(){
        top = -1;
        return top;
    }

    //สร้าง method แบบบูลีน isFullไว้ตรวจสอบว่า stack เต็มมั้ย
    public Boolean isFull() {
        top = cap-1;
        return top ;
    }
}

//สร้าง method main ภายใน class Lab05_3_630510625
public class Lab05_3_630510625 {
    public static void main(String[] args) {
        int x;
        Menu m = new Menu();
        Stack s = new Stack();
        //เมื่อเป็นจริง
        while(true){
            //เรียกใช้ method setChoice เพื่อปริิ้นช้อยที่มีให้เลือก 
            m.setChoice();
            //เรียกใช้ getChoice เพื่อให้ผู้ใช้ป้อนช้อยที่ต้องการแล้วแทนด้วย x
            x = m.getChoice();
            //หากเลือกช้อย 1
            if(x==1){
                //ทำการเรียกใช้ method push
                s.push();
            //หากเลือกช้อย 2
            }else if(x==2){
                //ทำการเรียกใช้ method pop
                s.pop();
            //หากเลือกช้อย 3
            }else if(x==3){
                //ทำการเรียกใช้ method show
                s.show();
            //หากเลือกช้อยอื่นๆ (รวมถึงช้อย 4) ให้ทำการจบโปรแกรม
            }else{
                break;
            }
        }
        //หลังจากผู้ใช้เลือกช้อย 4 ให้ทำการแสดงผล Bye bye
        System.out.print("Bye bye");
    }
}
