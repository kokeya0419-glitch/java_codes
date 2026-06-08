package Private_Study.thirdTry_PT;

public class Adventure {
    Battle bt = new Battle();
    MonsterSelect ms = new MonsterSelect();
    private int battleCount = 0;

    public void worldSelect(Hero h, Monster m, Party party) {
        while (h.getHp() > 0 && battleCount < 5) {
            SlowPoint.moreSlowPoint("--------------------");
            SlowPoint.slowPoint("勇者" + h.getName() + "達は、森エリアへとやってきた。");
            Monster newMonster = ms.randomChoice();
            boolean win = bt.battleStart(party, newMonster);

            if (!win) {
                break;
            }
            battleCount++;
            SlowPoint.slowPoint("あなたの連勝数：" + battleCount);
        }
        if (battleCount == 5) {
            BossBattle bossBt = new BossBattle();
            Monster boss = new Dragon("ドラゴン");
            SlowPoint.slowPoint("何か不思議な気配がする・・・、次はボスが現れそうだ・・・・。");
            bossBt.battleStart(h, boss);
        }
    }
}
