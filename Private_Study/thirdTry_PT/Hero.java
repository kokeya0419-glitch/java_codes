package Private_Study.thirdTry_PT;

public class Hero extends Protagonist {
    Hero(String name) {
        this.setName(name);
        this.setLevel(this.getLevel());

        this.setHp((this.getHp() + 50) + (int) (Math.random() * 10));
        this.setMaxHp(getHp());
        this.setMp((this.getMp() + 3) + (int) (Math.random() * 5));
        this.setMaxMp(this.getMp());
        this.setPower((this.getPower() + 25) + (int) (Math.random() * 15));
        this.setDefend((this.getDefend() + 15) + (int) (Math.random() * 10));
        this.setSpeed((this.getSpeed() + 15) + (int) (Math.random() * 10));
        this.setIntelligence((this.getIntelligence() + 10) + (int) (Math.random() * 5));
    }

    public void birthComment(Hero h) {
        SlowPoint.slowPoint("あなたのステータスはこのようになりました。\n" +
                "HP：" + h.getMaxHp() + "\n" +
                "MP： " + h.getMaxMp() + "\n" +
                "力：" + h.getPower() + "\n" +
                "守り：" + h.getDefend() + "\n" +
                "素早さ：" + h.getSpeed() + "\n" +
                "賢さ" + h.getIntelligence());
    }

}