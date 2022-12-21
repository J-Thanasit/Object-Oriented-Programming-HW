//630510625_ธนศิษฐ์
import java.util.Scanner;

//สร้าง class StandardWeight
class StandardWeight{
    private String name;
    private int height;
    private int weight;
    private char sex;

    //สร้าง method StandardWeight เพื่อสร้าง instance สำหรับรับค่า parameter
    public StandardWeight(String n,int h, int w, char s){
        name = n;
        height = h;
        weight = w;
        sex = s;
    }

    //สร้าง method getName สำหรับส่งกลับชื่อ
    public String getName(){
        return name;
    }

    //สร้าง method getName สำหรับส่งกลับความสูง
    public int getHeight(){
        return height;
    }

    //สร้าง method getName สำหรับส่งกลับน้ำหนัก
    public int getWeight(){
        return weight;
    }

    //สร้าง method getName สำหรับส่งกลับเพศ
    public char getSex(){
        return sex;
    }

    //สร้าง method getName สำหรับส่งกลับน้ำหนักมาตรฐานชาย
    public int stdWeightM(){
        height = height-100;
        return height;
    }

    //สร้าง method getName สำหรับส่งกลับน้ำหนักมาตรฐานหญิง
    public int stdWeightF(){
        height = height-110;
        return height;
    }
}

//สร้าง method main ใน class Lab06_2_630510625
public class Lab06_2_630510625{
    public static void main(String[] args){
        String name;
        char sex;
        int height; 
        int weight;
        //สร้าง array สำหรับเก็บค่าต่างๆ
        StandardWeight [] s = new StandardWeight[2];
        StandardWeight [] m = new StandardWeight[2];
        Scanner input = new Scanner(System.in);
        for(int i=0;i<2;i++){
            System.out.printf("Input data for person #%d\n",i+1);
            System.out.print("Input name: ");
            //รับค่าขื่อ
            name = input.next();
            System.out.print("Input height: ");
            //รับค่าส่วนสูง
            height = input.nextInt();
            System.out.print("Input weight: ");
            //รับค่าน้ำหนัก
            weight = input.nextInt();
            System.out.print("Input sex: ");
            //รับค่าเพศ
            sex = input.next().charAt(0);
            //สร้าง array สำหรับเก็บค่าตาม parameter
            s[i] = new StandardWeight(name, height, weight, sex);
            System.out.print("\n");
        }
        //เรียกใช้ method ภายนอก calWeight
        calWeight(s,m);
    }

    //สร้าง method ภายนอก calWeight
    public static void calWeight(StandardWeight s[], StandardWeight m[]){
        //สร้าง array สำหรับเก็บค่าส่วนสูง
        m[0] = s[0];
        m[1] = s[1];
        //สร้างตัวแปรสำหรับเก็บค่าน้ำหนักมาตรฐาน
        int m_new = 0;
        int f_new = 0;
        for(int i=0;i<s.length;i++){
            //เช็คเพศ หากเป็นเพศชายให้ทำการเรียกใช้ method stdWeightM และเก็บค่าน้ำหนักมาตรฐานไว้ใน m_new
            if(s[i].getSex() == 'M'){
                m_new = m[0].stdWeightM();
            //หรือหากเป็นเพศหญิงให้ทำการเรียกใช้ method stdWeightF และเก็บค่าน้ำหนักมาตรฐานไว้ใน f_new
            }else if(s[i].getSex() == 'F'){
                f_new = m[1].stdWeightF();
            }
        }
        //ทำการเปรียบเทียบน้ำหนักกับน้ำหนักมาตรฐานว่ามีค่าเท่ากัน หรือใครมีน้ำหนักที่ห่างจากน้ำหนักมาตรฐานมากหรือน้อยกว่า
        if(Math.abs(m_new - s[0].getWeight()) == Math.abs(f_new - s[1].getWeight())){
            System.out.print("The weight of both of them are close to the standard weight equally");
        }else if(Math.abs(m_new - s[0].getWeight()) < Math.abs(f_new - s[1].getWeight())){
            System.out.printf("Weight of %s is closer to standard weight than %s\n",s[0].getName(),s[1].getName());
        }else{
            System.out.printf("Weight of %s is closer to standard weight than %s\n",s[1].getName(),s[0].getName());
        }
    }
}

