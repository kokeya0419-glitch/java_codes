package Private_Study.thirdTry_PT;

public class Warrior extends Protagonist {
    public Warrior(String name){
        this.setName(name);

        this.setMaxHp((this.getMaxHp() + 70) + (int)(Math.random() * 30));
        this.setMaxMp((this.getMaxMp() + 2) + (int)(Math.random() * 3));
        this.setPower((this.getPower() + 35) + (int)(Math.random() * 10));
        this.setDefend((this.getDefend() + 15) + (int)(Math.random() * 15));
        this.setSpeed((this.getSpeed() + 1) + (int)(Math.random() * 5));
        this.setIntelligence((this.getIntelligence() + 5) + (int)(Math.random() * 5));
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