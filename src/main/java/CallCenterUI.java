
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CallCenterUI {
    public List<Call> readFile() throws IOException {
        List<Call> callsList = new ArrayList<>();
        String nextLineCharacter = System.lineSeparator();
        String homeFolder = System.getProperty("user.home");
        Path path = Paths.get(homeFolder+"/call-log.csv");
        //System.out.println(path.toString());

        Scanner scanner = new Scanner(path);
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if(line.startsWith(",")) break;
            if(!line.startsWith("CallID")) {
                String[] fields =line.split(",", -1);
                LocalTime field1 = null;
                LocalTime field2 = null;
                LocalTime field3 = null;
                LocalTime field4 = null;
                if (!fields[1].isEmpty()) field1 = LocalTime.parse(fields[1]);
                if (!fields[2].isEmpty()) field2 = LocalTime.parse(fields[2]);
                if (!fields[3].isEmpty()) field3 = LocalTime.parse(fields[3]);
                if (!fields[4].isEmpty()) field4 = LocalTime.parse(fields[4]);
                Call call = new Call(Integer.parseInt(fields[0]), field1, field2, field3, field4);
                //System.out.println(call.toString());
                callsList.add(call);
            }
        }
        return callsList;
    }

}
