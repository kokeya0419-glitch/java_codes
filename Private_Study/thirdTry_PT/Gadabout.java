package Private_Study.thirdTry_PT;

public class Gadabout extends Protagonist {
    public Gadabout(String name){
        this.setName(name);

        this.setMaxHp((this.getMaxHp() + 25) + (int)(Math.random() * 5));
        this.setMaxMp((this.getMaxMp() + 5) + (int)(Math.random() * 5));
        this.setPower((this.getPower() + 15) + (int)(Math.random() * 5));
        this.setDefend((this.getDefend() + 15) + (int)(Math.random() * 10));
        this.setSpeed((this.getSpeed() + 15) + (int)(Math.random() * 5));
        this.setIntelligence((this.getIntelligence() + 10) + (int)(Math.random() * 5));
    }

    public void birthComment(Protagonist g) {
        SlowPoint.slowPoint("あなたのステータスはこのようになりました。\n" +
                "HP：" + g.getMaxHp() + "\n" +
                "MP： " + g.getMaxMp() + "\n" +
                "力：" + g.getPower() + "\n" +
                "守り：" + g.getDefend() + "\n" +
                "素早さ：" + g.getSpeed() + "\n" +
                "賢さ" + g.getIntelligence());
    }
}