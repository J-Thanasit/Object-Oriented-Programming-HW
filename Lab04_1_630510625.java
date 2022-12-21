//630510625_ธนศิษฐ์
import java.util.Scanner;

//สร้าง class Matrix
class Matrix{
    private int size;
    private int [ ][ ] data = new int[50][50];
    boolean identityStatus;

    //สร้าง method รับค่าขนาดของ matrix
    public void setSize(){
        Scanner input = new Scanner(System.in);
        System.out.print("Input size: ");
        size = input.nextInt();
    }

    //สร้าง method สำหรับการสร้าง matrix
    public void setData(){
        int i,j;
        Scanner input = new Scanner(System.in);
        for(i=0;i<size;i++){
            for(j=0;j<size;j++){
                System.out.printf("Input number [%d][%d] : ",i,j);
                data[i][j] = input.nextInt();
            }
            System.out.println();
        }
    }

    //สร้าง method สำหรับการตรวจสอบว่าเป็น matrix ที่เหมือนกันหรือไม่
    public void checkIdentity(){
        int i,j;
        identityStatus=true;
        for(i=0;i<size && identityStatus;i++){
            for(j=0;j<size && identityStatus;j++){
                if((i==j)&&(data[i][j]!=1)){
                    identityStatus=false;
                }else if ((i!=j)&&(data[i][j]!=0)){
                    identityStatus=false;
                }
            }
        }

    }

    //สร้าง method สำหรับการแสดงผลลัพธ์
    public void showIdentity(){
        if(identityStatus){
            System.out.print("This matrix is identity matrix.");
        }else{
            System.out.print("This matrix is not identity matrix.");
        }
    }
}

//สร้าง class main สำหรับการเรียกใช้ method จาก class Matrix
public class Lab04_1_630510625{
    public static void main(String[] args){
        Matrix m = new Matrix();
        m.setSize();
        m.setData();
        m.checkIdentity();
        m.showIdentity();
    }
}