package Private_Study.thirdTry_PT;

public class SlowPoint {
    public static void slowPoint(String text) {
    for (int i = 0; i < text.length(); i++) {
        System.out.print(text.charAt(i));
        try {
            Thread.sleep(40); //表示速度
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
    System.out.println(); //最後に改行をする
    }
    
    public static void moreSlowPoint(String text) {
    for (int i = 0; i < text.length(); i++) {
        System.out.print(text.charAt(i));
        try {
            Thread.sleep(100); // ← 表示速度（ミリ秒）
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    System.out.println(); // 最後に改行
}
}