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

    //全滅判定
    public boolean isAlive(){
        for(Monster m : mg){
            if(m.getHp() > 0){
                return true;
            }
        }
        return false;
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