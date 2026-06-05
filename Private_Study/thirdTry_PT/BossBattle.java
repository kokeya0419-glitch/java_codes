package Private_Study.secondTry;

import java.util.Scanner;

public class BossBattle {
    public boolean battleStart(Hero h, Monster m) {
        Scanner sc = new Scanner(System.in);
        System.out.println("----------");
        SlowPoint.moreSlowPoint("ボスの'" + m.getName() + "'が現れた！");

        while (h.getHp() > 0 && m.getHp() > 0) {
            if (h.getSpeed() >= m.getSpeed()) {
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
                    SlowPoint.slowPoint(m.getName() + "を倒した！");
                    h.addExp(m.getExp());
                    h.levelUpCheck();
                    return true;
                }

                System.out.println("----------");
                SlowPoint.slowPoint(m.getName() + "のターン！");
                int fortune = (int) (Math.random() * 100) + 1;
                if (fortune < 51) {
                    m.attack(h);
                } else if (fortune < 76) {
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
                SlowPoint.slowPoint(m.getName() + "のターン！");
                int fortune = (int) (Math.random() * 100) + 1;
                if (fortune < 51) {
                    m.attack(h);
                } else if (fortune < 76) {
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
                    SlowPoint.slowPoint(m.getName() + "を倒した！");
                    h.addExp(m.getExp());
                    h.levelUpCheck();
                    return true;
                }
            }
        }
        return false;
    }
}
