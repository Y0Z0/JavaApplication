import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import java.net.URL;
import java.io.*;

public class MyDate {
    public static boolean isWeekday(String date1) {
        int week;
        //yyyy/mm/ddの形式を読み取るためのもの
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        //カレンダー型のインスタンスを取得(実行時の日付になる)
        Calendar calendar = Calendar.getInstance();
        try {
            //yyyy/mm/dd形式のStringをDate型に変換
            Date d = sdf.parse(date1);
            //Date型をCalendar型に変換
            calendar.setTime(d);
            week = calendar.get(Calendar.DAY_OF_WEEK);
            //System.out.println(week);
            if (week != Calendar.SUNDAY) {
                if (week != Calendar.SATURDAY) {
                    return true;
                }
            }

        } catch (ParseException e) {
            //例外処理 (出力するように)
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isWeekend(String date2) {
        int week;
        //yyyy/mm/ddの形式を読み取るためのもの
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        //カレンダー型のインスタンスを取得(実行時の日付になる)
        Calendar calendar = Calendar.getInstance();
        try {
            //yyyy/mm/dd形式のStringをDate型に変換
            Date d = sdf.parse(date2);
            //Date型をCalendar型に変換
            calendar.setTime(d);
            week = calendar.get(Calendar.DAY_OF_WEEK);
            //System.out.println(week);
            if (week != Calendar.SUNDAY) {
                if (week != Calendar.SATURDAY) {
                    return false;
                }
            }
        } catch (ParseException e) {
            //例外処理 (出力するように)
            e.printStackTrace();
        }
        return true;
    }

    public static String[] getNationalHoliday(int yyyy) {

        String[] NatHol = null;
        List<String> keys = new ArrayList<>();

        String result = "";
        JsonNode root = null;

        try {
            URL url = new URL("https://holidays-jp.github.io/api/v1/2023/date.json");
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.connect(); // URL接続
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String tmp2 = "";

            while ((tmp2 = in.readLine()) != null) {
                result += tmp2;
            }

            ObjectMapper mapper = new ObjectMapper();
            root = mapper.readTree(result);
            in.close();
            con.disconnect();

            Iterator<String> iterator = root.fieldNames();
            iterator.forEachRemaining(e -> keys.add(e));

        }catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println(keys);
        return NatHol;
    }
    
}