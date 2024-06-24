import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Book class representing a book
class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

// BookGateway interface defining operations related to books
interface BookGateway {
    List<Book> getAllBooks();
    List<Book> getBooksByAuthorName(String name);
}

// BookMySqlGateway implementing BookGateway
class BookMySqlGateway implements BookGateway {
    @Override
    public List<Book> getAllBooks() {
        return Arrays.asList(new Book("Math"), new Book("English"));
    }

    @Override
    public List<Book> getBooksByAuthorName(String name) {
        // Dummy implementation, replace with actual logic
        return Arrays.asList(new Book("Math"));
    }
}

// BookService using BookGateway via constructor injection
class BookService {
    private final BookGateway bookGateway;

    public BookService(BookGateway bookGateway) {
        this.bookGateway = bookGateway;
    }

    public List<String> getBookTitles() {
        List<Book> allBookTitles = bookGateway.getAllBooks();
        return allBookTitles.stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }
}

// AuthorService using BookGateway via constructor injection
class AuthorService {
    private final BookGateway bookGateway;

    public AuthorService(BookGateway bookGateway) {
        this.bookGateway = bookGateway;
    }

    public List<String> getBookTitlesByAuthorName(String authorName) {
        List<Book> allBookTitles = bookGateway.getBooksByAuthorName(authorName);
        return allBookTitles.stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }
}

// Main class demonstrating the usage of BookService and AuthorService
public class BookManagement {
    public static void main(String[] args) {
        BookGateway bookGateway = new BookMySqlGateway();

        BookService bookService = new BookService(bookGateway);
        System.out.println("All Book Titles: " + bookService.getBookTitles());

        AuthorService authorService = new AuthorService(bookGateway);
        System.out.println("Books by Author 'ferry': " + authorService.getBookTitlesByAuthorName("ferry"));
    }
}
