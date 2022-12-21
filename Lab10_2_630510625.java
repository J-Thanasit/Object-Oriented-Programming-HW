//630510625_ธนศิษฐ์
import java.util.Scanner;

//สร้าง class Shape2Dim เป็น main class
class Shape2Dim{
    protected int N;
    //กำหนดค่าให้ N
    public void setN(int n){
        N = n;
    }
}

//สร้าง sub class Rhombus สำหรับวาดรูปสี่เหลี่ยมขนมเปียกปูน
class Rhombus extends Shape2Dim{
    Rhombus(){N = 0;}
    void draw(){
        if(N > 0){
            int i;
            String fsq = "%" + N +"c\n";
            String fsq2;
            System.out.printf(fsq,'*');
            for(i=1;i<N;i++){
                fsq2 = "%" + (N-i) + "c%" + (2*i) + "c\n";
                System.out.printf(fsq2,'*','*');
            }for(i=N-2;i>=1;i--){
                fsq2 = "%" + (N-i) + "c%" + (2*i) + "c\n";
                System.out.printf(fsq2,'*','*');
            }
            System.out.printf(fsq,'*');
        }
    }
}

//สร้าง sub class Square สำหรับวาดรูปสี่เหลี่ยม
class Square extends Shape2Dim{
    Square(){N = 0;}
    void draw(){
        if(N > 0){
            int i,j;
		    for(i = 1; i <= N; i++){
			    if(i == 1 || i == N)
				    for(j = 1; j <= N; j++)
					    System.out.print("*");
			    else
				    for(j = 1; j <= N; j++)
					    if(j == 1 || j == N)
						    System.out.print("*");
					    else
						    System.out.print(" ");
			    System.out.print("\n");
            }
		}
	}
}

//สร้าง sub class Triangle สำหรับวาดรูปlามเหลี่ยม
class Triangle extends Shape2Dim{
    Triangle(){N = 0;}
    void draw(){
        if(N > 0){
            int i;
            String fsq = "%" + N + "c\n";
            String fsq2;
            System.out.printf(fsq,'*');
            for(i = 1; i < N-1 ; i++){
                fsq2 = "%" + (N-i)+"c%"+(2*i)+"c\n";
                System.out.printf(fsq2,'*','*');
            }
            for(i = 1; i <= N; i++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}

//สร้าง method main ภายใน class Lab10_2_630510625
public class Lab10_2_630510625{
    public static void main(String[] args){
        int M,size;
        char shape;
        //สร้าง obj แบบ array จาก class Shape2Dim 
        Shape2Dim[] sh = new Shape2Dim[100];
        Scanner input = new Scanner(System.in);
        //รับค่า M
        System.out.print("Input M: ");
        M = input.nextInt();
        //วนรูปเพื่อรับค่า R S และ T เพื่อเรียกใช้ setN ทำการเซ็ตค่าขนาดของรูปที่จะวาด
        for(int i=0;i<M;i++){
            System.out.print("Input Type (R S or T) and Size: ");
            shape = input.next().charAt(0);
            size = input.nextInt();
            if(shape == 'R'){
                sh[i] = new Rhombus();
                sh[i].setN(size);
            }else if(shape == 'S'){
                sh[i] = new Square();
                sh[i].setN(size);
            }else{
                sh[i] = new Triangle();
                sh[i].setN(size);
            }
        }
        
        //ทำการแสดงผลรูปสี่เหลี่ยมขนมเปียกปูนตามขนาดที่ได้จากลูปบนและจำนวนเท่ากับ M
        System.out.print("Rhombus\n");
        for(int i=0;i<M;i++){
            //ทำการเช็คว่า obj เป็น instance ของ class Rhombus หรือไม่พร้อมทำการสั่งวาดรูปด้วยการใช้ type casting
            if(sh[i] instanceof Rhombus){
                ((Rhombus)sh[i]).draw();
            }
        }
        System.out.println();
        
        //ทำการแสดงผลรูปสี่เหลี่ยมตามขนาดที่ได้จากลูปบนและจำนวนเท่ากับ M
        System.out.print("Sqaure\n");
        for(int i=0;i<M;i++){
            //ทำการเช็คว่า obj เป็น instance ของ class Square หรือไม่พร้อมทำการสั่งวาดรูปด้วยการใช้ type casting
            if(sh[i] instanceof Square){
                ((Square)sh[i]).draw();
            }
        }
        System.out.println();
        
        //ทำการแสดงผลรูปสามเหลี่ยมตามขนาดที่ได้จากลูปบนและจำนวนเท่ากับ M
        System.out.print("Triangle\n");
        for(int i=0;i<M;i++){
            //ทำการเช็คว่า obj เป็น instance ของ class Triangle หรือไม่พร้อมทำการสั่งวาดรูปด้วยการใช้ type casting
            if(sh[i] instanceof Triangle){
                ((Triangle)sh[i]).draw();
            }
        }
        System.out.println();
    }
}
