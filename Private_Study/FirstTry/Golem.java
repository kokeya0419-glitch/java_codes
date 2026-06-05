package Private_Study.FirstTry;

public class Golem extends Monster {
    
    public Golem(){
        this.name = "ゴーレム";
        hp = 80 + (int)(Math.random()*20);
        mp = 2 + (int)(Math.random()*5);
        attack = 15 + (int)(Math.random()*5);
        defend = 25 + (int)(Math.random()*5);
        speed = 5 + (int)(Math.random()*5);
        intelligence = 0 + (int)(Math.random()*5);
    }

    public void speciality(){
        String name = "気合パンチ";
        slowPoint.slowPrint(this.name + "は、" + name + "を、使った");
        this.mp -= 1;
    }
}
