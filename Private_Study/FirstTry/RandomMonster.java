package Private_Study.FirstTry;

public class RandomMonster {
    
    public Monster appearance(){
        int num = (int)(Math.random() * 2);

        if(num == 0){
            Gobrin g = new Gobrin();
            slowPoint.slowPrint(g.name + "が現れた！\n");
            return g;
        }else{
            Golem gm = new Golem();
            slowPoint.slowPrint(gm.name + "が現れた！\n");
            return gm;
        }
    }
}
