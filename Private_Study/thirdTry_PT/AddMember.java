package Private_Study.thirdTry_PT;

import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Scanner;

public class AddMember {
    // 文字化け対策: Windows端末からの日本語入力に合わせる
    Scanner sc = new Scanner(new InputStreamReader(System.in, Charset.forName("MS932")));

    public Hero addMember() {
        SlowPoint.slowPoint("新たな勇者を作成します。\n" + "勇者の名前を教えてください");
        String name = sc.nextLine();
        Hero h = new Hero(name);
        h.birthComment(h);
        SlowPoint.slowPoint("勇者 ”" + h.getName() + "” よ、新たな冒険の始まりです");
        return h;
    }

    // パーティメンバー追加
    public Protagonist addPartyMember(Party party) {
        if (party.isFull()) {
            SlowPoint.slowPoint("これ以上仲間を追加することが出来ない");
            return null;
        }
        SlowPoint.slowPoint("仲間に加える職種を選択してください。");
        SlowPoint.slowPoint("1:戦士　2:魔法使い　3:遊び人　4:やめておく");
        int select;
        String name;

        while(true){
                try{
                    select = sc.nextInt();
                    if(select >= 1 && select <= 4){
                        break;
                    }
                    SlowPoint.slowPoint("1～4を入力してください！");
                }catch(Exception e){
                    SlowPoint.slowPoint("半角数字で入力してください。");
                    sc.next(); //文字列は排除する
                }
            }

        sc.nextLine(); // nwxtInt後の改行を捨てる

        switch (select) {
            case 1 -> {
                SlowPoint.slowPoint("戦士の名前を決めてください。");
                name = sc.nextLine();
                Protagonist warrior = new Warrior(name);
                SlowPoint.slowPoint(name + "が、仲間に加わった！");
                warrior.birthComment();
                return warrior;
            }
            case 2 -> {
                SlowPoint.slowPoint("魔法使いの名前を決めてください。");
                name = sc.nextLine();
                Protagonist wizard = new Wizard(name);
                SlowPoint.slowPoint(name + "が、仲間に加わった！");
                wizard.birthComment();
                return wizard;
            }
            case 3 -> {
                SlowPoint.slowPoint("遊び人の名前を決めてください。");
                name = sc.nextLine();
                Protagonist gadabout = new Gadabout(name);
                SlowPoint.slowPoint(name + "が、仲間に加わった！");
                gadabout.birthComment();
                return gadabout;
            }
            case 4 -> {
                SlowPoint.slowPoint("やめておこう・・・");
                return null;
            }
            default -> {
                SlowPoint.slowPoint("正しい番号を入力してください。");
            }
        }
        return null;
    }
}