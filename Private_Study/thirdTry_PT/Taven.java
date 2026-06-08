package Private_Study.thirdTry_PT;

import java.util.Scanner;

public class Taven {
    AddMember addm = new AddMember();

    public void tavenMenu(Party party) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            SlowPoint.slowPoint("--------------------\n" +
                    "酒場へやってきた。\n" +
                    "１：仲間を探す\n" +
                    "２：パーティの確認\n" +
                    "３：酒場を出る");
            int selectMove = sc.nextInt();

            switch (selectMove) {
                case 1 -> {
                    Protagonist newMember = addm.addPartyMember(party);

                    if (newMember != null) {
                        party.addMember(newMember);
                    }
                }
                case 2 -> {
                    party.showParty();
                    SlowPoint.slowPoint("詳細を見たい仲間の番号を選択");
                    int index;
                    while (true) {
                        index = sc.nextInt();
                        if (index >= 1 && index <= 3) {
                            break;
                        } else {
                            sc.next(); // 文字列は排除する
                        }
                        SlowPoint.slowPoint("1～3を入力してください！");
                    }
                    party.showMemberDetail(index - 1);
                }
                case 3 -> {
                    return;
                }
                default -> {
                    SlowPoint.slowPoint("正しい番号を入力してください。");
                }
            }
        }
    }
}
