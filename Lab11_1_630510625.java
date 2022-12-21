//630510625 ธนศิษฐ์
import java.util.Scanner;

//สร้าง class Lab11_1_630510625 
public class Lab11_1_630510625{
    public static final int N = 3;

    //สร้าง medthod template getCenter
    public static <TYPE extends Comparable> TYPE getCenter(TYPE data[]){
        TYPE temp;
        int i,j;

        //ใช้การเรียงแบบ bubble sort
        for(i = 0; i < N ; i++){
            for(j = i+1; j < N ; j++){
                if(data[i].compareTo(data[j]) > 0){
                    temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
        }
        //ทำการส่งกลับค่าในตำแหน่งกลาง
        return data[1];
    }
    //สร้าง method main
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = 3;
        //สร้าง arrays สำหรับเก็บข้อมูลที่ป้อนเข้ามาตาม type ของข้อมูล
        Character [] cData = new Character[N];
        Integer [] iData = new Integer[N];
        Float [] fData = new Float[N];

        //รับค่าข้อมูลจำนวนเต็มแล้วเก็บไว้ใน array iData
        System.out.print("Enter 3 integer numbers\n");
        for(int i=0;i<N;i++){
            iData[i] = input.nextInt();
        }

        //รับค่าข้อมูลตัวอักษรแล้วเก็บไว้ใน array cData
        System.out.print("Enter 3 characters\n");
        for(int i=0;i<N;i++){
            cData[i] = input.next().charAt(0);
        }

        //รับค่าข้อมูลจำนวนทศนิยมแล้วเก็บไว้ใน array fData
        System.out.print("Enter 3 float numbers\n");
        for(int i=0;i<N;i++){
            fData[i] = input.nextFloat();
        }

        //ทำการแสดงผลค่าที่ได้รับมาจาก method getCenter
        System.out.println();
        System.out.println(getCenter(iData));
        System.out.println(getCenter(cData));
        System.out.println(getCenter(fData));
    }
}