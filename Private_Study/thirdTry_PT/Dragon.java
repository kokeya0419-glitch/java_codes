package Private_Study.thirdTry_PT;

public class Dragon extends Monster {
    public Dragon(String name){
        this.setName(name);

        this.setHp((this.getHp() + 100) + (int)(Math.random() * 25));
        this.setMaxHp(this.getHp());
        this.setMp((this.getMp() + 10) + (int)(Math.random() * 10));
        this.setMaxMp(this.getMaxMp());
        this.setPower((this.getPower() + 30) + (int)(Math.random() * 10));
        this.setDefend((this.getDefend() + 25) + (int)(Math.random() * 5));
        this.setSpeed((this.getSpeed() + 25) + (int)(Math.random() * 5));
        this.setIntelligence((this.getIntelligence() + 10) + (int)(Math.random() * 3));
        this.setExp((this.getExp() + 100) + (int)(Math.random() * 25)); 
    }
}
