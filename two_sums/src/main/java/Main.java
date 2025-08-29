import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Enter numbers separated by spaces :");
            final String[] input = scanner.nextLine().trim().split("\\s+");
            final int[] numbers = Arrays.stream(input)
                    .mapToInt(Integer::parseInt)
                    .toArray();

            System.out.println("Enter the target sum:");
            final int target = scanner.nextInt();

            Optional<int[]> result = findTwoSum(numbers, target);


            System.out.println("\nResult:");
            if (result.isPresent()) {
                int[] pair = result.get();
                System.out.printf("%d + %d = %d%n", pair[0], pair[1], target);
            } else {
                System.out.println("No two numbers add up to the target sum.");
            }
        }
    }

    private static Optional<int[]> findTwoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return Optional.of(new int[]{numbers[left], numbers[right]});
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return Optional.empty();
    }
}
