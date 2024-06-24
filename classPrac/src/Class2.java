import java.util.Scanner;

public class Class2 {
    static class Table{
        public int tableNumber;
        public int guestNumber;

        private static int getTotal(int n){
            int total = 0;


            return total;
        }

        private static String getOrder(){
            System.out.println("注文メニュー");
            /*
            for (int i = 0; Order.orderList.length; i++){

            }
            */
            return null;
        }

        private static String getStatus(){
            return null;
        }
    }

    static class Order{
        public String[][] orderList;
        public String[][] orderStatus;

        private static String[][] recordOrder(){

            return null;
        }
    }

    static class Menu{
        public String[][] drink;
        public String[][] muffin;
        private String[][] bread;
    }

    public static void main(String[] args){
        Table table = new Table();
        Order order = new Order();
        Menu menu = new Menu();

        int i = 0;

        System.out.println("コマンドを入力してください。1:メニュー登録　2:オーダー登録 3:清算");
        Scanner cmd = new Scanner(System.in);
        i = cmd.nextInt();

        switch (i){
            case 1: //メニュー登録

                break;

            case 2: //オーダー登録
                System.out.println("オーダー登録開始");
                //卓番登録
                System.out.println("卓番を入力してください");
                Scanner Number = new Scanner(System.in);
                table.tableNumber = Number.nextInt();
                //System.out.println(table.tableNumber);

                //人数登録
                System.out.println("人数を入力してください");
                Scanner Guest = new Scanner(System.in);
                table.guestNumber = Guest.nextInt();
                //System.out.println(table.guestNumber);

                //オーダー登録
                order.orderList = new String[5][];
                System.out.println("オーダーを入力してください(「q」を入力で終了します)");
                Scanner tableOrder = new Scanner(System.in);
                for (int j = 0; ; j++){
                    String tmp = tableOrder.next();
                    if (tmp.equals("q")){
                        System.out.println("オーダー登録を終了します。");
                        break;
                    }
                    else{
                        order.orderList[table.tableNumber][j] = tmp;
                    }
                }
                Guest.close();
                Number.close();
                tableOrder.close();
                break;

            case 3: //清算
                System.out.println("清算します。");
                Scanner tableNumber = new Scanner(System.in);
                int num = tableNumber.nextInt();
                System.out.println(table.getTotal(num));
                tableNumber.close();
                break;
        }
        cmd.close();
    }
}
