import java.util.concurrent.atomic.AtomicInteger;

public class Book {
    private static final AtomicInteger COUNTER = new AtomicInteger(1);

    private final int id;
    private String title;
    private String author;

    public Book(String title, String author) {
        this.id = COUNTER.getAndIncrement();
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return String.format("Book{id=%d, title='%s', author='%s'}", id, title, author);
    }
}
