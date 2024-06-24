import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PrimeNumberTest {
    @Test
    public void ListTest(){
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(3);
        list1.add(5);
        list1.add(7);
        list1.add(11);
        assertEquals(list1 , PrimeNumber.generate(5));
        assertNotEquals(list1 , PrimeNumber.generate(6));
        assertNotEquals(list1 , PrimeNumber.generate(4));
    }

    @Test
    public  void PointTest(){
        assertEquals(7, PrimeNumber.getPrime(4));
        assertEquals(11, PrimeNumber.getPrime(5));
        assertEquals(17, PrimeNumber.getPrime(7));
    }
}