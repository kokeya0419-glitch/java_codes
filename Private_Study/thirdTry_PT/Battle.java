package Private_Study.secondTry;

import java.util.Scanner;

public class Battle {
    public boolean battleStart(Hero h, Monster m) {
        Scanner sc = new Scanner(System.in);
        System.out.println("----------");
        SlowPoint.slowPoint(m.getName() + "が現れた！");

        while (h.getHp() > 0 && m.getHp() > 0) {
            if (h.getSpeed() >= m.getSpeed()) {
                System.out.println("----------");
                System.out.println("体力：" + h.getHp() + "　" + "魔力：" + h.getMp());
                SlowPoint.slowPoint(h.getName() + "のターン！\n" + "行動を選択してください\n" +
                        "１；戦う　" + "２：特技　" + "３：回復　" + "４：道具　" + "5：逃げる");
                int selectMove;

                while (true) {
                    selectMove = sc.nextInt();
                    if (selectMove >= 1 && selectMove <= 5) {
                        break;
                    }else{
                        sc.next(); //文字列は妻女する
                    }
                    SlowPoint.slowPoint("1～5を入力してください！");
                }

                switch (selectMove) {
                    case 1 -> {
                        h.attack(m);
                    }
                    case 2 -> {
                        h.skills(m);
                    }
                    case 3 -> {
                        h.heal();

                    }
                    case 4 -> {
                        h.useItem();
                    }
                    case 5 -> {
                        h.escape();
                        return false;
                    }
                }
                if (m.getHp() <= 0) {
                    h.addExp(m.getExp());
                    SlowPoint.slowPoint(m.getName() + "を倒した！\n");
                    SlowPoint.slowPoint(m.getExp() + "の経験値を得た");
                    h.levelUpCheck();
                    return true;
                }

                System.out.println("----------");
                SlowPoint.slowPoint(m.getName() + "の攻撃！");
                int fortune = (int) (Math.random() * 100) + 1;
                if (fortune < 76) {
                    m.attack(h);
                } else if (fortune < 96) {
                    m.heal();
                } else if (fortune <= 100) {
                    m.tryEscape();
                }
                if (h.getHp() <= 0) {
                    SlowPoint.slowPoint(h.getName() + "は倒された・・・目の前が真っ暗になった・・・");
                    return false;
                }
            }

            if (h.getSpeed() < m.getSpeed()) {
                System.out.println("----------");
                SlowPoint.slowPoint(m.getName() + "の攻撃！");
                int fortune = (int) (Math.random() * 100) + 1;
                if (fortune < 76) {
                    m.attack(h);
                } else if (fortune < 96) {
                    m.heal();
                } else if (fortune <= 100) {
                    m.tryEscape();
                }
                if (h.getHp() <= 0) {
                    SlowPoint.slowPoint(h.getName() + "は倒された・・・目の前が真っ暗になった・・・");
                    return false;
                }

                System.out.println("----------");
                System.out.println("体力：" + h.getHp() + "　" + "魔力：" + h.getMp());
                SlowPoint.slowPoint(h.getName() + "のターン！\n" + "行動を選択してください\n" +
                        "１；戦う　" + "２：特技　" + "３：回復　" + "４：道具　" + "5：逃げる");
                int selectMove = sc.nextInt();

                switch (selectMove) {
                    case 1 -> {
                        h.attack(m);
                    }
                    case 2 -> {
                        h.skills(m);
                    }
                    case 3 -> {
                        h.heal();
                    }
                    case 4 -> {
                        h.useItem();
                    }
                    case 5 -> {
                        h.escape();
                        return false;
                    }
                }
                if (m.getHp() <= 0) {
                    h.addExp(m.getExp());
                    SlowPoint.slowPoint(m.getName() + "を倒した！");
                    SlowPoint.slowPoint(m.getExp() + "の経験値を得た\n");
                    h.levelUpCheck();
                    return true;
                }
            }
        }
        return false;
    }
}
