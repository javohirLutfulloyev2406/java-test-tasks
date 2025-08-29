import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Enter sorted numbers :");
            final String[] input = scanner.nextLine().trim().split("\\s+");
            final int[] numbers = Arrays.stream(input)
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int uniqueCount = removeDuplicates(numbers);

            System.out.println("\nResult:");
            for (int i = 0; i < uniqueCount; i++) {
                System.out.print(numbers[i] + " ");
            }
        }
    }

    private static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int uniqueIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[uniqueIndex]) {
                uniqueIndex++;
                nums[uniqueIndex] = nums[i];
            }
        }
        return uniqueIndex + 1;
    }
}
