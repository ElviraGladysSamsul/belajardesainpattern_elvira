**Dependency Inversion Principle**
Dependency Inversion Principle (DIP) adalah salah satu prinsip dalam SOLID yang menyatakan bahwa modul tingkat tinggi tidak boleh bergantung pada modul tingkat rendah. Keduanya harus bergantung pada abstraksi. Abstraksi tidak boleh bergantung pada detail. Detail harus bergantung pada abstraksi.

**Analisis BookManagement:**
1. **Kelas Book:**
Kelas ini mewakili buku dengan atribut title. Kelas ini cukup sederhana, hanya terdiri dari konstruktor dan metode getTitle.
3. **Interface BookGateway:**
Interface ini mendefinisikan operasi dasar yang diharapkan dari semua sumber data buku: getAllBooks() dan getBooksByAuthorName(String name).
5. **Implementasi BookMySqlGateway:**
Kelas ini mengimplementasikan interface BookGateway dan menyediakan implementasi spesifik untuk mendapatkan daftar buku dan daftar buku berdasarkan nama penulis. Pada contoh ini, data buku disimulasikan dengan daftar statis.
7. **Kelas BookService:**
Kelas ini menggunakan BookGateway melalui injeksi konstruktor. Metode getBookTitles() mengambil semua buku dari BookGateway dan mengembalikan daftar judul buku.
9. **Kelas AuthorService:**
Kelas ini juga menggunakan BookGateway melalui injeksi konstruktor. Metode getBookTitlesByAuthorName(String authorName) mengambil buku berdasarkan nama penulis dari BookGateway dan mengembalikan daftar judul buku.
11. **Kelas BookManagement (Main class):**
Kelas ini adalah titik masuk aplikasi. Membuat instance dari BookMySqlGateway, BookService, dan AuthorService. Kemudian, menggunakan BookService untuk mendapatkan semua judul buku dan AuthorService untuk mendapatkan judul buku berdasarkan nama penulis.


**Analisis PaymentExample :**
1. **Interface PaymentGateway:**
Interface ini mendefinisikan operasi dasar yang diharapkan dari semua metode pembayaran: processPayment(double amount) dan getPaymentStatus(int transactionId).
2. **Implementasi CreditCardPayment dan PayPalPayment:**
Kelas CreditCardPayment dan PayPalPayment mengimplementasikan interface PaymentGateway dan menyediakan implementasi spesifik untuk masing-masing metode pembayaran.
3. **Kelas PaymentService:**
Kelas ini menggunakan PaymentGateway melalui injeksi konstruktor. Hal ini memungkinkan PaymentService untuk berfungsi dengan berbagai metode pembayaran tanpa bergantung pada detail implementasi spesifik dari masing-masing metode pembayaran.
4. **Kelas PaymentExample:**
Kelas ini membuat objek CreditCardPayment dan PayPalPayment, kemudian menggunakan PaymentService untuk melakukan pembayaran dan memeriksa status pembayaran.