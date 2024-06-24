import java.util.function.Function;
import java.util.function.Predicate;
import java.util.List;

public class Func1 {
    public static void main(String[] args){
        Function<Integer, Integer> f = x -> x % 2;
        Function<String, String> greet = y -> "こんにちは" + y + "さん";
        Predicate<String> validate = str -> str.length() > 10;
        Predicate<Integer> greaterThanTen = i -> i > 10;
        List<Integer> ls = List.of(1,2,11);
        Predicate<Integer> LessThanTen = i -> i < 10;
        List<Integer> la = List.of(1,2,11);

        System.out.println("5divide" + f.apply(5));
        System.out.println(greet.apply("human"));
        System.out.println(validate.test("abcd"));
        System.out.println(validate.test("abcdefghijkl"));
        System.out.println(ls.stream().filter(greaterThanTen).toList());
        System.out.println(la.stream().filter(LessThanTen).toList());
    }
}
