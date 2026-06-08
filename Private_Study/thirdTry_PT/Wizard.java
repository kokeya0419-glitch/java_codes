package Private_Study.thirdTry_PT;

public class Wizard extends Protagonist {
    public Wizard(String name){
        this.setName(name);

        this.setMaxHp((this.getMaxHp() + 30) + (int)(Math.random() * 10));
        this.setMaxMp((this.getMaxMp() + 10) + (int)(Math.random() * 5));
        this.setPower((this.getPower() + 15) + (int)(Math.random() * 5));
        this.setDefend((this.getDefend() + 10) + (int)(Math.random() * 10));
        this.setSpeed((this.getSpeed() + 10) + (int)(Math.random() * 5));
        this.setIntelligence((this.getIntelligence() + 20) + (int)(Math.random() * 5));
    }

    public void birthComment(Protagonist w) {
        SlowPoint.slowPoint("あなたのステータスはこのようになりました。\n" +
                "HP：" + w.getMaxHp() + "\n" +
                "MP： " + w.getMaxMp() + "\n" +
                "力：" + w.getPower() + "\n" +
                "守り：" + w.getDefend() + "\n" +
                "素早さ：" + w.getSpeed() + "\n" +
                "賢さ" + w.getIntelligence());
    }
}