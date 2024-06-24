import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GetDate {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date1 = validateAndParseDate("2023/03/04");
        Date date2 = validateAndParseDate("2023/03/06");
        getDayBetweenDates(date1, date2);
    }

    public static Date validateAndParseDate(String yyyymmdd) {
        Date date = null;
        try {
            //yyyy/mm/ddの形式を読み取るためのもの
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            date = sdf.parse(yyyymmdd);
        } catch (ParseException e) {
            //例外処理 (出力するように)
            e.printStackTrace();
        }
        return date;
    }

    public static int getDayBetweenDates(Date date1, Date date2){
        int date_com = 0;

        Calendar calendar_1 = Calendar.getInstance();
        Calendar calendar_2 = Calendar.getInstance();

        calendar_1.setTime(date1);
        calendar_2.setTime(date2);

        if(date1.compareTo(date2)>0) {
            //System.out.println("Date-1 is after Date-2");
            date_com = Math.toIntExact(date1.getDate() - date2.getDate());
        } else if(date1.compareTo(date2) < 0) {
            //System.out.println("Date-1 is before Date-2");
            date_com = Math.toIntExact(date2.getDate() - date1.getDate());
        } else if(date1.compareTo(date2)==0) {
            //System.out.println("Date-1 is same as Date-2");
        }
        return date_com;
    }
}
