//630510625_ธนศิษฐ์
import java.util.Scanner;
import java.util.Arrays;
//สร้าง class Grade
class Grade{
    private int std_num;
    private int mid_scr;
    private int fin_scr;
    private int all_score;
    private String grades;

    //สร้าง method setData สำหรับรับรหัสนักศึกษาและคะแนนสอบทั้งสองครั้ง
    public void setData(){
        Scanner inVar = new Scanner(System.in);
        System.out.print("\n");
        System.out.print("Enter student ID: ");
        std_num = inVar.nextInt();
        System.out.print("Enter midterm and final scores: ");
        mid_scr = inVar.nextInt();
        fin_scr = inVar.nextInt();
        System.out.print("\n");
    }

    //สร้าง method calGrade สำปรับการคำนวณเกรดจากคะแนนสอบทั้งสองครั้ง
    public void calGrade(){
        all_score = mid_scr+fin_scr;
        if (all_score >= 85){
            grades = "A";
        }else if (all_score < 84 && all_score >= 80){
            grades = "B+";
        }else if (all_score < 80 && all_score >= 75){
            grades = "B";
        }else if (all_score < 75 && all_score >= 60){
            grades = "C+";
        }else if (all_score < 60 && all_score >= 55){
            grades = "C";
        }else if (all_score < 55 && all_score >= 50){
            grades = "D+";
        }else if (all_score < 50 && all_score >= 45){
            grades = "D";
        }else{
            grades = "F";
        }
    }

    //สร้าง method printResult สำหรับการแสดงผลลำดับ รหัสนักศึกษา ผลรวมคะแนน และเกรด
    public void printResult(int j){
        System.out.printf("%d   ",j+1);
        System.out.printf("%d   ",std_num);
        System.out.printf("%d   ",all_score);
        System.out.printf("%s"+"\n",grades);
        }
    }

    //สร้าง class main
public class Lab03_3_630510625{
    public static void main(String[] args) {
        int n;
        Scanner inVar = new Scanner(System.in);
        //รับค่า N เพื่อรู้จำนวนนักเรียน
        System.out.print("Enter N: ");
        n = inVar.nextInt();
        System.out.print("\n");
        //สร้าง array g แทน class grade  
        Grade [] g = new Grade[n+1];
        //สั่งให้โปรแกรมทำงาน method ภายใน class Grade ตามจำนวน N (จำนวนนักเรียน) ที่รับค่ามา
        for(int i=0; i<n; i++){
            System.out.printf("Enter data for student #%d",i+1);
            g[i] = new Grade();
            g[i].setData();
            g[i].calGrade();
            //แสดงผลลัพธ์ตามจำนวนนักเรียน
        }for(int j=0; j<n; j++){
            g[j].printResult(j);
        }
    }
} 

