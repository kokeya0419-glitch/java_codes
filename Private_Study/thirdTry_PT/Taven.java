package Private_Study.thirdTry_PT;

import java.util.Scanner;

public class Taven {
    AddMember addm = new AddMember();

    public void tavenMenu(Party party) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("====================");
            SlowPoint.slowPoint("酒場へやってきた。\n" +
                    "１：仲間を探す\n" +
                    "２：パーティの確認\n" +
                    "３：酒場を出る");
            int selectMove;
            int max = party.size();

            // 入力確認
            while (true) {
                try {
                    selectMove = sc.nextInt();
                    if (selectMove >= 1 && selectMove <= 3) {
                        break;
                    }
                    SlowPoint.slowPoint("1～3を入力してください！");
                } catch (Exception e) {
                    SlowPoint.slowPoint("半角数字で入力してください。");
                    sc.next(); // 文字列は排除する
                }
            }

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
                        try {
                            index = sc.nextInt();
                            if (index >= 1 && index <= max) {
                                break;
                            }
                            SlowPoint.slowPoint("1～3を入力してください！");
                        } catch (Exception e) {
                            SlowPoint.slowPoint("半角数字で入力してください。");
                            sc.next(); // 文字列は排除する
                        }
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
