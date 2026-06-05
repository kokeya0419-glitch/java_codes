package Private_Study.secondTry;

import java.util.Scanner;

public class AddMember {

    public Hero addMember() {
        SlowPoint.slowPoint("新たな勇者を作成します。\n" + "勇者の名前を教えてください");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        Hero h = new Hero(name);
        h.birthComment(h);
        SlowPoint.slowPoint("勇者 ”" + h.getName() + "” よ、新たな冒険の始まりです");
        return h;
    }
}