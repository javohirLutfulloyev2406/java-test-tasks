import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final LibraryService library = new LibraryService();

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = readInt("Choose an option: ");

            switch (choice) {
                case 1 -> addBook();
                case 2 -> listBooks();
                case 3 -> getBookById();
                case 4 -> removeBook();
                case 0 -> {
                    System.out.println("Exiting... Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option, try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n=== Library Menu ===");
        System.out.println("1. Add a book");
        System.out.println("2. List all books");
        System.out.println("3. Get book by ID");
        System.out.println("4. Remove book by ID");
        System.out.println("0. Exit");
    }

    private static void addBook() {
        System.out.print("Enter book title : ");
        String title = scanner.nextLine();

        System.out.print("Enter author name: ");
        String author = scanner.nextLine();

        Book book = library.addBook(title, author);
        System.out.println("Book added: " + book);
    }

    private static void listBooks() {
        List<Book> books = library.getAllBooks();
        if (books.isEmpty()) {
            System.out.println("Library is empty.");
        } else {
            books.forEach(System.out::println);
        }
    }

    private static void getBookById() {
        int id = readInt("Enter book ID: ");
        library.getBookById(id)
                .ifPresentOrElse(
                        book -> System.out.println("Found: " + book),
                        () -> System.out.println("Book not found.")
                );
    }

    private static void removeBook() {
        int id = readInt("Enter book ID to remove: ");
        boolean removed = library.removeBook(id);
        if (removed) {
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    private static int readInt(String message) {
        while (true) {
            System.out.print(message);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, try again.");
            }
        }
    }
}
