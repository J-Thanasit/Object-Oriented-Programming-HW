//630510625_ธนศิษฐ์
import java.util.Scanner;

//สร้าง class Employee
class Employee{
    protected String id;
    protected String name;

    //สร้าง method setInfo สำหรับรับค่า id, ชื่อและนามสกุล
    public void setInfo(){
        Scanner input = new Scanner(System.in);
        System.out.print("Input id: ");
        id = input.next();
        System.out.print("Input name: ");
        name = input.nextLine();
        name += input.nextLine();
    }

    //สร้าง method getId สำหรับส่งกลับค่า id
    public String getId(){
        return id;
    }

    //สร้าง method สำหรับส่งกลับชื่อ นามสกุล
    public String getName(){
        return name;
    }
}

//สร้าง class Monthly_Employee ที่สืบทอดมาจาก class Employee
class Monthly_Employee extends Employee{
    private int salary;
    private int otp;
    private int otw;
    Scanner input = new Scanner(System.in);

    //สร้าง method setMonthlyInfo เพื่อรับเงินค่าจ้างและเวลา OT
    public void setMonthlyInfo(){
        System.out.print("Input salary: ");
        salary = input.nextInt();
        System.out.print("Input overtime period: ");
        otp = input.nextInt();
    }

    //สร้าง method เพื่อส่งกลับเงินค่าจ้าง
    public int getSalary(){
        return salary;
    }

    //สร้าง method เพื่อส่งกลับเงินเดือน
    public void calMonthlyWage(){
        otw = otp*200;
    }

    //สร้าง method เพื่อส่งกลับเงิน OT
    public int getOvertimeWage(){
        return otw;
    }

}

//สร้าง class Commission_Employee ที่สืบทอดมาจาก Employee
class Commission_Employee extends Employee{
    protected int commission;
    protected int total_sale;
    protected int commission_rate;
    protected int monthly_wage;
    
    //สร้าง method setCommissionInfo เพื่อรับค่ายอดขายและ % ค่าคอมมิชชั่น
    public void setCommissionInfo(){
        Scanner input = new Scanner(System.in);
        System.out.print("Input total sale: ");
        total_sale = input.nextInt();
        System.out.print("Input percent of commission rate: ");
        commission_rate = input.nextInt();
    }

    //สร้าง method calCommission เพื่อคำนวนหาค่าคอมมิชชั่น
    public void calCommission(){
        commission = (int)(total_sale * ((float)commission_rate / 100));
    }

    //สร้าง method getCommission เพื่อส่งกลับค่าคอมมิชชั่น
    public int getCommission(){
        return commission;
    }
}

//สร้าง Class Weekly_Employee ที่สืบทอดมาจาก class Commission_Employee
class Weekly_Employee extends Commission_Employee{
    private int weeklyRate;
    private int weeklyWeek;
    
    //สร้าง method setWeeklyInfo เพื่อรับค่าเรทการจ่ายเงินรายสัปดาห์และจำนวนสัปดาห์ที่ทำงาน
    public void setWeeklyInfo(){
        Scanner input = new Scanner(System.in);
        System.out.print("Input weekly rate: ");
        weeklyRate = input.nextInt();
        System.out.print("Input working week: ");
        weeklyWeek = input.nextInt();
    }

    //สร้าง method calMonthlyWage เพื่อคำนวนเงินค่าจ้างรายเดือน
    public void calMonthlyWage(){
        monthly_wage = weeklyRate*weeklyWeek;
    }

    //สร้าง method calMonthlyWage เพื่อส่งกลับเงินค่าจ้างรายเดือน
    public int getMonthlyWage(){
        return monthly_wage;
    }
}

//สร้าง class Daily_Employee ที่สืบทอดมาจาก class Commission_Employee
class Daily_Employee extends Commission_Employee{
    private int dailyRate;
    private int workingDay;
    Scanner input = new Scanner(System.in);

    //สร้าง method setDailyInfo เพื่อรับค่าเรทการจ่ายเงินรายวันและจำนวนวันที่ทำงาน
    public void setDailyInfo(){
        System.out.print("Input daily rate: ");
        dailyRate = input.nextInt();
        System.out.print("Input working day: ");
        workingDay = input.nextInt();
    }

    //สร้าง method calMonthlyWage เพื่อคำนวนเงินค่าจ้างรายเดือน
    public void calMonthlyWage(){
        monthly_wage = dailyRate * workingDay;
    }

    //สร้าง method getMonthlyWage เพื่อส่งกลับเงินค่าจ้างรายเดือน
    public int getMonthlyWage(){
        return monthly_wage;
    }
}

//สร้าง method main ใน class Lab07_2_630510625
public class Lab07_2_630510625{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        //รับค่าจำนวนลูกจ้างรายเดือน
        System.out.print("Input Number of monthly employees: ");
        int m_employee = input.nextInt();
        System.out.println();
        Monthly_Employee[] m = new Monthly_Employee[m_employee];
        int ei_m = 0;
        for(int i=0;i<m_employee;i++){
            System.out.printf("Input person #%d\n",i+1);
            m[ei_m] = new Monthly_Employee();
            m[ei_m].setInfo();
            m[ei_m].setMonthlyInfo();
            m[ei_m].calMonthlyWage();
            ei_m++;
            System.out.println();
        }

        System.out.println("..................................................");
        System.out.println();

        //รับค่าจำนวนลูกจ้างรายสัปดาห์
        System.out.print("Input Number of weekly employees: ");
        int w_employee = input.nextInt();
        Weekly_Employee[] w = new Weekly_Employee[w_employee];
        int ei_w = 0;
        System.out.println();
        for(int j=0;j<w_employee;j++){
            System.out.printf("Input person #%d\n",j+1);
            w[ei_w] = new Weekly_Employee();
            w[ei_w].setInfo();
            w[ei_w].setCommissionInfo();
            w[ei_w].setWeeklyInfo();
            w[ei_w].calCommission();
            w[ei_w].calMonthlyWage();
            ei_w++;
            System.out.println();
        }

        System.out.println("..................................................");
        System.out.println();

        //รับค่าจำนวนลูกจ้างรายวัน
        System.out.print("Input Number of daily employees: ");
        int d_employee = input.nextInt();
        Daily_Employee[] d = new Daily_Employee[d_employee];
        int ei_d = 0;
        System.out.println();
        for(int k=0;k<d_employee;k++){
            System.out.printf("Input person #%d\n",k+1);
            d[ei_d] = new Daily_Employee();
            d[ei_d].setInfo();
            d[ei_d].setCommissionInfo();
            d[ei_d].setDailyInfo();
            d[ei_d].calCommission();
            d[ei_d].calMonthlyWage();
            ei_d++;
            System.out.println();
        }
        System.out.print("\t\t\t\t\tABC Company\n");
        if(ei_m != 0)printAllMonthly_Employee(m, ei_m);
        if(ei_w != 0)printAllWeekly_Employee(w, ei_w);
        if(ei_d != 0)printAllDaily_Employee(d, ei_d);
    }

    //สร้าง method ภายนอก printAllMonthly_Employee เพื่อแสดง id ชื่อ และเงินเดือนของลูกจ้างรายเดือนทั้งหมด
    public static void printAllMonthly_Employee(Monthly_Employee[] m, int n) {
        System.out.println("\tMonthly Employees");
        System.out.println("\tID\t\t\tName\tSalary\t\tOvertime wage   Total");
        String id,name;
        int salary,overtime_wage,total;
        int total_salary = 0,total_overtime_wage = 0,total_ = 0;
        for(int i=0;i<n;i++){
            id = m[i].getId();
            name = m[i].getName();
            salary = m[i].getSalary();
            overtime_wage = m[i].getOvertimeWage();
            total = salary + overtime_wage;
            total_salary += salary;
            total_overtime_wage += overtime_wage;
            total_ += total;
            System.out.printf("\t%s\t\t\t%s\t%d\t\t%d\t\t%d\n",id,name,salary,overtime_wage,total);
        }
        System.out.printf("\tTotal\t\t\t\t%d\t\t%d\t\t%d",total_salary,total_overtime_wage,total_);
        System.out.println();
        System.out.println();
    }

    //สร้าง method ภายนอก printAllWeekly_Employee เพื่อแสดง id ชื่อ และเงินเดือนของลูกจ้างรายสัปดาห์ทั้งหมด
    public static void printAllWeekly_Employee(Weekly_Employee[] w, int n){
        System.out.println("\tWeekly Employees");
        System.out.println("\tID\t\t\tName\tCommission\tMonthly wage   Total");
        String id,name;
        int commission,m_wage,total;
        int total_commission = 0,total_m_wage = 0,total_ = 0;
        for(int i=0;i<n;i++){
            id = w[i].getId();
            name = w[i].getName();
            commission = w[i].getCommission();
            m_wage = w[i].getMonthlyWage();
            total = commission + m_wage;
            total_commission += commission;
            total_m_wage += m_wage;
            total_ += total;
            System.out.printf("\t%s\t\t\t%s\t%d\t\t%d\t\t%d\n",id,name,commission,m_wage,total);
        }
        System.out.printf("\tTotal\t\t\t\t%d\t\t%d\t\t%d",total_commission,total_m_wage,total_);
        System.out.println();
        System.out.println();
    }

    //สร้าง method ภายนอก printAllDaily_Employee เพื่อแสดง id ชื่อ และเงินเดือนของลูกจ้างรายวันทั้งหมด
    public static void printAllDaily_Employee(Daily_Employee[] d, int n){
        System.out.println("\tDaily Employees");
        System.out.println("\tID\t\t\tName\tCommission\tMonthly wage    Total");
        String id,name;
        int commission,m_wage,total;
        int total_commission = 0,total_m_wage = 0,total_ = 0;
        for(int i=0;i<n;i++){
            id = d[i].getId();
            name = d[i].getName();
            commission = d[i].getCommission();
            m_wage = d[i].getMonthlyWage();
            total = commission + m_wage;
            total_commission += commission;
            total_m_wage += m_wage;
            total_ += total;
            System.out.printf("\t%s\t\t\t%s\t%d\t\t%d\t\t%d\n",id,name,commission,m_wage,total);
        }
        System.out.printf("\tTotal\t\t\t\t%d\t\t%d\t\t%d",total_commission,total_m_wage,total_);
        System.out.println();
    }
}

