package Private_Study.thirdTry_PT;

import java.util.ArrayList;

public class Party {
    private ArrayList<Protagonist> members = new ArrayList();

    // メンバー追加メソッド
    public void addMember(Protagonist member) {
        members.add(member);
    }

    public ArrayList<Protagonist> getMembers() {
        return this.members;
    }

    public void showParty() {
        SlowPoint.slowPoint("====================\n" +
                "【パーティーメンバー】\n" +
                "====================");
        for (Protagonist member : members) {
            System.out.println("名前：" + member.getName() + "　" + "Lv：" + member.getLevel() + "\n" +
                    "体力：" + member.getHp() + "/" + member.getMaxHp() + "\n" +
                    "魔力：" + member.getMp() + "/" + member.getMaxMp() + "\n");
        }
    }

    public void showMemberDetail(int index) {
        Protagonist member = members.get(index);

        System.out.println("名前：" + member.getName() + "　" + "Lv：" + member.getLevel() + "\n" +
                "　体力：" + member.getHp() + "/" + member.getMaxHp() + "\n" +
                "　魔力：" + member.getMp() + "/" + member.getMaxMp() + "\n" +
                "　　力：" + member.getPower() + "\n" +
                "　守り：" + member.getDefend() + "\n" +
                "素早さ：" + member.getSpeed() + "\n" +
                "　賢さ：" + member.getIntelligence() + "\n");
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
}