package Private_Study.thirdTry_PT;

public class Badman extends Monster {
    public Badman(String name){
        this.setName(name);

        this.setHp((this.getHp() + 10) + (int)(Math.random() * 5));
        this.setMaxHp(this.getHp());
        this.setMp((this.getMp() + 1) + (int)(Math.random() * 2));
        this.setMaxMp(this.getMaxMp());
        this.setPower((this.getPower() + 35) + (int)(Math.random() * 5));
        this.setDefend((this.getDefend() + 2) + (int)(Math.random() * 5));
        this.setSpeed((this.getSpeed() + 30) + (int)(Math.random() * 5));
        this.setIntelligence((this.getIntelligence() + 1) + (int)(Math.random() * 3));
        this.setExp((this.getExp() + 5) + (int)(Math.random() * 3)); 
    }
    
}
