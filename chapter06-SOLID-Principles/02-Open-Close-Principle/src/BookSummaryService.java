import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Interface BookRepo untuk mendefinisikan operasi dasar untuk mengakses buku
interface BookRepo {
    List<Book> getBooksByCategory(String category);
    List<Book> getBooksByAuthor(String author);
    List<Book> getBooksByReleaseDate(String releaseDate);
    List<Book> getAllBooks();
}

// Class Book untuk merepresentasikan buku
class Book {
    private String category;
    private String author;
    private double price;
    private String releaseDate;

    // Constructor, getter, dan setter untuk Book
    public Book(String category, String author, double price, String releaseDate) {
        this.category = category;
        this.author = author;
        this.price = price;
        this.releaseDate = releaseDate;
    }

    public String getCategory() {
        return category;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
}

// Class BookReq untuk merepresentasikan permintaan ringkasan buku
class BookReq {
    private String groupingType;
    private String groupingValue;

    // Constructor untuk BookReq
    public BookReq(String groupingType, String groupingValue) {
        this.groupingType = groupingType;
        this.groupingValue = groupingValue;
    }

    public String getGroupingType() {
        return groupingType;
    }

    public String getGroupingValue() {
        return groupingValue;
    }
}

// Interface BookGroupStrategy untuk mendefinisikan strategi pengelompokan buku
interface BookGroupStrategy {
    BookSummary getBookSummary(BookReq req) throws Exception;
}

// Class BookSummary untuk merepresentasikan hasil ringkasan buku
class BookSummary {
    private String groupName;
    private int totalBooks;
    private double totalBookPrice;

    // Constructor untuk BookSummary
    public BookSummary(String groupName, int totalBooks, double totalBookPrice) {
        this.groupName = groupName;
        this.totalBooks = totalBooks;
        this.totalBookPrice = totalBookPrice;
    }

    public String getGroupName() {
        return groupName;
    }

    public int getTotalBooks() {
        return totalBooks;
    }

    public double getTotalBookPrice() {
        return totalBookPrice;
    }
}

// Class BookSummaryByCategory untuk strategi pengelompokan berdasarkan kategori
class BookSummaryByCategory implements BookGroupStrategy {
    private final BookRepo bookRepo;

    // Constructor untuk BookSummaryByCategory
    public BookSummaryByCategory(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public BookSummary getBookSummary(BookReq req) {
        List<Book> books = bookRepo.getBooksByCategory(req.getGroupingValue());
        double totalPrice = books.stream().mapToDouble(Book::getPrice).sum();
        return new BookSummary("Kategori", books.size(), totalPrice);
    }
}

// Class BookSummaryByReleaseDate untuk strategi pengelompokan berdasarkan tanggal rilis
class BookSummaryByReleaseDate implements BookGroupStrategy {
    private final BookRepo bookRepo;

    // Constructor untuk BookSummaryByReleaseDate
    public BookSummaryByReleaseDate(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public BookSummary getBookSummary(BookReq req) {
        List<Book> books = bookRepo.getBooksByReleaseDate(req.getGroupingValue());
        double totalPrice = books.stream().mapToDouble(Book::getPrice).sum();
        return new BookSummary("Tanggal Rilis", books.size(), totalPrice);
    }
}

// Class BookSummaryByAuthor untuk strategi pengelompokan berdasarkan penulis
class BookSummaryByAuthor implements BookGroupStrategy {
    private final BookRepo bookRepo;

    // Constructor untuk BookSummaryByAuthor
    public BookSummaryByAuthor(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public BookSummary getBookSummary(BookReq req) {
        List<Book> books = bookRepo.getBooksByAuthor(req.getGroupingValue());
        double totalPrice = books.stream().mapToDouble(Book::getPrice).sum();
        return new BookSummary("Penulis", books.size(), totalPrice);
    }
}

// Class BookRepoImpl untuk implementasi BookRepo dengan data dummy
class BookRepoImpl implements BookRepo {
    private List<Book> books;

    // Constructor untuk BookRepoImpl dengan beberapa data dummy
    public BookRepoImpl() {
        books = new ArrayList<>();
        books.add(new Book("Fiksi", "Elvira", 15000, "2020-02-03"));
        books.add(new Book("Non-Fiksi", "Reval", 12000, "2012-04-11"));
        books.add(new Book("Fiksi", "Liza", 7000, "2021-1-24"));
        books.add(new Book("Sains", "Elvira", 3000, "2013-02-19"));
        books.add(new Book("Non-Fiksi", "Gladys", 8000, "2019-08-15"));
    }

    @Override
    public List<Book> getBooksByCategory(String category) {
        return books.stream()
                .filter(book -> book.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getBooksByReleaseDate(String releaseDate) {
        return books.stream()
                .filter(book -> book.getReleaseDate().equalsIgnoreCase(releaseDate))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }
}

// Class BookGroupFactory untuk membuat strategi pengelompokan
class BookGroupFactory {
    private final BookRepo bookRepo;

    // Constructor untuk BookGroupFactory
    public BookGroupFactory(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    // Method untuk membangun strategi berdasarkan jenis pengelompokan
    public BookGroupStrategy buildStrategy(String grouping) throws Exception {
        if ("kategori".equalsIgnoreCase(grouping)) {
            return new BookSummaryByCategory(bookRepo);
        } else if ("tanggalRilis".equalsIgnoreCase(grouping)) {
            return new BookSummaryByReleaseDate(bookRepo);
        } else if ("penulis".equalsIgnoreCase(grouping)) {
            return new BookSummaryByAuthor(bookRepo);
        } else {
            throw new Exception("Tidak ada pengelompokan yang ditemukan");
        }
    }
}

// Class BookSummaryService untuk mencetak ringkasan buku
class BookSummaryService {
    private final BookRepo bookRepo;

    // Constructor untuk BookSummaryService
    public BookSummaryService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    // Method untuk mencetak ringkasan buku berdasarkan permintaan
    public void printSummary(BookReq req) throws Exception {
        BookGroupFactory bookGroupFactory = new BookGroupFactory(bookRepo);
        BookGroupStrategy strategy = bookGroupFactory.buildStrategy(req.getGroupingType());

        BookSummary books = strategy.getBookSummary(req);
        System.out.println("Nama kelompok = " + books.getGroupName());
        System.out.println("Total buku = " + books.getTotalBooks());
        System.out.println("Total harga = " + books.getTotalBookPrice());
        System.out.println();
    }
}

// Main class untuk demonstrasi penggunaan
class Main {
    public static void main(String[] args) {
        try {
            BookRepo bookRepo = new BookRepoImpl(); // Implementasi BookRepo
            BookSummaryService summaryService = new BookSummaryService(bookRepo);

            // Gunakan nilai pengelompokan yang sesuai dengan data yang ada
            BookReq reqCategory = new BookReq("kategori", "Fiksi");
            summaryService.printSummary(reqCategory);

            BookReq reqReleaseDate = new BookReq("tanggalRilis", "2012-04-11");
            summaryService.printSummary(reqReleaseDate);

            BookReq reqAuthor = new BookReq("penulis", "Elvira");
            summaryService.printSummary(reqAuthor);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
