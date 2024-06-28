import java.util.HashSet;
import java.util.Set;

public class SuffixOfWords {
    public static int solution(String[] words) {
        int count = 0;
        int n = words.length;
        Set<String> checkedWords = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (!checkedWords.contains(words[i] + words[j])) {
                    if (words[i].endsWith(words[j]) || words[j].endsWith(words[i])) {
                        count++;
                    }
                    checkedWords.add(words[i] + words[j]);
                    checkedWords.add(words[j] + words[i]);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String[] words = {"back", "backdoor", "gammon", "backgammon", "comeback", "come", "door"};
        System.out.println(solution(words)); // Output should be 3
    }
}

