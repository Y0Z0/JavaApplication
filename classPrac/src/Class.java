//TIP コードを<b>実行</b>するには、<shortcut actionId="Run"/> を押すか
// ガターの <icon src="AllIcons.Actions.Execute"/> アイコンをクリックします。

import java.awt.Point;
import java.util.Date;

public class Class {
    static class String {

        public static int valueOf(){
            return 10;
        }

        void show() {
            System.out.println(valueOf());
        }
    }

    static class Integer {

        static java.lang.String tmp = "111";

        public static java.lang.String parseInt() {
            return tmp;
        }

        void show() {
            System.out.println(parseInt());
        }
    }

    static class Date {
        private static java.util.Date date;

        public static java.util.Date getTime(){
            return date;
        }

        public static java.util.Date toSting(){
            return date;
        }
    }

    public static void main(java.lang.String[] args){
        String string;
        Integer integer;
        Date date;

        string = new String();
        integer = new Integer();
        date = new Date();
        string.show();
        integer.show();
        System.out.println(date.getTime());
    }
}