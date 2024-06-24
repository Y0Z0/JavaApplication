import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;

public class Func2 {
    public static void main(String[] args){
        BinaryOperator<Integer> bo = (x,y) -> {
            return x + y * 2;
        };
        Integer result1 = bo.apply(3,2);

        BinaryOperator<List<Integer>> add_l = (x, y) -> {
            List<Integer> z = new ArrayList<>(List.of());
            List<Integer> shortList = new ArrayList<>(List.of());
            List<Integer> longList = new ArrayList<>(List.of());

            if (x.size() <= y.size()){
                shortList = x;
                longList = y;
            }
            else{
                shortList = y;
                longList = x;
            }

            for (int cnt = 0; cnt < longList.size(); cnt++){
                if (cnt > shortList.size() - 1){
                    z.add(longList.get(cnt));
                }
                else {
                    z.add(shortList.get(cnt) + longList.get(cnt));
                }
            }
            return z;
        };

        List<Integer> result2 =
                add_l.apply(List.of(1,2,3,4), List.of(3,5,9));
        List<Integer> result3 =
                add_l.apply(List.of(1,2,3), List.of(3,5,9,11));

        List<String> strList = new ArrayList<>(List.of("aaa", "bb", "c"));
        Collections.sort(strList);
        System.out.println(strList);
        Comparator<String> c = (s1, s2) -> Integer.compare(s1.length(), s2.length());
        Collections.sort(strList, c);
        System.out.println(strList);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}
