package Private_Study.thirdTry_PT;

import java.util.ArrayList;
import java.util.Scanner;

public class Battle {
    public boolean battleStart(Party party, Monster m) {
        Scanner sc = new Scanner(System.in);
        int selectMove;
        System.out.println("----------");
        SlowPoint.slowPoint(m.getName() + "が現れた！");

        System.out.println("パーティ人数：" + party.size());
        party.showParty();

        while (party.isAlive() && m.getHp() > 0) {
            // 戦闘順を決める配列の生成
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

                    System.out.println("----------");
                    System.out.println("体力：" + member.getHp() + "　" + "魔力：" + member.getMp());
                    SlowPoint.slowPoint(member.getName() + "のターン！\n" + "行動を選択してください\n" +
                            "１；戦う　" + "２：特技　" + "３：回復　" + "４：道具　" + "5：逃げる");
                    while (true) {
                        selectMove = sc.nextInt();
                        if (selectMove >= 1 && selectMove <= 5) {
                            break;
                        } else {
                            sc.next(); // 文字列は排除する
                        }
                        SlowPoint.slowPoint("1～5を入力してください！");
                    }

                    switch (selectMove) {
                        case 1 -> member.attack(m);
                        case 2 -> member.skills(m);
                        case 3 -> member.heal();
                        case 4 -> member.useItem();
                        case 5 -> {
                            if (member.tryEscape()) {
                                return false;
                            }
                        }
                    }

                    if (m.getHp() <= 0) {
                        for (Protagonist mb : party.getMembers()) {
                            if (mb.getHp() > 0) {
                                mb.addExp(m.getExp());
                                mb.levelUpCheck();
                            }
                        }
                        SlowPoint.slowPoint(m.getName() + "を倒した！\n");
                        SlowPoint.slowPoint(m.getExp() + "の経験値を得た");
                        return true;
                    }

                    // 敵の行動
                } else if (actor instanceof Monster) {
                    Monster monster = (Monster) actor;
                    Protagonist target = party.getRandomAliveMember();

                    System.out.println("----------");
                    SlowPoint.slowPoint(monster.getName() + "の攻撃！");

                    int fortune = (int) (Math.random() * 100) + 1;
                    if (fortune < 76) {
                        monster.attack(target);
                    } else if (fortune < 96) {
                        monster.heal();
                    } else {
                        if (monster.tryEscape()) {
                            return false;
                        }
                    }
                    if (!party.isAlive()) {
                        SlowPoint.moreSlowPoint("パーティは全滅してしまった・・・");
                        return false;
                    }
                }
            }
        }
        return false;
    }
}
