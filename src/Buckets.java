import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Buckets {

    public static String solution(String[] commands) {
        Map<String, Set<String>> buckets = new HashMap<>();
        String currentBucket = "";

        for (String command : commands) {
            if (command.startsWith("goto ")) {
                currentBucket = command.substring(5);
                // Initialize the bucket if it does not exist
                buckets.putIfAbsent(currentBucket, new HashSet<>());
            } else if (command.startsWith("create ")) {
                String fileName = command.substring(7);
                if (!currentBucket.isEmpty()) {
                    // Add the file to the current bucket
                    buckets.get(currentBucket).add(fileName);
                }
            }
        }

        // Find the bucket with the maximum number of files
        String largestBucket = null;
        int maxFiles = -1;

        for (Map.Entry<String, Set<String>> entry : buckets.entrySet()) {
            int size = entry.getValue().size();
            if (size > maxFiles) {
                maxFiles = size;
                largestBucket = entry.getKey();
            }
        }

        return largestBucket;
    }

    public static void main(String[] args) {
        String[] commands = {
                "goto bucketA", "create fileA", "create fileB", "create fileA",
                "goto bucketB", "goto bucketC", "create fileA", "create fileB", "create fileC"
        };
        System.out.println(solution(commands));  // Output should be "bucketC"
    }
}

