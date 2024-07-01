import java.util.List;

public class RefaMethod {
    public static void main(String[] args) {

        List<Integer> l1 = List.of(3, 2, 1);
        List<Integer> l2 = List.of(3, 2, 11);
        List<Integer> l3 = List.of(3, 21, 11);
        List<Integer> sumList = List.of(sum(l1),sum(l2),sum(l3));

        System.out.println(sumList);
    }

    public static  int sum(List<Integer> list_n){
        int sum = 0;
        for(Integer e : list_n) {
            sum += e;
        }
        return sum;
    }
}