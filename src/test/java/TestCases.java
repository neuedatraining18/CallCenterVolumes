import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TestCases {
    //List<Call> calls = new ArrayList<>();

    @Test
    public void TestAverageWaitTimeZero() {
        List<Call> calls = new ArrayList();
        calls.add(new Call(1111, LocalTime.parse("07:30"),null, LocalTime.parse("07:45"), null));
        HourlyCallAnalysis callAnalysis = new HourlyCallAnalysis(calls,7);
        Assertions.assertEquals(callAnalysis.averageWaitTime(),0.0);
        //assertThrow();
    }

    @Test
    public void TestAverageWaitTimeTrue() {
        List<Call> calls = new ArrayList();
        calls.add(new Call(1111, LocalTime.parse("07:30"),LocalTime.parse("07:40"), null, LocalTime.parse("07:45")));
        HourlyCallAnalysis callAnalysis = new HourlyCallAnalysis(calls,7);
        Assertions.assertEquals(callAnalysis.averageWaitTime(),10);
        //assertThrow();
    }

}
