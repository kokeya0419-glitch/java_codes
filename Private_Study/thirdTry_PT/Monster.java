package Private_Study.secondTry;

public class Monster extends Biology {
    private String type = "notHuman";
    private String name;
    private int maxHp = 30;
    private int hp;
    private int maxMp = 5;
    private int mp;
    private int power;
    private int defend;
    private int speed;
    private int intelligence;
    private int exp;

    public void attack(Biology target){
        int attackDamage = ((this.getPower() / 2) - target.getDefend() / 4 + (int)(Math.random() * 6) + 1);
        if(attackDamage < 0){
            attackDamage = 0;
        }
        SlowPoint.slowPoint(this.getName() + "の攻撃\n" + target.getName() + "に、" +attackDamage + "のダメージを与えた");
        target.setHp(target.getHp() - attackDamage);
    }

    public void heal(){
        int healPoint = (this.getMp() + this.getIntelligence() * (int)(Math.random() * 5) + 1)  / 2;
        int newHp = this.getHp() + healPoint;
        if(newHp > this.getMaxHp()){
            newHp = this.getMaxHp();
        }
        this.setHp(newHp);
        SlowPoint.slowPoint(this.getName() + "は、傷を癒し始めた！\n" + healPoint + "ポイント回復した！");
    }

    public boolean tryEscape(){
        int fortune = (int)(Math.random() * 100) + 1;
        if(fortune > 84){
            SlowPoint.slowPoint(this.getName() + "は、逃げ出した！");
            return true;
        }else{
            SlowPoint.slowPoint(this.getName() + "は、逃げようとしたが失敗した！");
            return false;
        }
    }

    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
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
