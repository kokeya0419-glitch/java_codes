package Private_Study.thirdTry_PT;

import java.util.Scanner;

public class CityCommond {
    Adventure adv = new Adventure();

    public void commond(Hero h, MonsterGroup mg, Party party){
            while(true){
            System.out.println("====================");
            SlowPoint.slowPoint("何をしますか？\n" +
                                "1:冒険へ出る　" + "2:仲間を探す　" + "3:宿で休む　" + "4:逃げ出す...");

            Scanner sc = new Scanner(System.in);
            int selectMove;

            while(true){
                try{
                    selectMove = sc.nextInt();
                    if(selectMove >= 1 && selectMove <= 4){
                        break;
                    }
                    SlowPoint.slowPoint("1～4を入力してください！");
                }catch(Exception e){
                    SlowPoint.slowPoint("半角数字で入力してください。");
                    sc.next(); //文字列は排除する
                }
            }

            switch(selectMove){
                case 1 ->{
                    SlowPoint.slowPoint(h.getName() + "は冒険へと旅立った");
                    boolean returned = adv.worldSelect(h, mg, party);
                    adv.worldSelect(h,mg,party);
                    if(!returned){
                        SlowPoint.moreSlowPoint("GameOver...");
                        return;
                    }
                }
                case 2 ->{
                    Taven taven = new Taven();
                    SlowPoint.slowPoint(h.getName() + "は酒場へと向かった");
                    taven.tavenMenu(party);
                }
                case 3 ->{
                    SlowPoint.slowPoint(h.getName() + "は宿屋で休むことにした");
                    if(party.isAllRecovered()){
                        SlowPoint.slowPoint("パーティは既に全回復している。");
                    }else{
                        party.recoverAll();
                        SlowPoint.slowPoint("パーティ全員が全回復した！");
                    }
                }
                case 4 ->{
                    SlowPoint.moreSlowPoint("この世界は魔物に侵略されてしまった・・・");
                    return;
                }
                default ->{
                    SlowPoint.slowPoint("正しい番号を入力してください。");
                }
            }
        }
    }
}
