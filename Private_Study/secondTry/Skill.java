package Private_Study.secondTry;

public class Skill {
    private String name;
    private int power;
    private int cost;

    public Skill(String name, int power, int cost){
        this.name = name;
        this.power = power;
        this.cost = cost;
    }

    public String getName(){
        return this.name;   
    }

    public int getPower(){
        return this.power;
    }

    public int getCost(){
        return this.cost;
    }
}
