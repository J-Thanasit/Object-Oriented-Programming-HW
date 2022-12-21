//630510625_ธนศิษฐ์
import java.util.Scanner;

//สร้าง class Star
class Star{
    private int number;
    private String star_name;
    private int vote_score;

    //สร้าง method Star สำหรับสร้างและเก็บ instance
    public Star(int no,String s_name,int score){
        number = no;
        star_name = s_name;
        vote_score = score;
    }

    //สร้าง method starNo สำหรับส่งหมายเลขดารา
    public int starNo(){
        return number;
    }

    //สร้าง method สำหรับส่งชื่อดารา
    public String starName(){
        return star_name;
    }

    //สร้าง method สำหรับส่งคะแนนโหวต
    public int voteScore(){
        return vote_score;
    }

    //สร้าง method สำหรับการเพิ่มคะแนนโหวต
    public void plusScore(){
        vote_score += 1;
    }
}

//สร้าง class Voter
class Voter{
    private String voter_name;
    private int m_number;
    private int f_number;

    //สร้าง method Voter สำหรับสร้างและเก็บ instance
    public Voter(String Name,int MStar,int FStar){
        voter_name = Name;
        m_number = MStar;
        f_number = FStar;
    }

    //สร้าง method getName สำหรับส่งชื่อคนโหวต
    public String getName(){
        return voter_name;
    }

    //สร้าง method getMnumber สำหรับส่งหมายเลขดาราชายที่โหวต 
    public int getMnumber(){
        return m_number;
    }

    //สร้าง method getFnumber สำหรับส่งหมายเลขดาราหญิงที่โหวต
    public int getFnumber(){
        return f_number;
    }
}

//สร้าง method main ใน class Lab06_3_630510625
public class Lab06_3_630510625{
    public static void main(String[] args){
        int N;
        int m_number;
        int f_number;
        String voter_name;
        Scanner input = new Scanner(System.in);
        //สร้าง constuctor
        Star [] m = {new Star(1,"Nadech",0), new Star(2,"Wier",0), new Star(3,"Mario",0)};
        Star [] f = {new Star(1,"Aum",0), new Star(2,"Yaya",0), new Star(3,"Bella",0)};
        Star [] winner =  new Star[2];
        System.out.print("Input N: ");
        //รับค่าจำนวนผู้โหวต
        N = input.nextInt();
        System.out.print("\n");
        Voter [] v = new Voter[N];
        for(int i=0;i<N;i++){
            //แสดงลำดับผู้โหวต
            System.out.printf("Input vote #%d\n",i+1);
            //รับชื่อผู้โหวต
            System.out.print("Input name: ");
            voter_name = input.next();
            System.out.print("Input number of actor and number of actress: ");
            //รับค่าหมายเลขดาราชายและหญิงที่โหวต
            m_number = input.nextInt();
            f_number = input.nextInt();
            //สร้าง v[i] สำหรับเก็บชื่อผู้โหวตและหมายเลขดาราที่โหวต
            v[i] = new Voter(voter_name, m_number, f_number);
            System.out.print("\n");
        }
        //เรียกใช้ method checkAndPrintVote เพื่อเช็คว่าผู้โหวต โหวตให้ใครและดาราคนไหนมีผลโหวตมากที่สุด
        checkAndPrintVote(m, f, v, winner);
        //เรียกใช้ method printGoodLuck เพื่อแสดงชื่อผู้โหวตที่โหวตหมายเลขดาราที่มีผลโหวตมากที่สุดทั้งชายและหญิงได้ถูกต้อง
        printGoodLuck(v, winner);
    }

    //สร้าง method ภายนอก checkAndPrintVote สำหรับเช็คคะแนนโหวตและดาราที่มีคะแนนโหวตมากที่สุด
    public static void checkAndPrintVote(Star m[], Star f[], Voter v[], Star winner[]){
        for(int i=0;i<v.length;i++){
            if(v[i].getMnumber() == 1){
                m[0].plusScore();
            }else if(v[i].getMnumber() == 2){
                m[1].plusScore();
            }else{
                m[2].plusScore();
            }if(v[i].getFnumber() == 1){
                f[0].plusScore();
            }else if(v[i].getFnumber() == 2){
                f[1].plusScore();
            }else{
                f[2].plusScore();
            }
        }

        //สร้าง array winner เพื่อไว้หาดาราที่มีผลโหวตมากที่สุด 
        winner[0] = m[0];
        winner[1] = f[0];

        //ทำงานตามลูปเพื่อเช็ค array ของดาราชายและหญิงใหม่ว่ามีใครมีค่าเพิ่มขึ้น (ได้คะแนนโหวต) และเปลี่ยนค่าของ array winner เป๋นค่านั้น
        for(int j=0;j<m.length;j++){
            if(m[j].voteScore() > winner[0].voteScore()){
                winner[0] = m[j];
            }if(f[j].voteScore() > winner[1].voteScore()){
                winner[1] = f[j];
            }
        }

        //ทำการแสดงผลชื่อดาราชายและหญิงที่มีผลโหวตมากที่สุด
        System.out.println("Top star award (actor) goes to "+winner[0].starName());
        System.out.println("Top star award (actress) goes to "+winner[1].starName());
    }

    //สร้าง method ภายนอก printGoodLuck เพื่อหาผู้โชคดีที่โหวตดาราชายและหญิงที่มีคะแนนโหวตมากที่สุดได้ถูกต้อง
    public static void printGoodLuck(Voter v[],Star winner[]){
        System.out.print("Good luck voter -> ");
        //ทำงานตามลูปเพื่อไล่เช็คว่าใน array ของผู้โหวตแต่ละคนมีผลโหวตที่ตรงกับดาราที่ได้รับผลโหวตมากที่สุดหรือไม่
        for(int i=0;i<v.length;i++){
            if(v[i].getMnumber() == winner[0].starNo()){
                if(v[i].getFnumber() == winner[1].starNo()){
                    //แสดงผลชื่อผู้โหวตที่เป็นผู้โชคดีทั้งหมด
                    System.out.print(v[i].getName()+" ");
                }
            }
        }
    }
}