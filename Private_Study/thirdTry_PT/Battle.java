package Private_Study.thirdTry_PT;

import java.util.ArrayList;
import java.util.Scanner;

public class Battle {
    public boolean battleStart(Party party, MonsterGroup mg) {
        Scanner sc = new Scanner(System.in);
        int selectMove;
        System.out.println("====================");
        SlowPoint.slowPoint("魔物の群れが現れた！");

        // モンスターのランダム生成
        mg.clear();
        int monsterNum = (int) (Math.random() * 3) + 1;
        MonsterSelect ms = new MonsterSelect();
        for (int i = 0; i < monsterNum; i++) {
            mg.addMonster(ms.randomChoice());
        }

        // モンスター名表示
        SlowPoint.slowPoint(mg.getMonsterNames());

        while (party.isAlive() && mg.isAlive()) {
            // 戦闘順を決める配列の生成
            ArrayList<Biology> turnOrder = new ArrayList<>();
            for (Protagonist member : party.getMembers()) {
                if (member.getHp() > 0) {
                    turnOrder.add(member);
                }
            }
            for (Monster m : mg.getMonsters()) {
                if (m.getHp() > 0) {
                    turnOrder.add(m);
                }
            }

            turnOrder.sort((a, b) -> b.getSpeed() - a.getSpeed());

            for (Biology actor : turnOrder) {
                if (actor.getHp() <= 0) {
                    continue;
                }
                if (!party.isAlive() || !mg.isAlive()) {
                    break;
                }

                if (actor instanceof Protagonist) {
                    Protagonist member = (Protagonist) actor;

                    System.out.println("====================");
                    SlowPoint.slowPoint(member.getName() + "のターン！\n" + "行動を選択してください");
                    System.out.println("--------------------");
                    SlowPoint.slowPoint("体力：" + member.getHp() + "　" + "魔力：" + member.getMp() + "\n" +
                            "１：たたかう　" + "２：とくぎ　" + "３：回復　" + "４：道具　" + "5：逃げる");
                    while (true) {
                        try {
                            selectMove = sc.nextInt();
                            if (selectMove >= 1 && selectMove <= 5) {
                                break;
                            }
                            SlowPoint.slowPoint("1～5を入力してください！");
                        } catch (Exception e) {
                            SlowPoint.slowPoint("半角数字で入力してください。");
                            sc.next(); // 文字列は排除する
                        }
                    }

                    Monster targetMonster = mg.getRandomMonster();
                    switch (selectMove) {
                        case 1 -> member.attack(targetMonster);
                        case 2 -> member.skills(party, targetMonster);
                        case 3 -> member.heal();
                        case 4 -> member.useItem();
                        case 5 -> {
                            if (member.tryEscape()) {
                                return false;
                            }
                        }
                    }

                    if (targetMonster.getHp() <= 0) {
                        SlowPoint.slowPoint(targetMonster.getName() + "を倒した！\n");
                    }

                    if (!mg.isAlive()) {
                        SlowPoint.slowPoint("魔物の群れを倒した！\n");
                        SlowPoint.slowPoint(mg.getTotallExp() + "の経験値を得た");
                        System.out.println("--------------------");
                        for (Protagonist mb : party.getMembers()) {
                            if (mb.getHp() > 0) {
                                mb.addExp(mg.getTotallExp());
                            }
                        }
                        for (Protagonist mb : party.getMembers()) {
                            if (mb.getHp() > 0) {
                                mb.levelUpCheck();
                            }
                        }
                        return true;
                    }

                    // 敵の行動
                } else if (actor instanceof Monster) {
                    Monster monster = (Monster) actor;
                    Protagonist target = party.getRandomAliveMember();

                    System.out.println("====================");
                    SlowPoint.slowPoint(monster.getName() + "のターン！");

                    int fortune = (int) (Math.random() * 100) + 1;
                    if (fortune < 76) {
                        monster.attack(target);
                        if(target.getHp() <= 0){
                            SlowPoint.moreSlowPoint(target.getName() + "は、力尽きた・・・");
                        }
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