package Private_Study.thirdTry_PT;

import java.util.ArrayList;
import java.util.Scanner;

abstract public class Protagonist extends Biology {
    private String type = "human";
    private String moveName;
    private int movePower;
    private int movePoint;
    private int nextExp = 10;
    private ArrayList<Skill> skills = new ArrayList<>();

    public void attack(MonsterGroup mg) {
        int attackDamage = ((this.getPower() / 2) - (mg.getDefend() / 4) + (int) (Math.random() * 10) + 1);
        if (attackDamage < 1) {
            attackDamage = 1;
        }
        SlowPoint.slowPoint(this.getName() + "の攻撃\n" + attackDamage + "のダメージを与えた");
        mg.setHp(mg.getHp() - attackDamage);
    }

    public void guard(Monster m) {
        int guardPoint = this.getDefend();
    }

    public void heal() {
        int newMp = this.getMp() - 2;
        if (newMp < 0) {
            SlowPoint.slowPoint("MPが足りない！");
            return;
        }
        this.setMp(newMp);
        int healPoint = (this.getMp() + this.getIntelligence() + (int) (Math.random() * 5));
        int newHp = this.getHp() + healPoint;
        if (newHp > this.getMaxHp()) {
            newHp = this.getMaxHp();
        }
        this.setHp(newHp);
        SlowPoint.slowPoint(this.getName() + "は、瞑想した...\n" + healPoint + "ポイント回復した！");
    }

    public void useItem() {
        int fortune = (int) (Math.random() * 2);
        if (fortune == 0) {
            int heal = (this.getMaxHp() * 5) / 10;
            SlowPoint.slowPoint("奇跡のポーションだ！\n" + "HPを" + heal + "ポイント回復した。");
            int newHp = this.getHp() + heal;
            if (newHp > this.getMaxHp()) {
                newHp = this.getMaxHp();
            }
            this.setHp(newHp);
        } else if (fortune == 1) {
            int poison = (this.getHp() * 5) / 10;
            SlowPoint.moreSlowPoint("これは毒のポーションだ・・・！\n" + "HPが" + poison + "ポイント失われた！");
            this.setHp(this.getHp() - poison);
        }
    }

    public boolean tryEscape() {
        int fortune = (int) (Math.random() * 100);
        if (fortune > 79) {
            SlowPoint.moreSlowPoint(this.getName() + "は、街まで逃げ出した・・・");
            System.out.println("--------------------");
            return true;
        }

        SlowPoint.slowPoint(this.getName() + "は逃げようとしたが失敗した。");
        return false;
    }

    public void physicalSkills(MonsterGroup mg) {
        if (skills.size() == 0) {
            SlowPoint.slowPoint("覚えている技がありません。");
            return;
        }

        SlowPoint.slowPoint("使用する特技を選択してください。");
        for (int i = 0; i < skills.size(); i++) {
            Skill skill = skills.get(i);
            System.out.println((i + 1) + "： " + skill.getName() + "　MP：" + skill.getCost());
        }
        Scanner sc = new Scanner(System.in);
        int selectSkill = sc.nextInt();
        Skill skill = skills.get(selectSkill - 1);

        if (this.getMp() < skill.getCost()) {
            SlowPoint.slowPoint("MPが足りない！");
            return;
        }

        this.setMp(this.getMp() - skill.getCost());

        int damage = (skill.getPower() + this.getPower() + (int) (Math.random() * 5 + 1)) / 2 - mg.getDefend() / 4
                + (int) (Math.random() * 10);
        if (damage < 1) {
            damage = 1;
        }
        mg.setHp(mg.getHp() - damage);
        SlowPoint.slowPoint(this.getName() + "の" + skill.getName() + "!!!\n" +
                damage + "ダメージを与えた！");
    }

    public void magicSkills(MonsterGroup mg) {
        if (skills.size() == 0) {
            SlowPoint.slowPoint("覚えている技がありません。");
            return;
        }

        SlowPoint.slowPoint("使用する特技を選択してください。");
        for (int i = 0; i < skills.size(); i++) {
            Skill skill = skills.get(i);
            System.out.println((i + 1) + "： " + skill.getName() + "　MP：" + skill.getCost());
        }
        Scanner sc = new Scanner(System.in);
        int selectSkill = sc.nextInt();
        Skill skill = skills.get(selectSkill - 1);

        if (this.getMp() < skill.getCost()) {
            SlowPoint.slowPoint("MPが足りない！");
            return;
        }

        this.setMp(this.getMp() - skill.getCost());

        int magicDamage = (skill.getPower() + this.getIntelligence() + (int) (Math.random() * 5 + 1)) / 2 - mg.getDefend() / 4
                + (int) (Math.random() * 10);
        if (magicDamage < 1) {
            magicDamage = 1;
        }
        mg.setHp(mg.getHp() - magicDamage);
        SlowPoint.slowPoint(this.getName() + "の" + skill.getName() + "!!!\n" +
                magicDamage + "ダメージを与えた！");
    }

    public void learnSkill(Skill skill) {
        skills.add(skill);
        SlowPoint.moreSlowPoint(this.getName() + "は" + skill.getName() + "を覚えた！");
    }

    public ArrayList<Skill> getSkills() {
        return skills;
    }

    public void addExp(int exp) {
        int newExp = this.getExp() + exp;
        this.setExp(newExp);
    }

    public void levelUpCheck() {
        while (this.getExp() >= this.nextExp) {
            this.setExp(this.getExp() - nextExp);
            this.levelUp();
        }
    }

    //LVアップ
    public void levelUp() {
        this.setLevel(this.getLevel() + 1);

        this.setMaxHp(this.getMaxHp() + (int) (Math.random() * 5) + 1);
        this.setPower(this.getPower() + (int) (Math.random() * 3) + 1);
        this.setDefend(this.getDefend() + (int) (Math.random() * 3) + 1);
        this.setSpeed(this.getSpeed() + (int) (Math.random() * 3) + 1);
        this.setIntelligence(this.getIntelligence() + (int) (Math.random() * 3) + 1);

        this.setHp(this.getMaxHp());
        this.setMp(this.getMaxMp());
        this.nextExp += this.getLevel() * 10;

        SlowPoint.moreSlowPoint(
                this.getName() + "は、レベルアップした！\n" +
                        "Lv." + this.getLevel() + "になった！\n" +
                        "体力と魔力が全回復した！\n");
        this.learnSkillByLevel();
    }

    //各種族ごとに覚える特技の設定
    public void learnSkillByLevel() {
    }

    // 生成時にステータス表示
    public void birthComment() {
        SlowPoint.slowPoint("あなたのステータスはこのようになりました。\n" +
                "HP：" + this.getMaxHp() + "\n" +
                "MP： " + this.getMaxMp() + "\n" +
                "力：" + this.getPower() + "\n" +
                "守り：" + this.getDefend() + "\n" +
                "素早さ：" + this.getSpeed() + "\n" +
                "賢さ：" + this.getIntelligence());
    }

    public void Specialty() {
        this.setMoveName(moveName);
        this.setMovePower(movePower);
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void setMoveName(String name) {
        this.moveName = name;
    }

    public String getMoveName() {
        return this.moveName;
    }

    public void setMovePower(int power) {
        this.movePower = power;
    }

    public int getMovePower() {
        return this.movePower;
    }

    public void setMovePoint(int point) {
        this.movePoint = point;
    }

    public int getMovePoint() {
        return this.movePoint;
    }
}
