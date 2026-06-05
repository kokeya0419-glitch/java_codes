package Private_Study.secondTry;

import java.util.ArrayList;
import java.util.Scanner;

public class AddMember {
    ArrayList<protagonist> member = new ArrayList();
    Scanner sc = new Scanner(System.in);

    public Hero addMember() {
        SlowPoint.slowPoint("新たな勇者を作成します。\n" + "勇者の名前を教えてください");
        String name = sc.nextLine();
        Hero h = new Hero(name);
        h.birthComment(h);
        SlowPoint.slowPoint("勇者 ”" + h.getName() + "” よ、新たな冒険の始まりです");
        return h;
    }

    // パーティメンバー追加
    public protagonist addPartyMember() {
        SlowPoint.slowPoint("仲間に加える職種を選択してください。");
        SlowPoint.slowPoint("1:ウォーリアー　2:魔法使い　3:遊び人");
        int select = sc.nextInt();
        while(true){
            select = sc.nextInt();
            if(select >= 1 && select <=3){
                break;
            }else{
                sc.next(); //文字列は排除
            }
            SloPoint.slowPoint("正しい数値を入れてください");
        }
        if(select == 1){
            SlowPoint.slowPoint("ウォーリアーの名前を決めてください。");
            String name = sc.nextLine();
        }
    }
}