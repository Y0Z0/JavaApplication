import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Map {
    private static List<Integer> map(List<Integer> list, Function<Integer, Integer> f){
        List<Integer> result = new ArrayList<>();
        for (Integer e : list) {
            result.add(f.apply(e));
        }
        return  result;
    }

    public static void main (String[] args){
        List<Integer> l = List.of(1,3,5);
        Function<Integer, Integer> h = x -> x * x;

        List<Integer> result3 = Map.map(l, h);
        System.out.println(l);
        System.out.println(result3);
    }
}
