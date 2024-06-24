import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Sample {
    public static void main(String[] args) {
        String today = addDay("2023/11/11",1);
        System.out.println(today);
    }

    public static String addDay(String yyyymmdd, int addDay) {
        //yyyy/mm/ddの形式を読み取るためのもの
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        //カレンダー型のインスタンスを取得(実行時の日付になる)
        Calendar calendar = Calendar.getInstance();
        try {
            //yyyy/mm/dd形式のStringをDate型に変換
            Date d = sdf.parse(yyyymmdd);
            //Date型をCalendar型に変換
            calendar.setTime(d);
            //指定分の日数を加算
            calendar.add(Calendar.DAY_OF_MONTH, addDay);
        } catch (ParseException e) {
            //例外処理 (出力するように)
            e.printStackTrace();
        }
        //yyyy/mm/dd形式のString型でreturn
        return sdf.format(calendar.getTime());
    }

}
