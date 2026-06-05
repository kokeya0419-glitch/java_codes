package Private_Study.FirstTry;

public class Job extends Existence {
    String type = "human";

        // public Job(int hp, int mp, int attack, int defend, int speed, int intelligence){
        //     super(hp, mp, attack, defend, speed, intelligence);
        // }

    public void specialyty(){
        slowPoint.slowPrint(this.name + "は特技を使った");
    }

       public void fight(Monster m){
        int attackDamage = (this.attack * this.speed) - (m.defend * 8);
        slowPoint.slowPrint(this.name + "の、攻撃！\n" + m.name + "に" + attackDamage + "のダメージを与えた！");
        if(attackDamage < 0){
            attackDamage = 0;
        }
        m.hp -= attackDamage;
    }

        public void heal(){
        slowPoint.slowPrint(this.name + "は、体力を10回復をした！\n");
        this.hp += 10;
    }
}
