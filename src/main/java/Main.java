import javax.xml.crypto.Data;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        List<Call> callsList = new ArrayList<>();
        CallCenterUI ui = new CallCenterUI();
        DatabaseUtils utils = new DatabaseUtils();

        //read file
        callsList = ui.readFile();

        //Read to database
        //utils.saveCallData(callsList);
        /*Call call = callsList.get(0);
        System.out.println("Start " +call.getStartTime());
        System.out.println("Answered " + call.getAnswered());
        System.out.println("Diff " + Duration.between(call.getStartTime(),call.getAnswered()).toMinutes());*/

        //run for 23 hours
        //for (0 to 23)
        /*HourlyCallAnalysis hca = new HourlyCallAnalysis(callsList, 7);
        System.out.println(hca.getNumberOfCallsAttempted());
        System.out.println(hca.getNumberOfCallsAnswered());
        System.out.println(hca.getNumberOfCallsAbandoned());
        System.out.println(hca.averageWaitTime());*/

        utils.saveAnalysisData(callsList);

        //System.out.println(callsList);

    }
}
