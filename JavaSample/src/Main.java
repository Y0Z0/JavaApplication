//TIP コードを<b>実行</b>するには、<shortcut actionId="Run"/> を押すか
// ガターの <icon src="AllIcons.Actions.Execute"/> アイコンをクリックします。
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        //TIP ハイライトされたテキストにキャレットがある状態で <shortcut actionId="ShowIntentionActions"/> を押すと
        // IntelliJ IDEA によるその修正案を確認できます。

        System.out.println("Hello, World!");
        //月の指定は0から始まる
        System.out.println(displayDate("2022/01/22", 22));
    }

    public static String displayDate(String sDate, int PlusDays) {

        String[] date = sDate.split("/");
        Integer inputY = Integer.parseInt(date[0]);
        Integer inputM = Integer.parseInt(date[1]);
        Integer inputD = Integer.parseInt(date[2]);

        int m_adjust = 1; //月の指定調整用
        int adjustM = inputM - m_adjust;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Calendar calendar = Calendar.getInstance();
        calendar.set(inputY,adjustM,inputD);
        calendar.add(Calendar.DATE, PlusDays);

        return sdf.format(calendar.getTime());
    }
}