//630510625_ธนศิษฐ์
import java.util.Scanner;

//สร้าง abstract class Student เป็น main class
abstract class Student{
    protected String name;
    protected int midtermScore;
    protected int finalScore;

    //สร้าง method รับค่าชื่อและคำแนน
    public void setInfo(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter name: ");
        name = input.nextLine();
        System.out.print("Enter midterm score: ");
        midtermScore = input.nextInt();
        System.out.print("Enter final score: ");
        finalScore = input.nextInt();
    }

    //ส่งกลับชื่อ
    public String getName(){
        return name;
    }

    //ส่งกลับคะแนนมิดเทอม
    public int getMidtermScore(){
        return midtermScore;
    }

    //ส่งกลับคะแนนไฟนอล
    public int getfinalScore(){
        return finalScore;
    }
    
    //สร้าง method แบบ abstract แบบไม่มี parameter ไว้คะนวนเกรด
    public abstract char calGrade(int totalScore);
}

//สร้าง sub class นักเรียนที่ยังไม่จบ
class Undergraduate_Student extends Student{
    private int projectScore;

    //สร้าง method รับค่าคะแนนโปรเจค
    public void setProjectScore(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter project score: ");
        projectScore = input.nextInt();
    }

    //ส่งกลับคะแนนโปรเจค
    public int getProjectScore(){
        return projectScore;
    }

    @Override
    //ทำการตรวจสอบคะแนนว่าตรงเงื่อนไขไหนและส่งกลับเกรด S หรือ U
    public char calGrade(int totalScore){
        return (totalScore>=50 && projectScore>=50)?'S':'U';
    }
}

//สร้าง sub class นักเรียนที่จบแล้ว
class Graduate_Student extends Student{
    private int publicationNo;

    //สร้าง method รับค่าจำนวนงานวิจัยที่ได้รับการตีพิมพ์
    public void setPublicationNo(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of publication: ");
        publicationNo = input.nextInt();
    }

    //ส่งกลับค่างานวิจัยที่ได้รับการตีพิมพ์
    public int getPublicationNo(){
        return publicationNo;
    }

    @Override
    //ทำการตรวจสอบคะแนนจำนวนงานวิจัยว่าตรงเงื่อนไขไหนและส่งกลับเกรด S หรือ U
    public char calGrade(int totalScore){
        return (totalScore>=60 && publicationNo>=2)?'S':'U';
    }
}

//สร้าง method main ภายใน class Lab10_1_630510625
public class Lab10_1_630510625{
    public static void main(String[] args){
        char choice;
        int id = 0;
        Student[] std = new Student[100];
        Scanner input = new Scanner(System.in);
        do{
            //รับค่า u หรือ g
            System.out.print("Enter undergraduate student of graduate student (u/g): ");
            choice = input.nextLine().charAt(0);
            if(choice == 'u'){
                std[id] = new Undergraduate_Student();
                std[id].setInfo();
                ((Undergraduate_Student)std[id]).setProjectScore();
                id++;
            }else if(choice == 'g'){
                std[id] = new Graduate_Student();
                std[id].setInfo();
                ((Graduate_Student)std[id]).setPublicationNo();
                id++;
            }else{
                //หากรับค่าที่ไม่ใช่ u หรือ g
                System.out.print("Invalid type of student");
                System.out.println();
            }
            //ถามว่าต้องการับค่าเพิ่มเติมมั้ย
            System.out.print("Enter another (y,n)? ");
            choice = input.nextLine().charAt(0);
            System.out.println();
        //หากรับค่าเป็น y ให้ทำการทำลูปซ้ำ
        }while(choice == 'y');

        reportGrade(std,id);
    }

    //สร้าง method ภายนอกสำหรับการแสดงผลเกรด
    public static void reportGrade(Student[] std,int n){
        System.out.printf("Grade Report\n");
        System.out.printf("==========\n");

        //ทำการรับค่าเกรดแต่ละเทอมที่ส่งกลับมาเพื่อหาคะแนนรวม
        int num_S = 0;
        for(int i=0;i<n;i++){
            System.out.printf("%s",std[i].getName());
            int mid = std[i].getMidtermScore();
            int fn = std[i].getfinalScore();
            int totalScore = mid+fn;
            System.out.printf(" gets grade");

            //เรียกใช้ calGrade ให้เกิดการ override ตาม obj ที่เป็น instance ของ class นั้นๆ
            char grade;
            if(std[i] instanceof Undergraduate_Student){
                grade = std[i].calGrade(totalScore);
            }else{
                grade = std[i].calGrade(totalScore);
            }
            System.out.printf(" %c.\n",grade);

            //หาก grade คือ S ให้นับจำนวนเพิ่มขึ้น
            if(grade == 'S'){
                num_S++;
            }
        }
        //ทำการแสดงจำนวนของแต่ละเกรด
        System.out.printf("Total: Grade U = %d Grade S = %d\n",n-num_S,num_S);
    }
}