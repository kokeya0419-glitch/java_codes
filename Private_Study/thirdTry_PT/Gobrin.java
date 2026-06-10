package Private_Study.thirdTry_PT;

public class Gobrin extends Monster {
    public Gobrin(String name){
        this.setName(name);

        this.setHp((this.getHp() + 30) + (int)(Math.random() * 10));
        this.setMaxHp(this.getHp());
        this.setMp((this.getMp() + 1) + (int)(Math.random() * 2));
        this.setMaxMp(this.getMaxMp());
        this.setPower((this.getPower() + 20) + (int)(Math.random() * 5));
        this.setDefend((this.getDefend() + 15) + (int)(Math.random() * 5));
        this.setSpeed((this.getSpeed() + 10) + (int)(Math.random() * 5));
        this.setIntelligence((this.getIntelligence() + 1) + (int)(Math.random() * 3));
        this.setExp((this.getExp() + 3) + (int)(Math.random() * 3)); 
    }
}
