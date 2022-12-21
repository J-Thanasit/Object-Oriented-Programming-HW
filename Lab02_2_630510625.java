//630510625_ธนศิษฐ์
import java.util.Scanner;
import java.util.Arrays;
//สร้าง class ของ main
public class Lab02_2_630510625{
    public static void main(String[] args){
        //กำหนดและรับค่าตัวแปรต่างๆ
        int n,dot1,dot2,i,j;
        Scanner inVar = new Scanner(System.in);
        System.out.print("Enter N: ");
        n = inVar.nextInt();
        //สร้าง array สำหรับเก็บค่าที่ return มา
        int [] x = new int[n+6];
        int [] y = new int[n+6];

        //สร้างฟังก์ชั่นสำหรับการเรียกใช้ค่าที่ return มา
        for(i = 1; i <= n; i++){
            System.out.printf("Enter point #%d:"+" ",i);
            dot1 = inVar.nextInt();
            dot2 = inVar.nextInt();
            x = checkQD(dot1,dot2,n);
            for(j = 0; j < n+6; j++){
                if(x[j] == 1){
                    y[j] += 1;
                }
            }
        }
        //แสดงผลลัพธ์
        System.out.printf("Number of points in Quadrant 1 = %d\n",y[1]);
        System.out.printf("Number of points in Quadrant 2 = %d\n",y[2]);
        System.out.printf("Number of points in Quadrant 3 = %d\n",y[3]);
        System.out.printf("Number of points in Quadrant 4 = %d\n",y[4]);
        System.out.printf("Number of points on X axis = %d\n",y[5]);
        System.out.printf("Number of points on Y axis = %d\n",y[6]);
        System.out.printf("Number of points on origin point = %d\n",y[0]);
    }

    //สร้าง method สำหรับการเช็คว่าจุดอยู่ใน quadrant ไหน
    public static int[] checkQD(int dot1,int dot2,int n){
        int [] count = new int[n+6];
        if(dot1 > 0 && dot2 > 0){
            count[1] += 1;
        }else if(dot1 < 0 && dot2 > 0){
            count[2] += 1;
        }else if(dot1 < 0 && dot2 < 0){
            count[3] += 1;
        }else if(dot1 > 0 && dot2 < 0){
            count[4] += 1;
        }else if((dot1 == 0 && dot2 > 0) || dot1 == 0 && dot2 < 0){
            count[5] += 1;
        }else if((dot1 > 0 && dot2 == 0) || (dot1 < 0 && dot2 == 0)){
            count[6] += 1;
        }else{
            count[0] += 1;
        }return count;
    }
}


