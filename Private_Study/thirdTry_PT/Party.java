package Private_Study.thirdTry_PT;

import java.util.ArrayList;
import java.util.Scanner;

public class Party {
    private ArrayList<Protagonist> members = new ArrayList();
            Scanner sc = new Scanner(System.in);

    // パーティ確認
    public void showParty() {
        SlowPoint.slowPoint("====================\n" +
                "【パーティーメンバー】\n" +
                "====================");
        for (int i = 0; i < members.size(); i++) {
            Protagonist member = members.get(i);
            System.out.println((i + 1) + "\n" + "名前：" + member.getName() + "　" + "Lv：" + member.getLevel() + "\n" +
                    "体力：" + member.getHp() + "/" + member.getMaxHp() + "\n" +
                    "魔力：" + member.getMp() + "/" + member.getMaxMp() + "\n");
        }
    }

    // パーティ詳細
    public void showMemberDetail(int index) {
        Protagonist member = members.get(index);

        System.out.println("名前：" + member.getName() + "　" + "Lv：" + member.getLevel() + "\n" +
                "　体力：" + member.getHp() + "/" + member.getMaxHp() + "\n" +
                "　魔力：" + member.getMp() + "/" + member.getMaxMp() + "\n" +
                "　　力：" + member.getPower() + "\n" +
                "　守り：" + member.getDefend() + "\n" +
                "素早さ：" + member.getSpeed() + "\n" +
                "　賢さ：" + member.getIntelligence() + "\n");
        System.out.println("====================");

        SlowPoint.slowPoint("1:確認完了");
        while (true) {
            try {
                index = sc.nextInt();
                if (index >= 1 && index <= 1) {
                    break;
                }
                SlowPoint.slowPoint("確認が出来たら1を入力してください！");
            } catch (Exception e) {
                SlowPoint.slowPoint("半角数字で入力してください。");
                sc.next(); // 文字列は排除する
            }
        }
    }

    // PT全員のHPとMPが回復しているかをチェックする。
    public boolean isAllRecovered() {
        for (Protagonist member : members) {
            if (member.getHp() < member.getMaxHp() || member.getMp() < member.getMaxMp()) {
                return false;
            }
        }
        return true;
    }

    // pt回復
    public void recoverAll() {
        for (Protagonist member : members) {
            member.setHp(member.getMaxHp());
            member.setMp(member.getMaxMp());
        }
    }

    // PT人数の取得
    public int size() {
        return members.size();
    }

    // PT上限に達している
    public boolean isFull() {
        SlowPoint.slowPoint("現在のパーティの人数：" + members.size());
        return members.size() >= 3;
    }

    // パーティー生存確認
    public boolean isAlive() {
        for (Protagonist member : members) {
            if (member.getHp() > 0) {
                return true;
            }
        }
        return false;
    }

    // 生存しているメンバー格納
    public Protagonist getRandomAliveMember() {
        ArrayList<Protagonist> aliveMembers = new ArrayList<>();
        for (Protagonist member : members) {
            if (member.getHp() > 0) {
                aliveMembers.add(member);
            }
        }

        int index = (int) (Math.random() * aliveMembers.size());
        return aliveMembers.get(index);
    }

    // メンバー追加メソッド
    public void addMember(Protagonist member) {
        members.add(member);
    }

    public ArrayList<Protagonist> getMembers() {
        return this.members;
    }
}