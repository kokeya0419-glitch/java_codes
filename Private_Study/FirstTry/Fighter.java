package Private_Study.FirstTry;

public class Fighter extends Job {

    public Fighter(String name){
        this.name = name;
        hp = 100 + (int)(Math.random()*50);
        mp = 5 + (int)(Math.random()*5);
        attack = 25 + (int)(Math.random()*10);
        defend = 20 + (int)(Math.random()*10);
        speed = 5 + (int)(Math.random()*5);
        intelligence = 5 + (int)(Math.random()*5);
    }

        public void specialyty(){
            String name = "強打";
            slowPoint.slowPrint(this.name + "は特技：" + name + "を使った");
            this.mp -= 2;
    }
}
