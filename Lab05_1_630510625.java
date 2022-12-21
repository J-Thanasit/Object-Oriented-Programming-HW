//630510625_ธนศิษฐ์
import java.util.Scanner;

//สร้าง class Subject
class Subject{
    //สร้างตัวแปร
    private char grade;
    private int credit;
    private int totalPoint;

    //สร้าง method setData สำหรับการรับค่าตัวแปรต่างๆ
    public void setData(int i){
        Scanner input=new Scanner(System.in);
        System.out.println("\nSubject #"+i);
        System.out.print("Input Grade: ");
        grade=input.nextLine().charAt(0);
        System.out.print("Input Credit: ");
        credit=input.nextInt();
    }

    //สร้าง method getGradePoint สำหรับการแปลงเกรดที่รับค่าเป็นคะแนน
    public int getGradePoint(){
        switch(grade){
            case 'A' : return (4);
            case 'B' : return (3);
            case 'C' : return (2);
            case 'D' : return (1);
            case 'a' : return (4);
            case 'b' : return (3);
            case 'c' : return (2);
            case 'd' : return (1);
            case 'F' : default : return (0);
        }
    }

    //สร้าง method calTotalPoint สำหรับการนำค่าคะแนนที่ได้จาก getGradePoint มาทำการหาคะแนนรวม
    public void calTotalPoint(){
        totalPoint=getGradePoint()*credit;
    }

    //สร้าง method getCredit สำหรับส่งคืนค่า credit ของแต่ละวิชา
    public int getCredit(){
        return credit;
    }

    //สร้าง method geTotalPoint สำหรับส่งคืนค่าคะแนนรวมของแต่ละวิชา
    public int getTotalPoint(){
        return totalPoint;
    }

    //สร้าง method printData สำหรับการแสดงผมลัพธ์ Grade, GradePoint, Credit และ TotalPoint ของแต่ละวิชา
    public void printData(int i){
        System.out.printf("Subject %d\t\t %c\t\t %d\t\t %d\t\t %d\n",i,grade,getGradePoint(),credit,totalPoint);
    }
}

//สร้าง method main ใน class Lab05_1_630510625 สำหรับเรียกใช้ method จากใน class Subject
public class Lab05_1_630510625{  
    public static void main(String args[]){
        //สร้างและกำหนดชนิดของตัวแปร
        int i,N;
        long sumCredit=0,sumTotalPoint=0;
        float gpa;

        //รับค่าจำนวนวิชา
        Scanner input=new Scanner(System.in);
        System.out.print("input N: ");
        N=input.nextInt();
        Subject []subj = new Subject[N];

        //เรียกใช้ method ตามจำนวนของวิชา
        for(i=0; i<N; i++){
            subj[i] = new Subject();
            subj[i].setData(i+1);
            subj[i].calTotalPoint();
            sumCredit+=subj[i].getCredit();
            sumTotalPoint=subj[i].getTotalPoint();
        }
        //สร้างตัวแปร gpa คำนวนและเก็บค่าเกรดเฉลี่ย
        gpa=(float)sumTotalPoint/sumCredit;
        System.out.print("\n");
        System.out.println("\t\t\t Grade\t\t GradePoint\t Credit\t         TotalPoint");
        //ทำการแสดงค่าต่างๆ จากใน method printData ตามจำนวนนักเรียน 
        for(i=0; i<N; i++){
            subj[i].printData(i+1);
        }
        //ทำการแสดงค่า credit รวม คำตะแนนรวมทั้งหมดและเกรดเฉลี่ย
        System.out.println("Total      \t\t\t\t\t\t "+sumCredit+"\t\t "+sumTotalPoint);
        System.out.println("GPA = "+gpa);
        System.out.print("\n");
    }
} 

