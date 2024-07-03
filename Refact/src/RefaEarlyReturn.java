import java.util.*;

public class RefaEarlyReturn {
    public static void main(String[] args){
        //リストの中に、aiueoという文字列が含まれていたらtrue
        //リストの中に、kakikukekoという文字列が含まれていたらtrue
        List<String> moji = Arrays.asList("a", "i", "u", "aiueo", "kakikukeko");
        System.out.println(containsString(moji));

        //アクティブユーザ判定
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, Calendar.NOVEMBER, 9);
        Date today = calendar.getTime();

        // ユーザーの開始日を設定
        calendar.setTime(today);
        calendar.add(Calendar.MONTH, -1);
        Date startDate = calendar.getTime();

        User user = new User("iwa", startDate, null, false);
        System.out.println(isActiveUser(user, today));
    }

    //文字列判定
    public static boolean containsString(List<String> ml){
        if (ml.contains("aiueo")) return true;
        if (ml.contains("kakikukeko")) return true;
        return false;
    }

    // Userクラス
    public static class User {
        String name;
        Date startDate;
        Date endDate;
        boolean stopped;

        public User(String name, Date startDate, Date endDate, boolean stopped) {
            this.name = name;
            this.startDate = startDate;
            this.endDate = endDate;
            this.stopped = stopped;
        }
    }

    //アクティブユーザ判定
    public static boolean isActiveUser(User user, Date today) {
        //ユーザが存在しない
        if (user == null) return false;
        //アカウント開始日が本日よりも後
        if (user.startDate.compareTo(today) > 0) return false;
        //アカウント終了日が存在し、本日より前
        if (user.endDate != null && today.compareTo(user.endDate) > 0) return false;
        //アカウント停止済み
        if (user.stopped) return false;
        //アクティブユーザ
        return true;
    }


}
