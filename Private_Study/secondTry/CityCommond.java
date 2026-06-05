    package Private_Study.secondTry;

    import java.util.Scanner;

    public class CityCommond {
        Adventure adv = new Adventure();
        
        public void commond(Hero h, Monster m){
            SlowPoint.slowPoint("何をしますか？\n" +
                                "1:冒険へ出る　" + "2:仲間を探す　" + "3:宿で休む　" + "4:逃げ出す...");

            Scanner sc = new Scanner(System.in);
            int selectMove;

            while (true) {
                    selectMove = sc.nextInt();
                    if (selectMove >= 1 && selectMove <= 5) {
                        break;
                    }else{
                        sc.next(); //文字列は妻女する
                    }
                    SlowPoint.slowPoint("1～5を入力してください！");
                }

            switch(selectMove){
                case 1 ->{
                    SlowPoint.slowPoint(h.getName() + "は冒険へと旅立った");
                    adv.worldSelect(h,m);
                }
                case 2 ->{
                    SlowPoint.slowPoint(h.getName() + "は酒場へと向かった"); //仲間追加はまだ未実装
                }
                case 3 ->{
                    SlowPoint.slowPoint(h.getName() + "は宿屋で休むことにした\n" + "体力が全回復した");
                    h.setHp(h.getMaxHp());
                    this.commond(h, m);
                }
                case 4 ->{
                    SlowPoint.moreSlowPoint("この世界は魔物に侵略されてしまった・・・");
                }
            }
        }
    }
