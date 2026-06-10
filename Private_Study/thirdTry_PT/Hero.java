package Private_Study.thirdTry_PT;

public class Hero extends Protagonist {
    Hero(String name) {
        this.setName(name);
        this.setLevel(this.getLevel());

        this.setHp((this.getHp() + 35) + (int) (Math.random() * 10));
        this.setMaxHp(getHp());
        this.setMp((this.getMp() + 3) + (int) (Math.random() * 5));
        this.setMaxMp(this.getMp());
        this.setPower((this.getPower() + 23) + (int) (Math.random() * 15));
        this.setDefend((this.getDefend() + 15) + (int) (Math.random() * 10));
        this.setSpeed((this.getSpeed() + 15) + (int) (Math.random() * 10));
        this.setIntelligence((this.getIntelligence() + 10) + (int) (Math.random() * 5));
    }

    public void birthComment(Hero h) {
        SlowPoint.slowPoint("あなたのステータスはこのようになりました。\n" +
                "HP：" + h.getMaxHp() + "\n" +
                "MP： " + h.getMaxMp() + "\n" +
                "力：" + h.getPower() + "\n" +
                "守り：" + h.getDefend() + "\n" +
                "素早さ：" + h.getSpeed() + "\n" +
                "賢さ" + h.getIntelligence());
    }

    // LVアップ
    public void levelUp() {
        this.setLevel(this.getLevel() + 1);

        this.setMaxHp(this.getMaxHp() + (int) (Math.random() * 5) + 1);
        this.setMaxMp(this.getMaxMp() + (int) (Math.random() * 5) + 1);
        this.setPower(this.getPower() + (int) (Math.random() * 5) + 1);
        this.setDefend(this.getDefend() + (int) (Math.random() * 5) + 1);
        this.setSpeed(this.getSpeed() + (int) (Math.random() * 5) + 1);
        this.setIntelligence(this.getIntelligence() + (int) (Math.random() * 5) + 1);

        this.setHp(this.getMaxHp());
        this.setMp(this.getMaxMp());
        this.setNextExp(this.getLevel() * 15);

        SlowPoint.moreSlowPoint(
                this.getName() + "は、レベルアップした！\n" +
                        "Lv." + this.getLevel() + "になった！\n" +
                        "体力と魔力が全回復した！\n");
        this.learnSkillByLevel();
    }

    public void learnSkillByLevel() {
        if (this.getLevel() == 2) {
            Skill newSkill = new Skill("居合切り", 15, 1);
            this.learnPhysicalSkill(newSkill);
        }

        if(this.getLevel() == 3){
            Skill newSkill = new Skill("ポイミ", 25, 3);
            this.learnHealSkill(newSkill);
        }
{}
        if (this.getLevel() == 5) {
            Skill newSkill = new Skill("ブレイクショット", 30, 3);
            this.learnPhysicalSkill(newSkill);
        }
    }

}