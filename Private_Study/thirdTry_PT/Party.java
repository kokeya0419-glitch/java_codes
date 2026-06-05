package Private_Study.thirdTry_PT;
import java.util.ArrayList;

public class Party{
    private ArrayList<protagonist> members = new ArrayList();

    //メンバー追加メソッド
    public void addMember(protagonist member){
        members.add(member);
    }

    public ArrayList<protagonist> getMembers(){
        return this.members;
    }

    public void showParty(){
        SlowPoint.slowPoint("【パーティーメンバー】");

        for(protagonist member : members){
            System.out.println("Lv：" + this.getLevel() + "\n" +
            "名前：" + this.getName());

        }
    }
}