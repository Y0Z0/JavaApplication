import java.util.ArrayList;
import java.util.List;

public class PrimeNumber {
    public static void main(String[] args) {
        List<Integer> primes = generate(5);
        for (int i = 0; i < primes.size(); i++){
            System.out.println(i + 1 + ":" + primes.get(i));
        }
    }

    public static List<Integer> generate(int n){
        List<Integer> primes = new ArrayList<>();
        int target; //素数カウント用
        int cnt = 1;    //通番用
        int flg;    //フラグチェック用

        for (target = 2; cnt < n + 1; target++){
            flg = 0;
            if (target < 2) {
                continue;
            }

            for (int i = 2; i < target; i++){
                if (target % i == 0) {
                    flg = 1;
                    break;
                }
            }

            if (flg == 1){
                continue;
            }

            primes.add(target);
            cnt++;
        }
        return primes;
    }

    public static int getPrime(int nth){
        int prime;
        int target; //素数カウント用
        int cnt = 1;    //通番用
        int flg;    //フラグチェック用

        for (target = 2; ; target++){
            flg = 0;
            if (target < 2) {
                continue;
            }

            for (int i = 2; i < target; i++){
                if (target % i == 0) {
                    flg = 1;
                    break;
                }
            }

            if (flg == 1){
                continue;
            }

            if (cnt == nth){
                prime = target;
                break;
            }
            cnt++;
        }

        return prime;
    }
}
