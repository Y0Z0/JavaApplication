import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateCalc {
    public static void main(String[] args) {
        List<String> dateList = getLastMonthDates("2023/04/26");
        System.out.println(dateList);
    }

    public static  List<String> getLastMonthDates(String yyyyMMdd) {
        List<String> dateList = new ArrayList<>();

        //yyyy/mm/ddの形式を読み取るためのもの
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        //カレンダー型のインスタンスを取得(実行時の日付になる)
        Calendar calendar = Calendar.getInstance();
        Calendar calendar_tmp = Calendar.getInstance();
        try {
            //yyyy/mm/dd形式のStringをDate型に変換
            Date d = sdf.parse(yyyyMMdd);
            Date d_tmp = sdf.parse(yyyyMMdd);
            //Date型をCalendar型に変換
            calendar.setTime(d);
            calendar_tmp.setTime(d_tmp);
            //1か月分をリストに格納
            calendar_tmp.add(Calendar.MONTH, -1);
            for (; ;) {
                if (calendar.equals(calendar_tmp)) {
                    dateList.add(sdf.format(calendar.getTime()));
                    calendar.add(Calendar.DAY_OF_MONTH, -1);
                    break;
                } else {
                    dateList.add(sdf.format(calendar.getTime()));
                    calendar.add(Calendar.DAY_OF_MONTH, -1);
                }
            }

        } catch (ParseException e) {
            //例外処理 (出力するように)
            e.printStackTrace();
        }
        //yyyy/mm/dd形式のString型でreturn
        return dateList;
    }
}
