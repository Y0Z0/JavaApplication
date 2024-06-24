import javax.swing.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args){
        Apple apple = new Apple(100, "Japan", "red");
        Fruits fruits = new Fruits(100, "Canada", "赤");

        System.out.println(apple.price);
        System.out.println(apple.madeIn);
        System.out.println(apple.isMadeInJapan());
        System.out.println(apple.getDetail());
        System.out.println(fruits);

        Pair<String> p = new Pair<>("test1", "test2");

        Pair2<String, Integer> q = new Pair2<>("test1", 100);

        System.out.println(p);
        System.out.println(q);

        Pair<String> pair1 = new Pair<>("test1", "test2");
        Pair<String> pair2 = new Pair<>("test3", "test4");
        Pair<Pair<String>> pairPair = new Pair<>(pair1, pair2);

        Quadruple<String> r = Quadruple.getQuadrupleBy(pairPair);
        System.out.println(r);

        Fruits f1 = new Fruits(200, "Japan", "赤");
        Fruits f2 = new Fruits(200, "Japan", "赤");
        Apple ap1 = new Apple(200, "Japan", "赤");

        FruitsPair<Fruits> fp = new FruitsPair<>(f1,ap1);
        System.out.println(fp);

        if (f2.equals(ap1)){
            System.out.println("same");
        }
        else{
            System.out.println("no same");
        }

        Fruits f3 = new Fruits(199, "japan","red");
        Fruits f4 = new Fruits(199, "japan","red");
        HashSet<Fruits> hf1 = new HashSet<>();
        hf1.add(f3);
        HashSet<Fruits> hf2 = new HashSet<>();
        hf2.add(f4);
        System.out.println(hf1.equals(hf2));

        Function<Integer, Integer> f = x -> x % 2;
        System.out.println("5divide" + f.apply(5));

        Function<Integer, Boolean> ff = x -> {
            if (x == 10){
                return true;
            }else {
                return false;
            }
        };
        System.out.println("ラムダ式サンプル1st(x=0) : " + ff.apply(0));
        System.out.println("ラムダ式サンプル1st(x=10) : " + ff.apply(10));

        Function<String,String> greet = x -> "こんにちは" + x + "さん";
        System.out.println(greet.apply("araki")); // こんにちはarakiさんが返ってくる

        Predicate<String> validate = str -> {
            if (str.length() > 10) {
                return false;
            } else {
                return true;
            }
        };

        System.out.println("Predicateサンプル (false) : " + validate.test("ア1イウエオカキクケコ"));
        System.out.println("Predicateサンプル (true) : " + validate.test("アイウエオカキクケコ"));


        Predicate<Integer> fil = x -> {
            if (x > 10) {
                return false;
            } else {
                return true;
            }
        };
        List<Integer> arr = Arrays.asList(1,2,11,34);
        System.out.println("filterサンプル [1, 2] : "+ arr.stream().filter(fil).toList());
    }

}
