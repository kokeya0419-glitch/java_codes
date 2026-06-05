package Private_Study.FirstTry;

public abstract class Existence {
    String name;
    int hp;
    int mp;
    int attack;
    int defend;
    int speed;
    int intelligence;
    int attackDamage;
    int protectPoint;

    // public Existence(int hp, int mp, int attack, int defend, int speed, int intelligence){
    //     this.hp = hp;
    //     this.mp = mp;
    //     this.attack = attack;
    //     this.defend = defend;
    //     this.speed = speed;
    //     this.intelligence = intelligence;
    // }

    public int fight(){
        int attackDamage = (attack * speed) / (defend * 2);
        slowPoint.slowPrint(this.name + "の、攻撃！\n" + attackDamage + "のダメージを与えた！");
        return attackDamage;
    }

    public void use(String itemName){
        String useItem = itemName;
        slowPoint.slowPrint(this.name + "は、" + useItem + "を、使った！");
        int fortune = (int)(Math.random() * 2);
        if(fortune == 0){
            slowPoint.slowPrint("不思議なポーションは、奇跡のポーションだった！\n" + this.name + "の体力を10回復した");
            this.hp += 10;
        }else{
            slowPoint.slowPrint("不思議なポーションは、衰退のポーションだった！\n" + this.name + "の体力を10奪った");
            this.hp -= 10;
        }
    }

    public void protect(){
        protectPoint = attackDamage / (defend / 10);
        slowPoint.slowPrint(this.name + "は、守りを固めた！");
    }

    public void escape(){
        int probability = (int)(Math.random()*101);
        if(probability >= 65){
            slowPoint.slowPrint(this.name + "は、逃げ出した");
        }else{
            slowPoint.slowPrint("逃げることが出来なかった...");
        }
    }
}
