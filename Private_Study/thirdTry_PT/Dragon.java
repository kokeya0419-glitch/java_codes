package Private_Study.thirdTry_PT;

public class Dragon extends Monster {
    public Dragon(String name) {
        this.setName(name);

        this.setHp((this.getHp() + 200) + (int) (Math.random() * 25));
        this.setMaxHp(this.getHp());
        this.setMp((this.getMp() + 10) + (int) (Math.random() * 10));
        this.setMaxMp(this.getMaxMp());
        this.setPower((this.getPower() + 45) + (int) (Math.random() * 10));
        this.setDefend((this.getDefend() + 40) + (int) (Math.random() * 5));
        this.setSpeed((this.getSpeed() + 40) + (int) (Math.random() * 5));
        this.setIntelligence((this.getIntelligence() + 10) + (int) (Math.random() * 3));
        this.setExp((this.getExp() + 100) + (int) (Math.random() * 25));
    }

    public void breath(Party party) {
        SlowPoint.moreSlowPoint(this.getName() + "は \"炎のブレス\" を吐いた！");
        for (Protagonist member : party.getMembers()) {
            if (member.getHp() <= 0) {
                continue;
            }
            int damage = (this.getPower() + this.getIntelligence() + (int) (Math.random() * 10) + 1) / 2
                    - member.getDefend() / 4;
            if (damage < 1) {
                damage = 1;
            }
            member.setHp(member.getHp() - damage);
            SlowPoint.slowPoint(member.getName() + "に" + damage + "のダメージ！");
            if (member.getHp() <= 0) {
                SlowPoint.slowPoint(member.getName() + "は、力尽きた・・・");
            }

        }
    }
}
