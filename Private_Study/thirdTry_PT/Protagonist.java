package Private_Study.thirdTry_PT;

import java.util.ArrayList;
import java.util.Scanner;

abstract public class Protagonist extends Biology {
    private String type = "human";
    private String moveName;
    private int movePower;
    private int movePoint;
    private int nextExp = 15;
    private ArrayList<Skill> skills = new ArrayList<>();
    private ArrayList<Skill> physicalSkills = new ArrayList<>();
    private ArrayList<Skill> magicSkills = new ArrayList<>();
    private ArrayList<Skill> healSkills = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    // 攻撃行動
    public void attack(Monster m) {
        int attackDamage = ((this.getPower() / 2) - (m.getDefend() / 4) + (int) (Math.random() * 10) + 1);
        if (attackDamage < 1) {
            attackDamage = 1;
        }
        SlowPoint.slowPoint(this.getName() + "の攻撃\n" + 
        m.getName() + "に" + attackDamage + "のダメージを与えた");
        m.setHp(m.getHp() - attackDamage);
    }

    // 回復行動
    public void heal() {
        int newMp = this.getMp() - 2;
        if (newMp < 0) {
            SlowPoint.slowPoint("MPが足りない！");
            return;
        }
        this.setMp(newMp);
        int healPoint = (this.getHp() + this.getIntelligence() + (int) (Math.random() * 5) / 5);
        int newHp = this.getHp() + healPoint;
        if (newHp > this.getMaxHp()) {
            newHp = this.getMaxHp();
        }
        this.setHp(newHp);
        SlowPoint.slowPoint(this.getName() + "は、瞑想した...\n" + healPoint + "ポイント回復した！");
    }

    // アイテム
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

    // 逃げる判定
    public boolean tryEscape() {
        int fortune = (int) (Math.random() * 100);
        if (fortune > 79) {
            SlowPoint.moreSlowPoint(this.getName() + "は、街まで逃げ出した・・・");
            System.out.println("====================");
            return true;
        }

        SlowPoint.slowPoint(this.getName() + "は逃げようとしたが失敗した。");
        return false;
    }

    //特技の選択
    public void skills(Party party, Monster m) {
        while (true) {
            int select;
            SlowPoint.slowPoint("特技選択\n" + "1:物理攻撃　2:魔法攻撃　3:回復魔法　0:戻る");

            while (true) {
                select = sc.nextInt();
                if (select >= 0 && select <= 3) {
                    break;
                } else {
                    sc.next(); // 文字列は排除する
                }
                SlowPoint.slowPoint("0～3を入力してください!");
            }
            
            switch(select){
                case 0 -> {
                    return;
                }
                case 1 -> {
                    if (this.physicalSkills(m)) {
                        return;
                    }
                }
                case 2 -> {
                    if (this.magicSkills(m)) {
                        return;
                    }
                }
                case 3 -> {
                    if (this.healSkills(party)) {
                        return;
                    }
                }
            }
        }
    }

    // 物理系特技を使う
    public boolean physicalSkills(Monster m) {
        if (physicalSkills.size() == 0) {
            SlowPoint.slowPoint("覚えている技がありません。");
            return false;
        }

        SlowPoint.slowPoint("使用する特技を選択してください。");
        for (int i = 0; i < physicalSkills.size(); i++) {
            Skill skill = physicalSkills.get(i);
            System.out.println((i + 1) + "： " + skill.getName() + "　MP：" + skill.getCost());
        }
        System.out.println("0： 戻る");
        int selectSkill;
        int max = physicalSkills.size();

        while (true) {
                selectSkill = sc.nextInt();
                if (selectSkill >= 0 && selectSkill <= max) {
                    break;
                } else {
                    sc.next(); // 文字列は排除する
                }
                SlowPoint.slowPoint("正しい値を入力してください!");
            }
        
        if (selectSkill == 0) {
            return false;
        }

        Skill skill = physicalSkills.get(selectSkill - 1);

        if (this.getMp() < skill.getCost()) {
            SlowPoint.slowPoint("MPが足りない！");
            return false;
        }

        this.setMp(this.getMp() - skill.getCost());

        int damage = (skill.getPower() + this.getPower() + (int) (Math.random() * 5 + 1)) / 2 - m.getDefend() / 4
                + (int) (Math.random() * 10);
        if (damage < 1) {
            damage = 1;
        }
        m.setHp(m.getHp() - damage);
        SlowPoint.slowPoint(this.getName() + "の" + skill.getName() + "!!!\n" +
                damage + "ダメージを与えた！");
        return true;
    }

    // 魔法系特技を使う
    public boolean magicSkills(Monster m) {
        if (magicSkills.size() == 0) {
            SlowPoint.slowPoint("覚えている技がありません。");
            return false;
        }

        SlowPoint.slowPoint("使用する特技を選択してください。");
        for (int i = 0; i < magicSkills.size(); i++) {
            Skill skill = magicSkills.get(i);
            System.out.println((i + 1) + "： " + skill.getName() + "　MP：" + skill.getCost());
        }
        System.out.println("0： 戻る");
        int selectSkill = sc.nextInt();
        int max = magicSkills.size();

        while (true) {
                selectSkill = sc.nextInt();
                if (selectSkill >= 0 && selectSkill <= max) {
                    break;
                } else {
                    sc.next(); // 文字列は排除する
                }
                SlowPoint.slowPoint("正しい値を入力してください!");
            }
        
        if (selectSkill == 0) {
            return false;
        }
        
        if (selectSkill == 0) {
            return false;
        }
        
        Skill skill = magicSkills.get(selectSkill - 1);

        if (this.getMp() < skill.getCost()) {
            SlowPoint.slowPoint("MPが足りない！");
            return false;
        }

        this.setMp(this.getMp() - skill.getCost());

        int magicDamage = (skill.getPower() + this.getIntelligence() + (int) (Math.random() * 5 + 1)) / 2
                - m.getDefend() / 3
                + (int) (Math.random() * 10);
        if (magicDamage < 1) {
            magicDamage = 1;
        }
        m.setHp(m.getHp() - magicDamage);
        SlowPoint.slowPoint(this.getName() + "の" + skill.getName() + "!!!\n" +
                magicDamage + "ダメージを与えた！");
        return true;
    }

    // 回復魔法
    public boolean healSkills(Party party) {
        if (healSkills.size() == 0) {
            SlowPoint.slowPoint("覚えている技がありません。");
            return false;
        }

        SlowPoint.slowPoint("使用する特技を選択してください。");
        for (int i = 0; i < healSkills.size(); i++) {
            Skill skill = healSkills.get(i);
            System.out.println((i + 1) + "： " + skill.getName() + "　MP：" + skill.getCost());
        }
        System.out.println("0： 戻る");
        int selectSkill = sc.nextInt();
        int max = healSkills.size();

        while (true) {
                selectSkill = sc.nextInt();
                if (selectSkill >= 0 && selectSkill <= max) {
                    break;
                } else {
                    sc.next(); // 文字列は排除する
                }
                SlowPoint.slowPoint("正しい値を入力してください!");
            }
        
        if (selectSkill == 0) {
            return false;
        }
        
        if (selectSkill == 0) {
            return false;
        }
        
        Skill skill = healSkills.get(selectSkill - 1);

        if (this.getMp() < skill.getCost()) {
            SlowPoint.slowPoint("MPが足りない！");
            return false;
        }

        Protagonist target = this.selectHealTarget(party);
        if (target == null) {
            return false;
        }

        this.setMp(this.getMp() - skill.getCost());

        int healPoint = (skill.getPower() + this.getIntelligence() + (int) (Math.random() * 5 + 1)) / 2;
        if (healPoint < 1) {
            healPoint = 1;
        }
        target.setHp(target.getHp() + healPoint);
        SlowPoint.slowPoint(this.getName() + "の" + skill.getName() + "!!!\n" +
                healPoint + "ポイント回復した");
        return true;
    }

    // 回復魔法の選択先
    public Protagonist selectHealTarget(Party party) {
        party.showParty();
        SlowPoint.slowPoint("回復する仲間を選択してください。");
        int select;

        while (true) {
            try {
                select = sc.nextInt();
                if (select == 0) {
                    return null;
                }
                if (select >= 1 && select <= party.size()) {
                    break;
                }
                SlowPoint.slowPoint("0 または 1~" + party.size() + "の番号を入力してください。");
            } catch (Exception e) {
                SlowPoint.slowPoint("半角数字で入力してください。");
                sc.next();
            }
        }
        return party.getMembers().get(select - 1);
    }

    // スキルを覚える
    public void learnPhysicalSkill(Skill skill) {
        skills.add(skill);
        physicalSkills.add(skill);
        SlowPoint.moreSlowPoint(this.getName() + "は" + skill.getName() + "を覚えた！");
        System.out.println("--------------------");
    }
    public void learnMagicSkill(Skill skill) {
        skills.add(skill);
        magicSkills.add(skill);
        SlowPoint.moreSlowPoint(this.getName() + "は" + skill.getName() + "を覚えた！");
        System.out.println("--------------------");
    }
    public void learnHealSkill(Skill skill) {
        skills.add(skill);
        healSkills.add(skill);
        SlowPoint.moreSlowPoint(this.getName() + "は" + skill.getName() + "を覚えた！");
        System.out.println("--------------------");
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

    // LVアップ
    public void levelUp() {
        this.setLevel(this.getLevel() + 1);

        SlowPoint.moreSlowPoint(
                this.getName() + "は、レベルアップした！\n" +
                        "Lv." + this.getLevel() + "になった！\n" +
                        "体力と魔力が全回復した！\n" +
                        "====================");
        this.learnSkillByLevel();
    }

    // 各種族ごとに覚える特技の設定
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

    //特技の取得
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

    public void setNextExp(int exp) {
        this.movePoint = exp;
    }

    public int getNextExp() {
        return this.nextExp;
    }
}
