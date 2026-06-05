package Private_Study.FirstTry;

public class Monster extends Existence{
    String type = "notHuman";

        //     public Monster(int hp, int mp, int attack, int defend, int speed, int intelligence){
        //     super(hp, mp, attack, defend, speed, intelligence);
        // }

        public void specialty(){
        slowPoint.slowPrint(this.name + "は特技を使った");
    }

        public int fight(Job h){
        int attackDamage = (this.attack * this.speed) - h.defend;
        slowPoint.slowPrint(this.name + "の、攻撃！\n" + h.name + "に" + attackDamage + "のダメージを与えた！");
        if(attackDamage < 0){
            attackDamage = 0;
        }
        h.hp -= attackDamage;
        return attackDamage;
    }

        public void protect(Job h){
        // protectPoint = h.attackDamage / (this.defend / 10);
        slowPoint.slowPrint(this.name + "は、守りを固めた！");
    }

        public void escape(){
        int probability = (int)(Math.random()*101);
        if(probability >= 85){
            slowPoint.slowPrint(this.name + "は、逃げ出した");
            return;
        }else{
            slowPoint.slowPrint("逃げることが出来なかった...");
        }
    }
}
