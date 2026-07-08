package Private_Study.thirdTry_PT;

public class Adventure {
    Battle bt = new Battle();
    MonsterSelect ms = new MonsterSelect();
    private int battleCount = 0;

    public boolean worldSelect(Hero h, MonsterGroup mg, Party party) {
        while (h.getHp() > 0 && battleCount < 5) {
            SlowPoint.moreSlowPoint("====================");
            SlowPoint.slowPoint(h.getName() + "達は、森エリアへとやってきた。");
            boolean win = bt.battleStart(party, mg);

            if (!win) {
                return false;
            }
            battleCount++;
            SlowPoint.slowPoint("あなたの連勝数：" + battleCount);
        }
        if (battleCount == 5) {
            BossBattle bossBt = new BossBattle();
            Monster boss = new Dragon("ドラゴン");
            SlowPoint.slowPoint("何か不穏な気配がする・・・");
            bossBt.battleStart(party, boss);
        }
        return true;
    }
}
