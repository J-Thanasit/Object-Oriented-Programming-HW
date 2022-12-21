//630510625_ธนศิษฐ์
import java.util.Scanner;

//สร้าง generic class Queue
class Queue<TYPE>{
    private int N;
    private final Object[] item; 
    private int front;
    private int rear;
    private int count;
    
    //สร้าง method Queue สำหรับเก็บ instance
    Queue(int x){
        N = x;
        item = new Object[N];
        front = 0;
        rear = -1;
        count = 0;
    }
    
    //สร้าง method enqueue สำหรับเพิ่มสมาชิกในคิว
    public void enqueue(TYPE v){
        if(rear < N-1){
            rear++;
            item[rear] = v;
            count++;
            System.out.println("OK");
    
        }
    }

    //สร้าง method dequeue สำหรับลบสมาชิกออกจากคิว
    public void dequeue(){
        if(isEmpty() == false){
            System.out.println(item[front]);
            item[front] = null;
            front++;
            count--;
        }
        else{
            System.out.println("Queue is empty.");
        }
    }
    
    //สร้าง method isEmpty สำหรับตรวจสอบว่าคิวว่างอยู่หรือไม่
    public boolean isEmpty(){
        if(count == 0){
            return(true);
        }
        else{
            return(false);
        }
    }

    //สร้าง method isFull สำหรับตรวจสอบว่าคิวเต็มหรือยัง
    public boolean isFull(){
        if(rear == N-1){
            return(true);
        }
        else{
            return(false);
        }
    }
    
    //สร้าง method show สำหรับแสดงค่าของสมาชิก
    public void show(){
        if(isEmpty() == true){
            System.out.println("Nothing to show.");
        }
        else{
            for(int i=front;i<=rear;i++){
                System.out.print(item[i] + " ");
            }
            System.out.println();
        }
    }
}

//สร้าง method main ใน class Lab11_2_630510625
public class Lab11_2_630510625{
    public static void main(String[] args){
        int n, menuChoice;
        Scanner input = new Scanner(System.in);
        System.out.print("Input N : ");
        n = input.nextInt();
        //เลือกประเภทข้อมูล
        System.out.print("What type of data do you want?: ");
        char c = input.next().charAt(0);
        //หากพิมพ์ i แปลว่าข้อมูลเป็นจำนวนเต็ม
        if(c == 'i'){
            Queue<Integer> dataList = new Queue(n);
            int value;
            do{
                System.out.println();
                System.out.println("1) enqueue");
                System.out.println("2) dequeue");
                System.out.println("3) show");
                System.out.println("4) exit");
                System.out.print("Select choice : ");
                menuChoice = input.nextInt();
                //เลือกช้อยแรกทำการเรียกใช้ method enqueue
                if(menuChoice == 1){
                    if(dataList.isFull()){
                        System.out.println("Queue is full.");
                    }else{
                        System.out.print("Input data for enqueue : ");
                        value = input.nextInt();
                        dataList.enqueue(value);
                    }
                }
                //เลือกช้อยสองทำการเรียกใช้ method dequeue
                else if(menuChoice == 2){
                    dataList.dequeue();;
                }
                //เลือกช้อยสามทำการเรียกใช้ method show
                else if(menuChoice == 3){
                    dataList.show();
                }
                //หากเลือกช้อยอื่นให้แสดงข้อความ Bye
                else{
                    System.out.println("Bye.");
                }
                System.out.println("*******************************************************");            
            }
            while(menuChoice != 4);
        }
        //หากพิมพ์ c แปลว่าข้อมูลเป็นตัวอักษร
        else{
            Queue<Character> dataList = new Queue(n);
            char value;
            do{
                System.out.println();
                System.out.println("1) enqueue");
                System.out.println("2) dequeue");
                System.out.println("3) show");
                System.out.println("4) exit");
                System.out.print("Select choice : ");
                menuChoice = input.nextInt();
                //เลือกช้อยแรกทำการเรียกใช้ method enqueue
                if(menuChoice == 1){
                    if(dataList.isFull()){
                        System.out.println("Queue is full.");
                    }
                    else{
                        System.out.print("Input data for enqueue : ");
                        value = input.next().charAt(0);
                        dataList.enqueue(value);
                    }
                }
                //เลือกช้อยสองทำการเรียกใช้ method dequeue
                else if(menuChoice == 2){
                    dataList.dequeue();
                }
                //เลือกช้อยสามทำการเรียกใช้ method show
                else if(menuChoice == 3){
                    dataList.show();
                }
                //หากเลือกช้อยอื่นให้แสดงข้อความ Bye
                else{
                    System.out.println("Bye.");
                }
                System.out.println("*******************************************************");              
            }
            while(menuChoice != 4);
        }   
    }
    
}
