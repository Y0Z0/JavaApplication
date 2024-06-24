import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebAPISample {
    public static void main(String[] args) {

        // WebAPI から取得した値を格納する文字列変数
        String tmp;

        try{
            while (true) {

                URL targetURL
                        = new URL("https://api.bitflyer.com/v1/getboard?product_code=BTC_JPY");
                HttpURLConnection conn
                        = (HttpURLConnection)targetURL.openConnection();
                conn.connect();
                BufferedReader Br
                        = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                while ((tmp  =  Br.readLine  ()) != null) {
                    System.out.println(tmp);
                }

                Thread.sleep(3000);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
