package other;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.List;
import java.util.Map;

public class RunProgramList {

    public static void main(String[] args) {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();

        // Get the start time of the Java Virtual Machine
        long startTime = runtimeMXBean.getStartTime();
        System.out.println("JVM Start Time: " + startTime);

        // Get the input arguments passed to the Java Virtual Machine
        List<String> inputArguments = runtimeMXBean.getInputArguments();
        System.out.println("JVM Input Arguments: " + inputArguments);

        // Additional information about the runtime environment
        Map<String, String> systemProperties = runtimeMXBean.getSystemProperties();
        System.out.println("System Properties: " + systemProperties);
    }

}
