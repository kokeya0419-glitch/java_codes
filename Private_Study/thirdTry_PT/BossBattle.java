package Private_Study.thirdTry_PT;

import java.util.ArrayList;
import java.util.Scanner;

public class BossBattle {
    public boolean battleStart(Party party, Monster m) {
        Scanner sc = new Scanner(System.in);
        System.out.println("====================");
        SlowPoint.moreSlowPoint("ボスの'" + m.getName() + "'が現れた！");

        while (party.isAlive() && m.getHp() > 0) {
            ArrayList<Biology> turnOrder = new ArrayList<>();
            for (Protagonist member : party.getMembers()) {
                if (member.getHp() > 0) {
                    turnOrder.add(member);
                }
            }
            if (m.getHp() > 0) {
                turnOrder.add(m);
            }

            turnOrder.sort((a, b) -> b.getSpeed() - a.getSpeed());

            for (Biology actor : turnOrder) {
                if (actor.getHp() <= 0) {
                    continue;
                }
                if (!party.isAlive() || m.getHp() <= 0) {
                    break;
                }

                if (actor instanceof Protagonist) {
                    Protagonist member = (Protagonist) actor;
                    System.out.println("====================");
                    System.out.println("体力：" + member.getHp() + "　" + "魔力：" + member.getMp());
                    SlowPoint.slowPoint(member.getName() + "のターン！\n" + "行動を選択してください");
                    System.out.println("--------------------");
                    SlowPoint.slowPoint("体力：" + member.getHp() + "　" + "魔力：" + member.getMp() + "\n" +
                                        "１：たたかう　" + "２：とくぎ　" + "３：回復　" + "４：道具　" + "5：逃げる");
                    int selectMove;

                    while (true) {
                        try {
                            selectMove = sc.nextInt();
                            if (selectMove >= 1 && selectMove <= 5) {
                                break;
                            }
                            SlowPoint.slowPoint("1～5を入力してください！");
                        } catch (Exception e) {
                            SlowPoint.slowPoint("半角数字で入力してください。");
                            sc.next();
                        }
                    }

                    switch (selectMove) {
                        case 1 -> member.attack(m);
                        case 2 -> member.skills(party, m);
                        case 3 -> member.heal();
                        case 4 -> member.useItem();
                        case 5 -> {
                            if (member.tryEscape()) {
                                return false;
                            }
                        }
                    }

                    if (m.getHp() <= 0) {
                        SlowPoint.slowPoint(m.getName() + "を倒した！");
                        for (Protagonist mb : party.getMembers()) {
                            if (mb.getHp() > 0) {
                                mb.addExp(m.getExp());
                                mb.levelUpCheck();
                            }
                        }
                        return true;
                    }
                } else if (actor instanceof Monster) {
                    Monster boss = (Monster) actor;
                    Protagonist target = party.getRandomAliveMember();
                    System.out.println("====================");
                    SlowPoint.slowPoint(boss.getName() + "のターン！");
                    int fortune = (int) (Math.random() * 100) + 1;
                    if (fortune < 46) {
                        boss.attack(target);
                        if(target.getHp() <= 0){
                            SlowPoint.moreSlowPoint(target.getName() + "は、力尽きた・・・");
                        }
                    } else if (fortune < 66) {
                        boss.heal();
                    } else {
                        ((Dragon) boss).breath(party);
                    }
                    if (!party.isAlive()) {
                        SlowPoint.slowPoint("パーティは全滅してしまった・・・");
                        return false;
                    }
                }
            }
        }
        return false;
    }
}
