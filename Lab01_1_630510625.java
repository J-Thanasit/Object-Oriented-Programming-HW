//630510625_ธนศิษฐ์
import java.util.Scanner;
public class Lab01_1_630510625
{
    public static void main(String[] args){
        //กำหนดตัวแปรและรับค่า A,B,C
        int A,B,C, series=0;
        Scanner sn = new Scanner(System.in);
        System.out.print("Enter A: ");
        A = sn.nextInt();
        System.out.print("Enter B: ");
        B = sn.nextInt();
        System.out.print("Enter C: ");
        C = sn.nextInt();
        
        //แสดงค่า A และ B เป็นลำดับที่ 1 และ 2 เสมอ
        System.out.printf("%d %d ",A,B);
        //กำหนดสมการสำหรับการคำนวณหาค่าในอนุกรม
        series = (A*A)+(B*B);
        //นำตัวแปรเข้าสมการเพื่อหาอนุกรมแล้วแสดงผล
        while(series <= C){
            System.out.printf("%d ",series);
            A = B;
            B = series;
            series = (A*A)+(B*B);
            }
        }       
    }