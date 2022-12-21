//630510625_ธนศิษฐ์
import java.util.Scanner;
import java.util.Arrays;
public class Lab01_2_630510625{
    public static void main(String[] args){
        //สร้าง Array เก็บข้อมูลคะแนน
        int [] all = new int[9999]; 
        Scanner sn = new Scanner(System.in);
        int max_ = 0,min_ = 0,score,count = 0;
        int i,l_avg = 0,sum = 0,avg = 0;
        System.out.println("Enter score between 1-100 or press 0 for stop");
        //สร้างตัวแปรรับค่าคะแนน
        score = sn.nextInt();
        while(score != 0){
            //ถ้าค่าที่รับมาเกิน 100 ให้ใส่ค่าใหม่
            if(score <= 100){
                all[count] = score;
                sum += all[count];
                count += 1;
            }
            //ถ้าค่าที่รับมาไม่เกิน 100 ให้เพิ่มไปใน Array และนับจำนวนข้อมูล
            else{
                System.out.println("Enter score again (between 1-100 or press 0 for stop)");
            }
            score = sn.nextInt();
        }
        //เรียงจำนวนใน Array
        Arrays.sort(all);
        //หาค่ามากสุด น้อยสุด และค่าเฉลี่ยของคะแนน
        if(count != 0){
            max_ = all[9998];
            min_ = all[9999-count];
            avg = sum/count;
        }
        //หาจำนวนของคะแนนที่น้อยกว่าค่าเฉลี่ย
        for(i = 9998; i >= 9999-count ; i--){
            if(all[i] < avg){
                l_avg += 1;
            }
        }
        //แสดงผลค่าทั้งหมดที่หาได้
        System.out.printf("Maximum Score = %d \n",max_);
        System.out.printf("Minimum Score = %d \n",min_);
        System.out.printf("Average Score = %d \n",avg);
        System.out.printf("The number of students who scored below average score = %d \n",l_avg);
    }
    
}
