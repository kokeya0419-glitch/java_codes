package Private_Study.thirdTry_PT;

import java.util.ArrayList;

public class MonsterGroup {
    private String name = "モンスターの群れ";
    private ArrayList<Monster> mg = new ArrayList<>();

    // モンスター配列の生成
    public Monster getRandomMonster() {
        ArrayList<Monster> alive = new ArrayList<>();
        for (Monster m : mg) {
            if (m.getHp() > 0) {
                alive.add(m);
            }
        }
        int index = (int)(Math.random() * alive.size());
        return alive.get(index);
    }

    //配列の中身を削除
    public void clear(){
        mg.clear();
    }

    //モンスターの名前表示
    public String getMonsterNames(){
        StringBuilder sb = new StringBuilder();
        for(Monster m : mg){
            sb.append("・").append(m.getName()).append("\n");
        }
        return sb.toString();
    }

    //全滅判定
    public boolean isAlive(){
        for(Monster m : mg){
            if(m.getHp() > 0){
                return true;
            }
        }
        return false;
    }

    //魔物の群れの合計経験値
    public int getTotallExp(){
        int totallExp = 0;
        for(Monster monster : mg){
            totallExp += monster.getExp();
        }
        return totallExp;
    }

    public void addMonster(Monster monster) {
        mg.add(monster);
    }

    public ArrayList<Monster> getMg() {
        return mg;
    }

    public ArrayList<Monster> getMonsters() {
        return mg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}