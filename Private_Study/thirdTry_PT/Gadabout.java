package Private_Study.thirdTry_PT;

public class Gadabout extends Protagonist {
    public Gadabout(String name) {
        this.setName(name);

        this.setMaxHp((this.getMaxHp() + 25) + (int) (Math.random() * 5));
        this.setHp(getMaxHp());
        this.setMaxMp((this.getMaxMp() + 5) + (int) (Math.random() * 5));
        this.setMp(this.getMaxMp());
        this.setPower((this.getPower() + 15) + (int) (Math.random() * 5));
        this.setDefend((this.getDefend() + 15) + (int) (Math.random() * 10));
        this.setSpeed((this.getSpeed() + 15) + (int) (Math.random() * 5));
        this.setIntelligence((this.getIntelligence() + 10) + (int) (Math.random() * 5));
    }

    public void birthComment(Protagonist g) {
        SlowPoint.slowPoint("あなたのステータスはこのようになりました。\n" +
                "HP：" + g.getMaxHp() + "\n" +
                "MP： " + g.getMaxMp() + "\n" +
                "力：" + g.getPower() + "\n" +
                "守り：" + g.getDefend() + "\n" +
                "素早さ：" + g.getSpeed() + "\n" +
                "賢さ" + g.getIntelligence());
    }

    // LVアップ
    public void levelUp() {
        this.setLevel(this.getLevel() + 1);

        this.setMaxHp(this.getMaxHp() + (int) (Math.random() * 3) + 1);
        this.setMaxMp(this.getMaxMp() + (int) (Math.random() * 3) + 1);
        this.setPower(this.getPower() + (int) (Math.random() * 3) + 1);
        this.setDefend(this.getDefend() + (int) (Math.random() * 3) + 1);
        this.setSpeed(this.getSpeed() + (int) (Math.random() * 3) + 1);
        this.setIntelligence(this.getIntelligence() + (int) (Math.random() * 3) + 1);

        this.setHp(this.getMaxHp());
        this.setMp(this.getMaxMp());
        this.setNextExp(this.getLevel() * 20);

        SlowPoint.moreSlowPoint(
                this.getName() + "は、レベルアップした！\n" +
                        "Lv." + this.getLevel() + "になった！\n" +
                        "体力と魔力が全回復した！\n");
        this.learnSkillByLevel();
    }

    public void learnSkillByLevel() {
        if (this.getLevel() == 3) {
            this.learnPhysicalSkill(new Skill("変な踊り", 10, 1));
        }

        if (this.getLevel() == 5) {
            this.learnPhysicalSkill(new Skill("悪ふざけ", 25, 3));
        }

        if (this.getLevel() == 8) {
            this.learnPhysicalSkill(new Skill("奇跡の一発芸", 60, 5));
        }
    }
}