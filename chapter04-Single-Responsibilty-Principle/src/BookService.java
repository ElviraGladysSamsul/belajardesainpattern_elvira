import java.time.LocalDate;
import java.util.*;

// Entities
class Book {
    private int id; // ID buku
    private int authorId; // ID penulis buku
    private String name; // Judul buku
    private String publisherName; // Nama penerbit buku
    private LocalDate released; // Tanggal terbit buku

    // Getters dan setters untuk atribut buku

    // Getter untuk mendapatkan ID buku
    public int getId() {
        return id;
    }

    // Setter untuk mengatur ID buku
    public void setId(int id) {
        this.id = id;
    }

    // Getter untuk mendapatkan ID penulis buku
    public int getAuthorId() {
        return authorId;
    }

    // Setter untuk mengatur ID penulis buku
    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    // Getter untuk mendapatkan judul buku
    public String getName() {
        return name;
    }

    // Setter untuk mengatur judul buku
    public void setName(String name) {
        this.name = name;
    }

    // Getter untuk mendapatkan nama penerbit buku
    public String getPublisherName() {
        return publisherName;
    }

    // Setter untuk mengatur nama penerbit buku
    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    // Getter untuk mendapatkan tanggal terbit buku
    public LocalDate getReleased() {
        return released;
    }

    // Setter untuk mengatur tanggal terbit buku
    public void setReleased(LocalDate released) {
        this.released = released;
    }

    // Metode untuk merepresentasikan objek buku sebagai string
    @Override
    public String toString() {
        return "Buku{" +
                "id=" + id +
                ", IdPenulis=" + authorId +
                ", Judul='" + name + '\'' +
                ", NamaPenerbit='" + publisherName + '\'' +
                ", TanggalTerbit=" + released +
                '}';
    }
}

class Author {
    private int authorId; // ID penulis
    private String name; // Nama penulis

    // Getters dan setters untuk atribut penulis

    // Getter untuk mendapatkan ID penulis
    public int getAuthorId() {
        return authorId;
    }

    // Setter untuk mengatur ID penulis
    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    // Getter untuk mendapatkan nama penulis
    public String getName() {
        return name;
    }

    // Setter untuk mengatur nama penulis
    public void setName(String name) {
        this.name = name;
    }
}

// Interfaces
interface BookRepo {
    // Metode untuk mencari buku berdasarkan ID penulis dan nama buku
    Book findByAuthorIdAndBookName(int authorId, String bookName);

    // Metode untuk menyimpan buku
    void save(Book book);

    // Metode untuk mencari daftar buku berdasarkan ID
    List<Book> findByBookIds(List<Integer> bookIds);
}

interface AuthorRepo {
    // Metode untuk memeriksa keberadaan ID penulis
    boolean checkAuthorId(int authorId);

    // Metode untuk menyimpan penulis baru
    Author save(Author author);
}

// Repositories
class BookRepository implements BookRepo {
    private Map<Integer, Book> books = new HashMap<>();
    private static int counter = 0; // Deklarasi variabel statis di level kelas

    // Implementasi repositori buku

    // Metode untuk mencari buku berdasarkan ID penulis dan nama buku
    @Override
    public Book findByAuthorIdAndBookName(int authorId, String bookName) {
        for (Book book : books.values()) {
            if (book.getAuthorId() == authorId && book.getName().equals(bookName)) {
                return book;
            }
        }
        return null;
    }

    // Metode untuk menyimpan buku
    @Override
    public void save(Book book) {
        int id = generateUniqueId();
        book.setId(id);
        books.put(id, book);
    }

    // Metode untuk mencari daftar buku berdasarkan ID
    @Override
    public List<Book> findByBookIds(List<Integer> bookIds) {
        List<Book> foundBooks = new ArrayList<>();
        for (Integer bookId : bookIds) {
            Book book = books.get(bookId);
            if (book != null) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    // Metode untuk menghasilkan ID unik
    private int generateUniqueId() {
        return ++counter; // Menggunakan variabel statis counter
    }
}

class AuthorRepository implements AuthorRepo {
    private Map<Integer, Author> authors = new HashMap<>();

    // Implementasi repositori penulis

    // Metode untuk memeriksa keberadaan ID penulis
    @Override
    public boolean checkAuthorId(int authorId) {
        return authors.containsKey(authorId);
    }

    // Metode untuk menyimpan penulis baru
    @Override
    public Author save(Author author) {
        authors.put(author.getAuthorId(), author);
        return author;
    }
}

// Services
class AuthorService {
    private final AuthorRepo authorRepo;

    // Konstruktor AuthorService
    public AuthorService(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    // Metode untuk menyimpan penulis jika belum ada
    public void saveIfNotExist(int authorId) {
        boolean existedAuthor = authorRepo.checkAuthorId(authorId);
        if (!existedAuthor) {
            // Buat penulis baru dengan nama "Tidak diketahui" jika belum ada
            Author author = new Author();
            author.setName("Tidak diketahui");
            author.setAuthorId(authorId);
            authorRepo.save(author);
        }
    }
}

class BookService {
    private final BookRepo bookRepo;
    private final AuthorService authorService;

    // Konstruktor BookService
    public BookService(BookRepo bookRepo, AuthorService authorService) {
        this.bookRepo = bookRepo;
        this.authorService = authorService;
    }

    // Metode untuk menyimpan buku
    public void saveBook(int authorId, String bookName, String publisher) throws Exception {
        validateBook(authorId, bookName);
        authorService.saveIfNotExist(authorId);
        String publisherName = getPublisherName(publisher);

        // Buat objek buku dan simpan ke repositori buku
        Book book = new Book();
        book.setAuthorId(authorId);
        book.setName(bookName);
        book.setPublisherName(publisherName);
        bookRepo.save(book);
    }

    // Metode untuk mendapatkan nama penerbit, jika tidak ada, set sebagai "Anonim"
    private String getPublisherName(String publisher) {
        return publisher != null ? publisher : "Anonim";
    }

    // Metode untuk validasi buku sebelum menyimpan
    private void validateBook(int authorId, String bookName) throws Exception {
        if (bookName == null)
            throw new Exception("Judul Buku Kosong");
        // Cek apakah buku dengan penulis dan judul yang sama sudah ada
        Book bookByAuthorIdAndBookName = bookRepo.findByAuthorIdAndBookName(authorId, bookName);
        if (bookByAuthorIdAndBookName != null) {
            throw new Exception("Buku Duplikat");
        }
    }

    // Metode untuk merilis buku-buku dengan ID yang diberikan berdasarkan penulis
    public Map<Integer, List<Book>> releaseBooksByAuthor(List<Integer> bookIds) {
        // Update tanggal terbit buku-buku dengan ID yang diberikan
        List<Book> books = updateReleaseBooks(bookIds);
        // Kelompokkan buku-buku berdasarkan penulis
        return groupBooksByAuthor(books);
    }

    // Metode untuk mengelompokkan buku-buku berdasarkan penulis
    private Map<Integer, List<Book>> groupBooksByAuthor(List<Book> books) {
        Map<Integer, List<Book>> booksByAuthor = new HashMap<>();
        for (Book book : books) {
            int authorId = book.getAuthorId();
            List<Book> bookList = booksByAuthor.getOrDefault(authorId, new ArrayList<>());
            bookList.add(book);
            booksByAuthor.put(authorId, bookList);
        }
        return booksByAuthor;
    }

    // Metode untuk memperbarui tanggal terbit buku-buku dengan ID yang diberikan
    private List<Book> updateReleaseBooks(List<Integer> bookIds) {
        List<Book> books = bookRepo.findByBookIds(bookIds);
        for (Book book : books) {
            book.setReleased(LocalDate.now());
        }
        return books;
    }
}

// Program Utama
class App {
    public static void main(String[] args) throws Exception {
        // Inisialisasi repo dan service
        BookRepo bookRepo = new BookRepository();
        AuthorRepo authorRepo = new AuthorRepository();
        AuthorService authorService = new AuthorService(authorRepo);
        BookService bookService = new BookService(bookRepo, authorService);

        // Menyimpan buku
        bookService.saveBook(1, "Hujan", "Gramedia");
        bookService.saveBook(2, "Laskar Pelangi", null);
        bookService.saveBook(3, "Bumi Manusia", "Lentera Dipantara");

        // Mengeluarkan buku berdasarkan penulis
        Map<Integer, List<Book>> booksByAuthor = bookService.releaseBooksByAuthor(Arrays.asList(1, 2, 3));

        // Mencetak output dengan setiap item pada baris baru
        System.out.println("{");
        for (Map.Entry<Integer, List<Book>> entry : booksByAuthor.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue() + ",");
        }
        System.out.println("}");
    }
}