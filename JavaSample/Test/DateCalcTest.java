import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.text.ParseException;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DateCalcTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void main() {
    }

    @Test
    public void getLastMonthDates() throws ParseException {
        List<String> list1 = new ArrayList<>();
        list1.add("2023/04/26");
        list1.add("2023/04/25");
        list1.add("2023/04/24");
        list1.add("2023/04/23");
        list1.add("2023/04/22");
        list1.add("2023/04/21");
        list1.add("2023/04/20");
        list1.add("2023/04/19");
        list1.add("2023/04/18");
        list1.add("2023/04/17");
        list1.add("2023/04/16");
        list1.add("2023/04/15");
        list1.add("2023/04/14");
        list1.add("2023/04/13");
        list1.add("2023/04/12");
        list1.add("2023/04/11");
        list1.add("2023/04/10");
        list1.add("2023/04/09");
        list1.add("2023/04/08");
        list1.add("2023/04/07");
        list1.add("2023/04/06");
        list1.add("2023/04/05");
        list1.add("2023/04/04");
        list1.add("2023/04/03");
        list1.add("2023/04/02");
        list1.add("2023/04/01");
        list1.add("2023/03/31");
        list1.add("2023/03/30");
        list1.add("2023/03/29");
        list1.add("2023/03/28");
        list1.add("2023/03/27");
        list1.add("2023/03/26");
        List<String> dateList = DateCalc.getLastMonthDates("2023/04/26");
        Assertions.assertEquals(list1, dateList);
    }
}