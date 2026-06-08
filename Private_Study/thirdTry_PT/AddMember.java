package Private_Study.thirdTry_PT;

import java.util.ArrayList;
import java.util.Scanner;

public class AddMember {
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
    public Protagonist addPartyMember(Party party) {
        if (party.isFull()) {
            SlowPoint.slowPoint("これ以上仲間を追加することが出来ない");
            return null;
        }
        SlowPoint.slowPoint("仲間に加える職種を選択してください。");
        SlowPoint.slowPoint("1:ウォーリアー　2:魔法使い　3:遊び人　4:やめておく");
        int select;
        String name;

        while (true) {
            if (sc.hasNextInt()) {
                select = sc.nextInt();
                if (select >= 1 && select <= 4) {
                    break;
                }
            } else {
                sc.next(); // 文字列は排除
            }
            SlowPoint.slowPoint("正しい数値を入れてください");
        }

        sc.nextLine(); // nwxtInt後の開業を捨てる

        switch (select) {
            case 1 -> {
                SlowPoint.slowPoint("ウォーリアーの名前を決めてください。");
                name = sc.nextLine();
                Protagonist warrior = new Warrior(name);
                SlowPoint.slowPoint(name + "が、仲間に加わった！");
                warrior.birthComment(warrior);
                return warrior;
            }
            case 2 -> {
                SlowPoint.slowPoint("魔法使いの名前を決めてください。");
                name = sc.nextLine();
                Protagonist wizard = new Wizard(name);
                SlowPoint.slowPoint(name + "が、仲間に加わった！");
                wizard.birthComment(wizard);
                return wizard;
            }
            case 3 -> {
                SlowPoint.slowPoint("遊び人の名前を決めてください。");
                name = sc.nextLine();
                Protagonist gadabout = new Gadabout(name);
                SlowPoint.slowPoint(name + "が、仲間に加わった！");
                gadabout.birthcommnet(gadabout);
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