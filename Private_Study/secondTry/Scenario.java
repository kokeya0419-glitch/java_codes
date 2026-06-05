package Private_Study.secondTry;
import java.util.*;

public class Scenario {
    public static void main(String[] args){
        AddMember addM = new AddMember();
        Hero h = addM.addMember();
        CityCommond cc = new CityCommond();
        MonsterSelect ms = new MonsterSelect();
        Monster m = ms.randomChoice();
        
        cc.commond(h,m);
    }
}