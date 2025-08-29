import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Enter a text:");
            final String input = scanner.nextLine();

            System.out.println("Enter the number of occurrences (n):");
            final int targetCount = scanner.nextInt();

            final String[] words = input.split("\\s+");

            final Map<String, Integer> wordFrequency = new HashMap<>();
            for (String word : words) {
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }

            System.out.println("\nResult:");
            wordFrequency.entrySet().stream()
                    .filter(entry -> entry.getValue() == targetCount)
                    .map(Map.Entry::getKey)
                    .forEach(System.out::println);

            if (wordFrequency.values().stream().noneMatch(v -> v == targetCount)) {
                System.out.println("No word found with the given frequency.");
            }
        }
    }
}
