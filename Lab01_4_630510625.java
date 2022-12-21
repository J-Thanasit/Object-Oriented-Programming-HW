//630510625_ธนศิษฐ์
import java.util.Scanner;
import java.util.Arrays;
public class Lab01_4_630510625{
    public static void main(String[] args){
        //สร้างและกำหนดจำนวนช่องใน Array A,B,C
        int [] A = new int [5];
        int [] B = new int [5];
        int [] C = new int [10];
        Scanner sn = new Scanner(System.in);
        int i,number;
        for(i = 0; i <= 9;){
            //กำหนดให้จำนวนในตำแหน่งที่ 0-4 เป็น Array A
            if(i < 5){
                if(i == 0){
                    System.out.println("Enter Array A");
                }
                //รับค่าจำนวน
                number = sn.nextInt();
                A[i] = number;
                i += 1;
            }
            //กำหนดให้จำนวนในตำแหน่งที่ 5-9 เป็น Array B
            else{
                if(i == 5){              
                    System.out.println("Enter Array B");
                }
                //รับค่าจำนวน
                number = sn.nextInt();
                B[i-5] = number;
                i += 1;
            }
        }
        //รวมจำนวน Array A กับ B ใส่ใน Array C
        for(i = 0; i <= 4;){
            C[i] = A[i];
            C[i+5] = B[i];
            i +=1 ;
        }
        //เรียงลำดับข้อมูลใน Array C
        Arrays.sort(C);
        //แสดงผลจำนวนที่เรียงแล้วใน Array C โดยให้เว้นวรรคในแต่ละจำนวน
        for(i = 0; i <= 9;){
            System.out.printf(C[i] + " ");
            i += 1;
        }
        System.out.print("\n");
    }
}