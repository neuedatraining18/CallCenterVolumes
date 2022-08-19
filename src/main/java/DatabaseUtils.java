import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DatabaseUtils {

    public void saveCallData (List<Call> calls) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/calllogs","root", "c0nygre");

        calls.stream().forEach( call -> {
            try {
                Statement statement = connection.createStatement();

                String startTime=null;
                String answered=null;
                String abandoned=null;
                String endTime=null;

                if(call.getStartTime() != null) startTime = "'" +call.getStartTime()+ "'";
                if(call.getAnswered() != null) answered = "'" +call.getAnswered()+ "'";
                if(call.getAbandoned() != null) abandoned = "'" +call.getAbandoned()+ "'";
                if(call.getEndTime() != null) endTime = "'" +call.getEndTime()+ "'";

                String command = "INSERT INTO calllog (callID, startTime, answered, abandoned, endTime) VALUES (" +
                        call.getCallID() + "," +
                        startTime + "," +
                        answered + "," +
                        abandoned + "," +
                        endTime + ")";
                //System.out.println(command);
                statement.execute(command);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        connection.close();
    }

    public void saveAnalysisData (List<Call> calls) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/calllogs","root", "c0nygre");
        HourlyCallAnalysis callAnalysis;
        for(int i=0; i<24; i++) {
            try {
                Statement statement = connection.createStatement();
                callAnalysis = new HourlyCallAnalysis(calls,i);
                String command = "INSERT INTO hourlycallanalysis (hourOfDay, numberOfCallsAttempted, numberOfCallsAnswered, numberOfCallsAbandoned, averageWaitTime ) " +
                        "VALUES (" +
                        callAnalysis.getHourOfDay() + "," +
                        callAnalysis.getNumberOfCallsAttempted() + "," +
                        callAnalysis.getNumberOfCallsAnswered() + "," +
                        callAnalysis.getNumberOfCallsAbandoned() + "," +
                        callAnalysis.averageWaitTime() + ")";
                //System.out.println(command);
                statement.execute(command);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Hourly Analysis upload complete");
        connection.close();
    }
}
