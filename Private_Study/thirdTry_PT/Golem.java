package Private_Study.thirdTry_PT;

public class Golem extends Monster {
    public Golem(String name){
        this.setName(name);

        this.setHp((this.getHp() + 50) + (int)(Math.random() * 25));
        this.setMaxHp(this.getHp());
        this.setMp((this.getMp() + 1) + (int)(Math.random() * 2));
        this.setMaxMp(this.getMaxMp());
        this.setPower((this.getPower() + 25) + (int)(Math.random() * 5));
        this.setDefend((this.getDefend() + 30) + (int)(Math.random() * 5));
        this.setSpeed((this.getSpeed() + 2) + (int)(Math.random() * 5));
        this.setIntelligence((this.getIntelligence() + 1) + (int)(Math.random() * 3));
        this.setExp((this.getExp() + 5) + (int)(Math.random() * 5)); 
    }
    
}
