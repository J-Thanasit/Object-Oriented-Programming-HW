//630510625_ธนศิษฐ์
import java.util.Scanner;

//สร้าง class Drawing
class Drawing{
    //สร้าง method drawTriangle สำหรับแสดง *
    void drawTriangle(int N){
        for(int row=1;row<=N;row++){
            for(int col=1;col<=row;col++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    //สร้าง method drawTriangle สำหรับแสดงอักษรหรือสัญลักษณ์ที่รับค่า
    void drawTriangle(int N,char X){
        for(int row=N;row>=1;row--){
            for(int col=1;col<=row;col++){
                System.out.print(X);
            }
            System.out.println();
        }
    }
}

public class Lab06_1_630510625{  
    public static void main(String args[]){
        Drawing d = new Drawing();
        int N;
        char X;
        Scanner input = new Scanner(System.in);
        System.out.print("Input N: ");
        //รับค่าจำนวนแถว
        N=input.nextInt();
        System.out.print("Input X: ");
        //รับค่าตัวอักษรหรือสัญลักษณ์
        X=input.nextLine().charAt(0);
        //ทำงานตาม method drawTriangle ตามพารามิเตอร์ที่กำหนด
        d.drawTriangle(N);
        d.drawTriangle(N,X);
    }
}