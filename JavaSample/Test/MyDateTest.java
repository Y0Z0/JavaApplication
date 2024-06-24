import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyDateTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testIsWeekday() {
        assertTrue(MyDate.isWeekday("2024/05/14"));
        assertTrue(MyDate.isWeekday("2024/05/15"));
        assertTrue(MyDate.isWeekday("2024/05/16"));
        assertTrue(MyDate.isWeekday("2024/05/17"));
        assertFalse(MyDate.isWeekday("2024/05/18"));
        assertFalse(MyDate.isWeekday("2024/05/19"));
        assertTrue(MyDate.isWeekday("2024/05/20"));
        assertTrue(MyDate.isWeekday("2024/05/21"));
        assertTrue(MyDate.isWeekday("2024/05/22"));
        assertFalse(MyDate.isWeekday("2024/05/26"));
    }

    @Test
    public void testIsWeekend() {
        assertFalse(MyDate.isWeekend("2024/05/14"));
        assertFalse(MyDate.isWeekend("2024/05/15"));
        assertFalse(MyDate.isWeekend("2024/05/16"));
        assertFalse(MyDate.isWeekend("2024/05/17"));
        assertTrue(MyDate.isWeekend("2024/05/18"));
        assertTrue(MyDate.isWeekend("2024/05/19"));
        assertFalse(MyDate.isWeekend("2024/05/20"));
        assertFalse(MyDate.isWeekend("2024/05/21"));
        assertFalse(MyDate.isWeekend("2024/05/22"));
        assertTrue(MyDate.isWeekend("2024/05/26"));
    }

    @Test
    public void testGetNationalHoliday(){
        String[] expected = {
                "2023/01/01",
                "2023/01/02",
                "2023/01/09",
                "2023/02/11",
                "2023/02/23",
                "2023/03/21",
                "2023/04/29",
                "2023/05/03",
                "2023/05/04",
                "2023/05/05",
                "2023/07/17",
                "2023/08/11",
                "2023/09/18",
                "2023/09/23",
                "2023/10/09",
                "2023/11/03",
                "2023/11/23"
        };
        assertEquals(expected, MyDate.getNationalHoliday(2023));
    }
}