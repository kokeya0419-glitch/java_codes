package Private_Study.secondTry;

public class Warrior extends Protagonist {
    Warrior(String name){
        this.setName(name);

        this.setMaxHp((this.getMaxHp() + 70) + (int)(Math.random() * 50));
        this.setMaxMp((this.getMaxMp() + 2) + (int)(Math.random() * 3));
        this.setPower((this.getPower() + 10) + (int)(Math.random() * 20));
        this.setDefend((this.getDefend() + 5) + (int)(Math.random() * 15));
        this.setSpeed((this.getSpeed() + 1) + (int)(Math.random() * 5));
        this.setIntelligence((this.getIntelligence() + 5) + (int)(Math.random() * 5));
    }
}