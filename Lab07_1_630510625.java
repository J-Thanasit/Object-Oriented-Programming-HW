//630510625_ธนศิษฐ์
import java.util.Scanner;

//สร้าง class Personnel
class Personnel{
    protected String first_name , last_name;
    protected int age;

    //สร้าง method setInfo รับค่าชื่อและอายุ
    public void setInfo(){
        Scanner input = new Scanner(System.in);
        System.out.print("Input first name: ");
        first_name = input.next();
        System.out.print("Input last name: ");
        last_name = input.next();
        System.out.print("Input age: ");
        age = input.nextInt();
    }
    
    //สร้าง method getFirstName ส่งกลับชื่อจริง
    public String getFirstName(){
        return first_name;
    }
    
    //สร้าง method getLastName ส่งกลับนามสกุล
    public String getlastName(){
        return last_name;
    }
    
    //สร้าง method getAge ส่งกลับอายุ
    public int getAge(){
        return age;
    }
}

//สร้าง class Teacher ที่สืบทอดมาจาก class Personnel
class Teacher extends Personnel{
    private int salary;
    //สร้าง method setSalary รับค่าเงินเดือน
    public void SetSalary(){
        Scanner input = new Scanner(System.in);
        System.out.print("Input salary: ");
        salary = input.nextInt();
    }

    //สร้าง method ส่งกลับเงินเดือน
    public int getSalary(){
        return salary;
    }
}

//สร้าง class Student ที่สืบทอดจาก class Personnel
class Student extends Personnel{
    private int studenYear;
    //สร้าง method รับค่าชั้นปี
    public void setYear(){
        Scanner input = new Scanner(System.in);
        System.out.print("Input study year: ");
        studenYear = input.nextInt();
    }

    //สร้าง method getYear ส่งกลับชั้นปี
    public int getYear(){
        return studenYear;
    }
}

//สร้าง method main ภายใน class Lab07_1_630510625
public class Lab07_1_630510625{
    public static void main(String[] args) {
        //รับค่าจำนวนคนทั้งหมด
        Scanner input = new Scanner(System.in);
        System.out.print("Input N: ");
        int N = input.nextInt();

        Student[] s = new Student[N];
        int si=0;
        Teacher[] t = new Teacher[N];
        int ti=0;
        float avg;

        //ถ้ารับค่าเป็น s หรือ S คือนักเรียน นอกจากนั้นคืออาจารย์
        for (int i=0;i<N;i++){
            System.out.printf("\nInput person #%d (Teacher or Student): ",i+1);
            char choice = input.next().charAt(0);
            if(choice == 's' || choice == 'S'){
                s[si] = new Student();
                s[si].setInfo();
                s[si].setYear();
                si++;
            }else{
                t[ti] = new Teacher();
                t[ti].setInfo();
                t[ti].SetSalary();
                ti++;
            }
        }
        if(si!=0)printAllStudents(s,si);
        if(ti!=0)printAllTeachers(t,ti);
        avg = calAndPrintAvgAge(s,si,t,ti);
        if(ti!=0)countTeacher(t,ti,avg);
    }

    //สร้าง method printAllStudents เพื่อแสดงผลนักเรียนทั้งหมด
    public static void printAllStudents(Student[] s,int n){
        System.out.println("Students");
        System.out.println("\tFirstname\tLastname\tAge\tStudy year");
        String fname, lname;
        int age, year;
        for(int i=0;i<n;i++){
            fname = s[i].getFirstName();
            lname = s[i].getlastName();
            age = s[i].getAge();
            year = s[i].getYear();
            System.out.printf("%d\t%s\t\t%s\t\t%d\t%d\n",i+1,fname,lname,age,year);
        }
        System.out.println();
    }

    //สร้าง method printAllTeachers เพื่อแสดงค่าอาจารย์ทั้งหมด
    public static void printAllTeachers(Teacher[] t,int n){
        System.out.println("Teachers");
        System.out.println("\tFirstname\tLastname\tAge\tSalary");
        String fname, lname;
        int age, salary;
        for(int i=0;i<n;i++){
            fname = t[i].getFirstName();
            lname = t[i].getlastName();
            age = t[i].getAge();
            salary = t[i].getSalary();
            System.out.printf("%d\t%s\t\t%s\t\t%d\t%d\n",i+1,fname,lname,age,salary);
        }
        System.out.println();
    }

    //สร้าง method calAndPrintAvgAge เพื่อคำนวนและแสดงค่าเฉลี่ยของอายุ
    public static float calAndPrintAvgAge(Student[] s, int si, Teacher[] t, int ti){
        float avgStudentAge, avgTeacherAge = 0f;
        int i;

        if(si!=0){
            int sumStudentAge = 0;
            for(i=0;i<si;i++){
                sumStudentAge += s[i].getAge();
            }
            avgStudentAge = (float)sumStudentAge/si;
            System.out.printf("Average of student age = %.2f\n",avgStudentAge);
        }

        if(ti!=0){
            int sumTeacherAge = 0;
            for(i=0;i<ti;i++){
                sumTeacherAge += t[i].getAge();
            }
            avgTeacherAge = (float)sumTeacherAge/ti;
            System.out.printf("Average of teacher age = %.2f\n",avgTeacherAge);
        }
        return avgTeacherAge;
    }

    //สร้าง method countTeacher เพื่อนับจำนวนอาจารย์ที่อายุน้อยกว่าค่าเฉลี่ย
    public static void countTeacher(Teacher[] t, int n, float avg){
        int numTBelowAge=0;

        for(int i=0;i<n;i++){
            if((float)t[i].getAge()<avg){
                numTBelowAge += 1;
            }
        }
        System.out.printf("Number of teachers who have age below average = %d\n",numTBelowAge);
    }
}