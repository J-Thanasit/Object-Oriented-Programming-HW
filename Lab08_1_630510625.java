//6305160625_ธนศิษฐ์
import java.util.Scanner;

//สร้าง class Land
class Land{
    protected int landSize;

    //รับค่า landSize
    public void setLandSize(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter land size: ");
        landSize = input.nextInt();
    }
}

//สร้าง class LandForHouse ที่สืบทอดมาจาก class Land
class LandForHouse extends Land{
    protected int housePrice;
    private int saleStatus=0;
    Scanner input = new Scanner(System.in);

    //รับค่า housePrice
    public void setData(){
        System.out.print("Enter house price: ");
        housePrice = input.nextInt();
    }

    //ส่งกลับค่า saleStatus เป็น 1 เพื่อบอกว่าขายแล้ว พร้อมกับส่งกลับค่า housePrice
    public int getHousePrice(){
        saleStatus = 1;
        return housePrice;
    }

    //ส่งกลับค่า saleStatus
    public int getSaleStatus(){
        return saleStatus;
    }
}

//สร้าง class LandForSale ที่สืบทอดมาจาก class LandForHouse
class LandForSale extends LandForHouse{
    private String titleDeed;
    private int saleStatus = 0;
    private int evaluatePrice;
    private double salePrice;
    Scanner input = new Scanner(System.in);

    //รับค่า titleDeed และ evaluatePrice
    public void setData(){
        System.out.print("Enter title deed: ");
        titleDeed = input.next();
        System.out.print("Enter Evaluate price: ");
        evaluatePrice = input.nextInt();
    }

    //คำนวณหา salePrice และกำหนดค่า saleStatus เป็น 1 เพื่อบอกว่าขายแล้ว
    public void calSalePrice(int housePrice){
        salePrice = evaluatePrice + (0.1*evaluatePrice) + (0.05*housePrice);
        saleStatus = 1;
    }

    //ส่งกลับค่า titleDeed
    public String getTitleDeed(){
        return titleDeed;
    }

    //ส่งกลับค่า saleStatus
    public int getSaleStatus(){
        return saleStatus;
    }

    //ส่งกลับค่า evalutatePrice
    public int getEvaluatePrice(){
        return evaluatePrice;
    }

    //ส่งกลับค่า salePrice
    public double getSalePrice(){
        return salePrice;
    }
}

//สร้าง method main มน class Lab08_1_630510625
public class Lab08_1_630510625{
    public static void main(String[] args) {
        int houseNumber,landNumber;
        int house=0,land=0;
        Scanner input = new Scanner(System.in);
        //รับค่า houseNumber
        System.out.print("Enter number of house: ");
        houseNumber = input.nextInt();
        //รับค่า landNumber
        System.out.print("Enter number of lands: ");
        landNumber = input.nextInt();
        System.out.println();
        LandForHouse[] H = new LandForHouse[houseNumber];
        LandForSale[] L = new LandForSale[landNumber];
        //ทำการวนลูปเพื่อกำหนดค่าให้เท่ากับจำนวนบ้าน
        for(int i=0;i<houseNumber;i++){
            System.out.printf("Enter data for house #%d\n",i+1);
            H[house] = new LandForHouse();
            H[house].setLandSize();
            H[house].setData();
            house++;
            System.out.println();
        }

        //ทำการวนลูปเพื่อกำหนดค่าให้เท่ากับจำนวนที่ดิน
        for(int j=0;j<landNumber;j++){
            System.out.printf("Enter data for land #%d\n",j+1);
            L[land] = new LandForSale();
            L[land].setLandSize();
            L[land].setData();
            land++;
            System.out.println();
        }
        //ทำการเรียกใช่ method ภายนอกเพื่อสร้างผลการทำงานของโปรแกรม
        printMatchAndProfit(H,L,house,land);
    }

    //สร้าง method ภายนอกเพื่อจับคู่บ้านกับที่ดินและแสดงผลกำไรที่ได้จากการขาย
    public static void printMatchAndProfit(LandForHouse[] H,LandForSale[] L,int house,int land){
        double salePrice;
        double profit=0;
        String titleDeed;

        System.out.print("Report for lands which can be sold\n");
        System.out.print("Title deed\tSale price\n");
        //วนลูปเพื่อหาที่ดินที่ตรงเงื่อนไขกับบ้าน
        for(int i=0;i<land;i++){
            for(int j=0;j<house;j++){
                if(H[i].landSize <= L[j].landSize && H[i].getSaleStatus() == 0 && L[j].getSaleStatus() == 0){
                    L[j].calSalePrice(H[i].getHousePrice());
                    //รับราคาขายที่ดิน
                    salePrice = L[j].getSalePrice();
                    //หากำไรโดนการนำราคาขายลบราคาประเมิน
                    profit += (salePrice - L[j].getEvaluatePrice());
                    titleDeed = L[j].getTitleDeed();
                    System.out.printf("%s\t\t%.2f",titleDeed,salePrice);
                    System.out.println();
                    break;
                }
            }
        }
        System.out.println();
        //ทำการแสดงผลกำไรที่ได้
        System.out.printf("Total profit = %.2f",profit);
    }
}