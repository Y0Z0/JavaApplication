import org.junit.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class getDaysBetweenDatesTest {

    @Test
    public void testGetDaysBetweenDates() {
        Date date1_1 = GetDate.validateAndParseDate("2023/03/04");
        Date date1_2 = GetDate.validateAndParseDate("2023/03/06");
        assertEquals(2, GetDate.getDayBetweenDates(date1_1, date1_2));
        Date date2_1 = GetDate.validateAndParseDate("2023/03/31");
        Date date2_2 = GetDate.validateAndParseDate("2023/03/30");
        assertEquals(1, GetDate.getDayBetweenDates(date2_1, date2_2));
    }
}