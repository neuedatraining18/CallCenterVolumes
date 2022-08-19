import java.time.LocalTime;
import java.util.Objects;

public class Call {
    int callID;
    LocalTime startTime;
    LocalTime answered;
    LocalTime abandoned;
    LocalTime endTime;

    public Call(int callID, LocalTime startTime, LocalTime answered, LocalTime abandoned, LocalTime endTime) {
        this.callID = callID;
        this.startTime = startTime;
        this.answered = answered;
        this.abandoned = abandoned;
        this.endTime = endTime;
    }

    public int getCallID() {
        return callID;
    }

    public void setCallID(int callID) {
        this.callID = callID;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getAnswered() {
        return answered;
    }

    public void setAnswered(LocalTime answered) {
        this.answered = answered;
    }

    public LocalTime getAbandoned() {
        return abandoned;
    }

    public void setAbandoned(LocalTime abandoned) {
        this.abandoned = abandoned;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Call{" +
                "callID=" + callID +
                ", startTime=" + startTime +
                ", answered=" + answered +
                ", abandoned=" + abandoned +
                ", endTime=" + endTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Call call = (Call) o;
        return callID == call.callID && Objects.equals(startTime, call.startTime) && Objects.equals(answered, call.answered) && Objects.equals(abandoned, call.abandoned) && Objects.equals(endTime, call.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(callID, startTime, answered, abandoned, endTime);
    }
}
