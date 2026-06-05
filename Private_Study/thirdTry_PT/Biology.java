package Private_Study.secondTry;

abstract public class Biology{
    private String name;
    private int level = 1;
    private int maxHp;
    private int hp ;
    private int maxMp;
    private int mp;
    private int power;
    private int defend;
    private int speed;
    private int intelligence;
    private int exp = 0;

    // Biology
    public void attack(Biology target){
        int damage = this.power - target.getDefend();
        if(damage < 0) damage = 0;

        target.setHp(target.getHp() - damage);

        SlowPoint.slowPoint(this.name + "の攻撃\n" + damage + "のダメージ！");
    }

    public void heal(){
        int healPoint = (this.mp + this.intelligence * (int)(Math.random() * 11) / 10)  / 2;
        SlowPoint.slowPoint(this.name + "は、瞑想した...\n" + healPoint + "ポイント回復した！");
    }

    public void useItem(){
        int fortune = (int)(Math.random() * 2);
        if(fortune == 0){
            int heal = (this.getMaxHp() * 3) / 10;
            SlowPoint.slowPoint("奇跡のポーションだ！\n" + "HPを" + heal + "回復した。");
            int newHp = this.getHp() + heal;
            if(newHp > this.getMaxHp()){
                newHp = this.getMaxHp();
            }
            this.setHp(newHp);
        }
    }

    public void escape(){
        int fortune = (int)(Math.random() * 100) + 1;
        if(fortune > 84){
            SlowPoint.slowPoint(this.name + "は、逃げ出した！");
            return;
        }
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void setLevel(int level){
        this.level = level;
    }
    public int getLevel(){
        return this.level;
    }

    public void setMaxHp(int maxHp){
        this.maxHp = maxHp;
    }
    public int getMaxHp(){
        return this.maxHp;
    }

    public void setHp(int hp){
        this.hp = hp;
    }
    public int getHp(){
        return this.hp;
    }

    public void setMaxMp(int maxMp){
        this.maxMp = maxMp;
    }
    public int getMaxMp(){
        return this.maxMp;
    }

    public void setMp(int mp){
        this.mp = mp;
    }
    public int getMp(){
        return this.mp;
    }

    public void setPower(int power){
        this.power = power;
    }
    public int getPower(){
        return this.power;
    }

    public void setDefend(int defend){
        this.defend = defend;
    }
    public int getDefend(){
        return this.defend;
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }
    public int getSpeed(){
        return this.speed;
    }

    public void setIntelligence(int intelligence){
        this.intelligence = intelligence;
    }
    public int getIntelligence(){
        return this.intelligence;
    }

    public void setExp(int exp){
        this.exp = exp;
    }
    public int getExp(){
        return this.exp;
    }
}