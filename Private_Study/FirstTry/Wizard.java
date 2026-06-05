package Private_Study.FirstTry;

public class Wizard extends Job {
    
    public Wizard(String name){
        this.name = name;
        hp = 50 + (int)(Math.random()*25);
        mp = 30 + (int)(Math.random()*10);
        attack = 10 + (int)(Math.random()*5);
        defend = 10 + (int)(Math.random()*5);
        speed = 10 + (int)(Math.random()*10);
        intelligence = 30 + (int)(Math.random()*10);
    }

    
        public void specialyty(){
            String name = "メラ";
            slowPoint.slowPrint(this.name + "は特技：" + name + "を使った\n" +
                                "これはメラではない・・・メラゾーマだ・・・");
            this.mp -= 5;
    }
}
