package Private_Study.secondTry;

public class MonsterSelect {

    public Monster randomChoice(){
        int random = (int)(Math.random() * 3);
        switch(random){
            case 0 ->{
                return new Gobrin("ゴブリン");
            }
            case 1 ->{
                return new Golem("ゴーレム");
            }
            case 2 ->{
                return new Badman("バッドマン");
            }
        } return new Gobrin("ゴブリン");
    }
    
}
