package Private_Study.FirstTry;

import java.util.Scanner;

public class addMember {
    String name;
    int jobNumber;
    Job job;

    public Job joinMember(){
        Scanner scanner = new Scanner(System.in);

        slowPoint.slowPrint("名前を入力してください。");
        name = new java.util.Scanner(System.in).nextLine();

        slowPoint.slowPrint("職業番号を選んでください\n" + "1:ファイター 2:魔法使い");

        while (true) {
        jobNumber = scanner.nextInt();
            switch(jobNumber){
                case 1 ->{
                    Fighter f = new Fighter(this.name);
                    slowPoint.slowPrint("ファイター：" + this.name + "がこの世に誕生しました\n" +
                                    "あなたのステータスは");
                                    slowPoint.slowPrint("体力：" + f.hp + "魔力：" + f.mp + "攻撃力：" + f.attack + "守備力：" + f.defend + "素早さ：" + f.speed + "賢さ：" + f.intelligence + "\t\n");
                return job = f;
                }
                case 2 ->{
                    Wizard w = new Wizard(this.name);
                    slowPoint.slowPrint("魔法使い：" + this.name + "がこの世に誕生しました\n" +
                                    "あなたのステータスは");
                                    slowPoint.slowPrint("体力：" + w.hp + "魔力：" + w.mp + "攻撃力：" + w.attack + "守備力：" + w.defend + "素早さ：" + w.speed + "賢さ：" + w.intelligence + "\t\n");
                return job = w;
                }
                default ->{
                    slowPoint.slowPrint("もう一度入力してください");
                }
            }
        }
    }
}