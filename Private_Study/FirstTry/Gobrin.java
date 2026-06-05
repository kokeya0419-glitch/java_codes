package Private_Study.FirstTry;

public class Gobrin extends Monster {
    
        public Gobrin(){
        this.name = "ゴブリン";
        hp = 35 + (int)(Math.random()*10);
        mp = 5 + (int)(Math.random()*5);
        attack = 10 + (int)(Math.random()*5);
        defend = 10 + (int)(Math.random()*5);
        speed = 10 + (int)(Math.random()*5);
        intelligence = 0 + (int)(Math.random()*5);
    }

}
