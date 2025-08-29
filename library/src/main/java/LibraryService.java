import java.util.*;

public class LibraryService {
    private final Map<Integer, Book> books = new HashMap<>();

    /**
     * Adds a new book to the library.
     */
    public Book addBook(String title, String author) {
        Book book = new Book(title, author);
        books.put(book.getId(), book);
        return book;
    }

    /**
     * Returns all books in the library.
     */
    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    /**
     * Returns a book by its ID.
     */
    public Optional<Book> getBookById(int id) {
        return Optional.ofNullable(books.get(id));
    }

    /**
     * Removes a book by its ID.
     */
    public boolean removeBook(int id) {
        return books.remove(id) != null;
    }
}
