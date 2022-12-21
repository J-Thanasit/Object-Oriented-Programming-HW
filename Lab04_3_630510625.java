//630510625_ธนศิษฐ์
import java.util.Scanner;

//สร้าง class CourseList
class CourseList{
    private int n;
    private int subjects;
    private String name;
    private String c_list;
    private String search;
    private String [][] std = new String[50][50];
    private int [] sub = new int [50];

    //สร้าง method setData สำหรับการรับค่าต่างๆ
    public void setData(){
        Scanner input = new Scanner(System.in);
        System.out.print("Input number of students: ");
        n = input.nextInt();
        System.out.print("\n");
        //สร้างลูปสำหรับรับค่าชื่อนักเรียนและจำนวนวิชา
        for(int i=0; i<n; i++){
            System.out.print("Student name: ");
            name = input.next();
            System.out.print("Number of subjects: ");
            subjects = input.nextInt();
            //บังคับรันไปสุดจำนวน subjects ที่มากที่สุด
            if(sub[i] < subjects){
                sub[i] = subjects;
            }
            System.out.print("Course list: ");
            //สร้างลูปรับค่ารหัสวิชาและเพิ่มเข้าไปใน array สองมิติ
            for(int j=0;j<subjects;j++){
                c_list = input.next();
                std[i][j+1] = c_list;
            //ทำการเพิ่มชื่อนักเรียนเข้าไปใน array สองมิติ
            }std[i][0] = name;
        }
        //รับค่ารหัสวิชาที่ต้องการค้นหา
        System.out.print("Input subject for searching: ");
        search = input.next();
    }

    //สร้าง method findStudent สำหรับหานักเรียนที่มีรหัสวิชาตรงกับที่ต้องการ
    public void findStudent(){
        for(int i=0;i<n;i++){
            for(int j=0;j<sub[i];j++){
                //วนลูปหากพบรหัสที่วิชาใน array ที่ตรงกับรหัสที่ต้องการให้ทำการ print ชื่อนักเรียนที่พบออกมา
                if(std[i][j+1].equals(search)){
                    System.out.println(std[i][0]);
                }
            }
        }
    }
}

//สร้าง method main ใน class Lab04_3_630510625 สำหรับเรียกใช้ method จากใน class CourseList
public class Lab04_3_630510625{  
    public static void main(String args[]){
        CourseList cl = new CourseList();
        cl.setData();
        cl.findStudent();
    }
} 

