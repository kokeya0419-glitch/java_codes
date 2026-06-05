package Private_Study.FirstTry;

public class War {
    int selectMove;
    int monsterSelectMove;
    int conGames;

    RandomMonster rm = new RandomMonster();
    Monster newMonster; 

    public void startFight(Job h, Monster m){
        if(h.speed * (int)(Math.random() * 3) >= m.speed * (int)(Math.random() * 3)){
            slowPoint.slowPrint(h.name +"の番です\n" +
                                "あなたは何をする？");
            slowPoint.slowPrint("1:攻撃 2:守る 3:アイテム 4:逃げる\n");
            selectMove = new java.util.Scanner(System.in).nextInt();

            switch(selectMove){
                case 1 ->{
                    h.fight(m);
                    if(m.hp <= 0 ){
                        conGames++;
                        newMonster = rm.appearance();
                        System.out.println(m.name + "を倒した！\n" + "あなたの連勝数は：" + conGames + "\n" + "すぐさま" + newMonster.name + "が現れた！\n");
                    }
                }
                case 2 ->{
                    h.heal();
                }
                case 3 ->{
                    h.use("不思議なポーション");
                }
                case 4 ->{
                    h.escape();
                }
            }
            slowPoint.slowPrint(m.name + "の番！");
            monsterSelectMove = (int)(Math.random() * 25);
            if(monsterSelectMove <14 ){
                    m.fight(h);
                }else if(monsterSelectMove <19) {
                    m.protect(h);
                }else if(monsterSelectMove > 19){
                    m.escape();
                    conGames++;
                }
            }else{
                slowPoint.slowPrint(m.name + "の番！");
                monsterSelectMove = (int)(Math.random() * 25);
                    if(monsterSelectMove <14 ){
                        m.fight(h);
                    }else if(monsterSelectMove <19) {
                        m.protect(h);   
                    }else if(monsterSelectMove > 19){
                        m.escape();
                        conGames++;
                    }
                slowPoint.slowPrint(h.name +"の番です\n" +
                                "あなたは何をする？");
                slowPoint.slowPrint("1:攻撃 2:回復 3:アイテム 4:逃げる\n");
                int selectMove = new java.util.Scanner(System.in).nextInt();
                switch(selectMove){
                case 1 ->{
                    h.fight(m);
                    if(m.hp <= 0 ){
                        conGames++;
                        newMonster = rm.appearance();
                        slowPoint.slowPrint(m.name + "を倒した！\n" + "あなたの連勝数は：" + conGames + "\n" + "すぐさま" + newMonster.name + "が現れた！\n");
                    }
                }
                case 2 ->{
                    h.heal();
                }
                case 3 ->{
                    h.use("不思議なポーション");
                }
                case 4 ->{
                    h.escape();
                }
            }
        }
        slowPoint.slowPrint(h.name + "の、体力は残り：" + h.hp + "\n");
        if(h.hp > 0 && m.hp > 0){
            this.startFight(h, m);
        }else if(h.hp <=0){
            slowPoint.slowPrint("GameOver...\n" + "あなたの連勝数は：" + conGames);
            return;
        }else{
            this.startFight(h, newMonster);
        }
    }
}

