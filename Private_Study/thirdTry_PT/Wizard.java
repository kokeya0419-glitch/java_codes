package Private_Study.thirdTry_PT;

public class Wizard extends Protagonist {
    public Wizard(String name){
        this.setName(name);

        this.setMaxHp((this.getMaxHp() + 30) + (int)(Math.random() * 10));
        this.setHp(getMaxHp());
        this.setMaxMp((this.getMaxMp() + 10) + (int)(Math.random() * 5));
        this.setMp(this.getMaxMp());
        this.setPower((this.getPower() + 15) + (int)(Math.random() * 5));
        this.setDefend((this.getDefend() + 10) + (int)(Math.random() * 10));
        this.setSpeed((this.getSpeed() + 10) + (int)(Math.random() * 5));
        this.setIntelligence((this.getIntelligence() + 20) + (int)(Math.random() * 5));
    }

    public void birthComment(Protagonist w) {
        SlowPoint.slowPoint("あなたのステータスはこのようになりました。\n" +
                "HP：" + w.getMaxHp() + "\n" +
                "MP： " + w.getMaxMp() + "\n" +
                "力：" + w.getPower() + "\n" +
                "守り：" + w.getDefend() + "\n" +
                "素早さ：" + w.getSpeed() + "\n" +
                "賢さ" + w.getIntelligence());
    }

    // LVアップ
    public void levelUp() {
        this.setLevel(this.getLevel() + 1);

        this.setMaxHp(this.getMaxHp() + (int) (Math.random() * 3) + 1);
        this.setMaxMp(this.getMaxMp() + (int) (Math.random() * 5) + 1);
        this.setPower(this.getPower() + (int) (Math.random() * 3) + 1);
        this.setDefend(this.getDefend() + (int) (Math.random() * 3) + 1);
        this.setSpeed(this.getSpeed() + (int) (Math.random() * 5) + 1);
        this.setIntelligence(this.getIntelligence() + (int) (Math.random() * 5) + 1);

        this.setHp(this.getMaxHp());
        this.setMp(this.getMaxMp());
        this.setNextExp(this.getLevel() * 19);

        SlowPoint.moreSlowPoint(
                this.getName() + "は、レベルアップした！\n" +
                        "Lv." + this.getLevel() + "になった！\n" +
                        "体力と魔力が全回復した！\n");
        this.learnSkillByLevel();
    }

    public void learnSkillByLevel() {
        if (this.getLevel() == 2) {
            Skill newSkill = new Skill("火の玉", 50, 3);
            this.learnMagicSkill(newSkill);
        }

        if (this.getLevel() == 4) {
            Skill newSkill = new Skill("落雷", 75, 5);
            this.learnMagicSkill(newSkill);
        }
    }
}