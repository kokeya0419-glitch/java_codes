package Private_Study.thirdTry_PT;
import java.util.*;

public class Scenario {
    public static void main(String[] args){
        AddMember addM = new AddMember();
        Hero h = addM.addMember(); //前回の追加の仕方
        Party party = new Party();
        party.addMember(h);
        CityCommond cc = new CityCommond();
        MonsterSelect ms = new MonsterSelect();
        Monster m = ms.randomChoice();
        
        cc.commond(h,m, party);
    }
}