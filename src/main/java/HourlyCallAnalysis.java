import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class HourlyCallAnalysis {
    private List<Call> calls;
    private int hourOfDay;
    /*private int numberOfCallsAttempted = 0;
    private int numberOfCallsAnswered = 0;
    private int numberOfCallsAbandoned = 0;
    private double averageWaitTime = 0;*/

    public HourlyCallAnalysis(List<Call> calls, int hourOfDay)
    {
        this.calls = calls.stream().filter(call -> call.getStartTime().getHour()==hourOfDay).collect(Collectors.toList());
        this.hourOfDay = hourOfDay;

    }

    public int getHourOfDay() {
        return hourOfDay;
    }

    public int getNumberOfCallsAttempted() {
        return calls.size();
    }

    public int getNumberOfCallsAnswered() {
        int numberOfCallAsnswered=0;
        for(Call call : calls) {
            if(call.getAnswered()!=null)
                numberOfCallAsnswered+=1;
        }
        return numberOfCallAsnswered;
    }

    public int getNumberOfCallsAbandoned() {
        int numberOfCallsAbandoned=0;
        for(Call call : calls) {
            if(call.getAbandoned()!=null)
                numberOfCallsAbandoned+=1;
        }
        return numberOfCallsAbandoned;
    }

    public double averageWaitTime() {
        double totTime = 0;
        List<Call> callsAnswered = calls.stream().filter(call -> call.getAnswered() != null)
                .collect(Collectors.toList());
        //New
        if(callsAnswered.isEmpty()){
            return 0;
        }
        else {
            for (Call call : callsAnswered) {
                totTime += Duration.between(call.getStartTime(), call.getAnswered()).toMinutes();
            }
            return totTime / callsAnswered.size();
        }
    }


}
