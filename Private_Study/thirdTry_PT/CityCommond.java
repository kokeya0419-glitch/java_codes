package Private_Study.thirdTry_PT;

import java.util.Scanner;

public class CityCommond {
    Adventure adv = new Adventure();

    public void commond(Hero h, Monster m, Party party){
            while(true){
            System.out.println("--------------------");
            SlowPoint.slowPoint("何をしますか？\n" +
                                "1:冒険へ出る　" + "2:仲間を探す　" + "3:宿で休む　" + "4:逃げ出す...");

            Scanner sc = new Scanner(System.in);
            int selectMove;

            while (true) {
                    selectMove = sc.nextInt();
                    if (selectMove >= 1 && selectMove <= 5) {
                        break;
                    }else{
                        sc.next(); //文字列は排除する
                    }
                    SlowPoint.slowPoint("1～5を入力してください！");
                }

            switch(selectMove){
                case 1 ->{
                    SlowPoint.slowPoint(h.getName() + "は冒険へと旅立った");
                    adv.worldSelect(h,m,party);
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
