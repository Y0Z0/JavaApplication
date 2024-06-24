import org.junit.Test;

import static org.junit.Assert.*;

public class SampleTest {
    @Test
    public void TodaysTest(){
        assertEquals("2022/11/12", Sample.addDay("2022/11/11",1));
        assertEquals("2022/11/22", Sample.addDay("2022/11/11",11));
    }

}